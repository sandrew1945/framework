package com.sandrew.bootsec.dao;

import com.sandrew.bootsec.bean.*;
import com.sandrew.bootsec.core.common.Constants;
import com.sandrew.bootsec.core.exception.DAOException;
import com.sandrew.bootsec.model.TtInvestorPO;
import com.sandrew.bury.Session;
import com.sandrew.bury.SqlSessionFactory;
import com.sandrew.bury.bean.PageResult;
import com.sandrew.bury.callback.POCallBack;
import com.sandrew.bury.util.Parameters;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 预约信息相关DAO
 */
@Slf4j
@Repository
public class AppointmentDAO {
    @Resource
    SqlSessionFactory sessionFactory;

    public PageResult<AppointmentInfo> getAppointmentInfo(
            String operatorCode,
            String status,
            Date beginDate,
            Date endDate,
            String productName,
            int pageSize,
            int curPage)
            throws DAOException {

        Session session = sessionFactory.openSession();

        StringBuilder sql = new StringBuilder();

        sql.append(
                "SELECT a.appointment_id,a.investor_id,a.investor_name,a.operator_code,a.operator_id,a.product_id,");
        sql.append(
                "a.operator_name,a.appointment_time,p.product_code,p.fund_code,p.fund_name as product_name,o.status,o.order_id,i.ito_account as investor_account ");
        sql.append("FROM tt_appointment a ");
        sql.append("LEFT JOIN tt_project p ON a.product_id = p.product_id ");
        sql.append("LEFT JOIN tt_order o ON a.appointment_id = o.appointment_id ");
        sql.append("LEFT JOIN tt_investor i ON a.investor_id = i.investor_id ");
        sql.append("WHERE a.operator_code= ? ");

        Parameters params = new Parameters();

        params.addParam(operatorCode);

        if (status != null && !"".equals(status)) {
            sql.append(" and o.status= ?");
            params.addParam(status);
        }

        if (beginDate != null) {
            sql.append(" and a.appointment_time >= ?");
            params.addParam(beginDate);
        }

        if (endDate != null) {
            sql.append(" and a.appointment_time <= ?");
            params.addParam(endDate);
        }

        if (StringUtils.isNotEmpty(productName)) {
            sql.append(" and p.fund_name like ? ");
            params.addLikeParam(productName);
        }
        sql.append(" ORDER BY a.appointment_id DESC");

        return session.pageQuery(
                sql.toString(),
                params.getParams(),
                new POCallBack(AppointmentInfo.class),
                pageSize,
                curPage);
    }
    public AppointmentInfo getAppointmentInfo(int orderId){
        Session session = sessionFactory.openSession();

        StringBuilder sql = new StringBuilder();

        sql.append(
                "SELECT a.appointment_id,a.investor_id,a.investor_name,a.operator_code,a.operator_id,a.product_id,");
        sql.append(
                "a.operator_name,a.appointment_time,p.product_code,p.fund_code,p.fund_name as product_name,o.status,o.order_id,i.ito_account as investor_account ");
        sql.append("FROM tt_appointment a ");
        sql.append("LEFT JOIN tt_project p ON a.product_id = p.product_id ");
        sql.append("LEFT JOIN tt_order o ON a.appointment_id = o.appointment_id ");
        sql.append("LEFT JOIN tt_investor i ON a.investor_id = i.investor_id ");
        sql.append("WHERE a.is_delete = " + Constants.IF_TYPE_NO + "  and a.status = " + Constants.STATUS_ENABLE + " and o.order_id= ? ");

        Parameters params = new Parameters();
        params.addParam(orderId);
        List<AppointmentInfo> appointmentInfoList = session.select(sql.toString(), params.getParams(), new POCallBack<>(AppointmentInfo.class));
        if (null != appointmentInfoList && appointmentInfoList.size() > 0) {
            return appointmentInfoList.get(0);
        }
        return null;

    }

    public OperatorInfo getOperatorInfo(String investorNo, String productCode) throws DAOException {

        Session session = sessionFactory.openSession();

        StringBuilder sql = new StringBuilder();

        sql.append(
                "SELECT a.operator_id,a.operator_code,a.operator_name,a.operator_mobile AS mobile,a.branch_code,a.branch_name ");
        sql.append("FROM tt_appointment a ");
        sql.append("LEFT JOIN tt_project p ON a.product_id=p.product_id ");
        sql.append(" WHERE a.investor_id = ?");
        Parameters params = new Parameters();

        params.addParam(investorNo);

        sql.append(" AND p.product_code= ? ");

        params.addParam(productCode);
        sql.append("ORDER BY a.appointment_time DESC LIMIT 1");

        List<OperatorInfo> operatorInfoList =
                session.select(sql.toString(), params.getParams(), new POCallBack<>(OperatorInfo.class));
        if (null != operatorInfoList && operatorInfoList.size() > 0) {
            return operatorInfoList.get(0);
        }
        return null;
    }

    public InvestorAppointmentInfo getAppionementInfo(String productCode, String investorNo)
            throws DAOException {
        Session session = sessionFactory.openSession();

        StringBuilder sql = new StringBuilder();

    sql.append(
        "SELECT ta.appointment_time,tp.fund_code,ti.ito_account AS investor_account,ti.ito_token as inverstor_token,ta.operator_code as operator_no,tor.status,top.ito_account AS operator_account FROM tt_appointment ta \n"
            + "JOIN tt_project tp on ta.product_id = tp.product_id \n"
            + "JOIN tt_investor ti on ta.investor_id = ti.investor_id \n"
            + "JOIN tt_operator top on ta.operator_id = top.operator_id \n"
            + "JOIN tt_order tor on ta.appointment_id = tor.appointment_id\n"
            + "WHERE ta.is_delete = " + Constants.IF_TYPE_NO + "  and ta.status = " + Constants.STATUS_ENABLE);
        Parameters params = new Parameters();

        sql.append(" AND tp.product_code  = ?");

        params.addParam(productCode);

        sql.append(" AND ti.investor_no = ? ORDER BY ta.appointment_time DESC");

        params.addParam(investorNo);

        List<InvestorAppointmentInfo> operatorInfoList =
                session.select(
                        sql.toString(), params.getParams(), new POCallBack<>(InvestorAppointmentInfo.class));
        if (null != operatorInfoList && operatorInfoList.size() > 0) {
            return operatorInfoList.get(0);
        }
        return null;
    }

    public List<AppointmentInfos> getAllAppionementLists(String investorNo) throws DAOException {
        Session session = sessionFactory.openSession();

        StringBuilder sql = new StringBuilder();
        Parameters params = new Parameters();
    sql.append(
        "select c.* from (\n"
            + "SELECT\n"
            + "\ti.investor_no,a.operator_code AS operator_no,a.operator_name,\n"
            + "\ta.appointment_id,a.investor_id,a.product_id,\n"
            + "\tp.product_code,p.fund_name AS product_name,\n"
            + "\to.status,p.fund_code,p.fund_name,\n"
            + "\ta.appointment_time,i.ito_account AS investor_account,\n"
            + "\top.ito_account AS operator_account,\n"
            + "\top.status as op_status\n"
            + "FROM tt_appointment a\n"
            + "LEFT JOIN tt_project p ON a.product_id = p.product_id\n"
            + "LEFT JOIN tt_order o ON a.appointment_id = o.appointment_id\n"
            + "LEFT JOIN tt_investor i ON a.investor_id = i.investor_id\n"
            + "LEFT JOIN tt_operator op ON a.operator_id = op.operator_id\n"
            + "WHERE\n"
            + "a.is_delete ="
            + Constants.IF_TYPE_NO
            + " and a.status = "
            + Constants.STATUS_ENABLE
            + " and o.status !="
            + Constants.SALE_STATUS_CANCEL
            + " and op.status ="
            + Constants.STATUS_ENABLE);
            if (investorNo != null && !"".equals(investorNo)) {
                sql.append(" and i.investor_no = ? ");
                params.addParam(investorNo);
            }
            sql.append(") c left join (\n"
                    + "select t.investor_id,t.product_id,max(t.appointment_time) appointment_time from (\n"
                    + " SELECT\n"
                    + "\ti.investor_no,a.operator_code AS operator_no,a.operator_name,\n"
                    + "\ta.appointment_id,a.investor_id,a.product_id,\n"
                    + "\tp.product_code,p.fund_name AS product_name,\n"
                    + "\to.status,p.fund_code,p.fund_name,\n"
                    + "\ta.appointment_time,i.ito_account AS investor_account,\n"
                    + "\top.ito_account AS operator_account\n"
                    + "FROM tt_appointment a\n"
                    + "LEFT JOIN tt_project p ON a.product_id = p.product_id\n"
                    + "LEFT JOIN tt_order o ON a.appointment_id = o.appointment_id\n"
                    + "LEFT JOIN tt_investor i ON a.investor_id = i.investor_id\n"
                    + "LEFT JOIN tt_operator op ON a.operator_id = op.operator_id\n"
                    + "WHERE\n"
                    + "a.is_delete = "
                    +Constants.IF_TYPE_NO
                    + " and a.status = "
                    + Constants.STATUS_ENABLE
                    + " and o.status != "
                    + Constants.SALE_STATUS_CANCEL);
                    if (investorNo != null && !"".equals(investorNo)) {
                        sql.append(" and i.investor_no = ? ");
                        params.addParam(investorNo);
                    }
            sql.append(" ) t\n"
                    + "GROUP BY t.investor_id,t.product_id\n"
                    + ") b on (c.investor_id=b.investor_id and c.product_id=b.product_id and c.appointment_time=b.appointment_time)\n"
                    + "\n"
                    + "where b.investor_id is not null");

        List<AppointmentInfos> allAppionementLists =
                session.select(
                        sql.toString(), params.getParams(), new POCallBack<>(AppointmentInfos.class));
        return allAppionementLists;
    }

    public List<OperatorInfo> getOperatorLists() throws DAOException {
        Session session = sessionFactory.openSession();

        StringBuilder sql = new StringBuilder();
        Parameters params = new Parameters();
        sql.append(
        "SELECT a.operator_id,b.user_code as operator_code,b.user_name as operator_name,b.mobile,b.app_id\n"
            + " FROM tt_order t \n"
            + " left join tt_appointment a on t.appointment_id = a.appointment_id\n"
            + " left join tm_user b on a.operator_code = b.user_code\n"
            + " where t.status = " + Constants.SALE_STATUS_UNCONFIRM);

        List<OperatorInfo> operatorLists =
                session.select(
                        sql.toString(), params.getParams(), new POCallBack<>(OperatorInfo.class));
        return operatorLists;
    }

    public TtInvestorPO getInvestorInfo(String investorNo)
            throws DAOException {
        Session session = sessionFactory.openSession();

        StringBuilder sql = new StringBuilder();

        sql.append(
                " SELECT t.* FROM tt_investor t WHERE " +
                "t.`status`= " +Constants.STATUS_ENABLE +
                " AND t.`is_delete`= " + Constants.IF_TYPE_NO);
        Parameters params = new Parameters();

        sql.append(" AND t.investor_no  = ?");
        params.addParam(investorNo);

        List<TtInvestorPO> investorInfoList =
                session.select(
                        sql.toString(), params.getParams(), new POCallBack<>(TtInvestorPO.class));
        if (null != investorInfoList && investorInfoList.size() > 0) {
            return investorInfoList.get(0);
        }
        return null;
    }

    public List<AppointmentInfo> getAppointmentLists(String productCode) throws DAOException {
        Session session = sessionFactory.openSession();

        StringBuilder sql = new StringBuilder();
        Parameters params = new Parameters();
        sql.append("SELECT ta.appointment_id ,tor.status,tor.order_id,tp.product_id FROM tt_appointment ta \n" +
                "JOIN tt_project tp ON ta.product_id = tp.product_id \n" +
                "JOIN tt_order tor ON ta.appointment_id = tor.appointment_id\n" +
                "WHERE ta.is_delete = " + Constants.IF_TYPE_NO + " AND ta.status = "+Constants.STATUS_ENABLE);
        sql.append(" AND tp.product_code  = ?");
        params.addParam(productCode);
        List<AppointmentInfo> appointmentList =
                session.select(
                        sql.toString(), params.getParams(), new POCallBack<>(AppointmentInfo.class));

        return appointmentList;
    }
    public List<AppointmentInfo> getAppointments(String productCode,String operatorNo,String investorNo) throws DAOException {
        Session session = sessionFactory.openSession();

        StringBuilder sql = new StringBuilder();
        Parameters params = new Parameters();
        sql.append("SELECT ta.appointment_time,ta.appointment_id,ta.operator_code,tor.order_id,tor.status FROM tt_appointment ta \n" +
                "JOIN tt_project tp on ta.product_id = tp.product_id \n" +
                "JOIN tt_investor ti on ta.investor_id = ti.investor_id \n" +
                "JOIN tt_operator top on ta.operator_id = top.operator_id \n" +
                "JOIN tt_order tor on ta.appointment_id = tor.appointment_id\n" +
                "WHERE ta.is_delete = " + Constants.IF_TYPE_NO + " AND ta.status = "+Constants.STATUS_ENABLE +
                " AND tor.`status`!=" + Constants.SALE_STATUS_CANCEL);
        if (investorNo != null && !"".equals(investorNo)) {
            sql.append(" and ti.investor_no = ? ");
            params.addParam(investorNo);
        }
        if (productCode != null && !"".equals(productCode)) {
            sql.append(" and tp.product_code = ? ");
            params.addParam(productCode);
        }
        if (operatorNo != null && !"".equals(operatorNo)) {
            sql.append(" and ta.operator_code = ? ");
            params.addParam(operatorNo);
        }
        sql.append(" ORDER BY ta.appointment_time DESC");
        List<AppointmentInfo> appointments =
                session.select(
                        sql.toString(), params.getParams(), new POCallBack<>(AppointmentInfo.class));

        return appointments;
    }

}
