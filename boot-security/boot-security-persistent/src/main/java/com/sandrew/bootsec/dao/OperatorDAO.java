package com.sandrew.bootsec.dao;

import com.sandrew.bootsec.bean.OperatorInfo;
import com.sandrew.bootsec.bean.SignTaskVO;
import com.sandrew.bootsec.core.common.Constants;
import com.sandrew.bootsec.core.exception.DAOException;
import com.sandrew.bury.Session;
import com.sandrew.bury.SqlSessionFactory;
import com.sandrew.bury.bean.PageResult;
import com.sandrew.bury.callback.POCallBack;
import com.sandrew.bury.util.Parameters;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Repository
public class OperatorDAO
{
    @Resource
    SqlSessionFactory sessionFactory;

    public PageResult<SignTaskVO> signTaskPageQuery(String operatorNo, Integer isSigned, String startTime, String endTime, int limit, int curPage) throws DAOException
    {
        Parameters params = new Parameters();
        params.addParam(operatorNo);
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT tp.product_code, tp.product_name, tp.fund_code, tp.fund_name, t.is_signed, t.sign_time FROM tt_project tp LEFT JOIN (\n");
        sql.append("    SELECT\n");
        sql.append("        tor.operator_no,\n");
        sql.append("        tor.operator_name,\n");
        sql.append("        tps.product_id,\n");
        sql.append("        tps.is_signed,\n");
        sql.append("        tps.sign_time,\n");
        sql.append("        tps.is_send,\n");
        sql.append("        tps.send_time\n");
        sql.append("    FROM\n");
        sql.append("        tr_product_sign tps\n");
        sql.append("        JOIN tt_operator tor ON tps.operator_id = tor.operator_id\n");
        sql.append("    WHERE\n");
        sql.append("        tor.operator_no = ?\n");
        sql.append(") t ON tp.product_id = t.product_id\n");
        sql.append("WHERE 1 = 1\n");
        if (StringUtils.isNotEmpty(startTime))
        {
            //            sql.append("AND tp.create_date >= STR_TO_DATE('" + startTime + " 00:00:00', '%Y-%m-%d %H:%i:%S')\n");
            sql.append("AND tp.create_date >= STR_TO_DATE(?, '%Y-%m-%d %H:%i:%S')\n");
            params.addParam(startTime + " 00:00:00");
        }
        if (StringUtils.isNotEmpty(endTime))
        {
            //            sql.append("AND tp.create_date <= STR_TO_DATE('" + endTime + " 23:59:59', '%Y-%m-%d %H:%i:%S')\n");
            sql.append("AND tp.create_date <= STR_TO_DATE(?, '%Y-%m-%d %H:%i:%S')\n");
            params.addParam(endTime + " 23:59:59");
        }
        if (null != isSigned && isSigned.equals(Constants.IF_TYPE_YES))
        {
            sql.append("AND t.is_signed = " + Constants.IF_TYPE_YES);
        }
        else if (null != isSigned && isSigned.equals(Constants.IF_TYPE_NO))
        {
            sql.append("AND (t.is_signed <> " + Constants.IF_TYPE_YES + " OR t.is_signed IS NULL)");
        }
        sql.append(" ORDER BY tp.create_date DESC");
        Session session = sessionFactory.openSession();
        return session.pageQuery(sql.toString(), params.getParams(), new POCallBack<>(SignTaskVO.class), limit, curPage);
    }

    /**
     *  根据经办人代码获取经办人,如不传经办人代码则查询全部
     * @param operatorNo
     * @return
     */
    public List<OperatorInfo> getOpreatorByNo(String operatorNo)
    {
        Parameters params = new Parameters();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT\n");
        sql.append("    op.operator_id,\n");
        sql.append("    op.operator_no AS operator_code,\n");
        sql.append("    op.operator_name,\n");
        sql.append("    op.card_type,\n");
        sql.append("    op.card_no,\n");
        sql.append("    us.email,\n");
        sql.append("    us.mobile,\n");
        sql.append("    us.app_id\n");
        sql.append("FROM\n");
        sql.append("tt_operator op\n");
        sql.append("JOIN tm_user us ON op.operator_no = us.user_code\n");
        sql.append("WHERE\n");
        sql.append("op.is_delete = " + Constants.IF_TYPE_NO + "\n");
        sql.append("AND us.is_delete = " + Constants.IF_TYPE_NO + "\n");
        sql.append("AND us.user_status = " + Constants.STATUS_ENABLE + "\n");
        sql.append("AND op.status = " + Constants.STATUS_ENABLE + "\n");
        if (StringUtils.isNotEmpty(operatorNo))
        {
            sql.append("AND op.operator_no = ?");
            params.addParam(operatorNo);
        }
        Session session = sessionFactory.openSession();
        return session.select(sql.toString(), params.getParams(), new POCallBack<>(OperatorInfo.class));
    }
}
