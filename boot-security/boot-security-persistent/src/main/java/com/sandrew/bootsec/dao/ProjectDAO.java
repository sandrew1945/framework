package com.sandrew.bootsec.dao;

import com.sandrew.bootsec.bean.ProjectInfo;
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

@Slf4j
@Repository
public class ProjectDAO
{
    @Resource
    SqlSessionFactory sessionFactory;

    /**
     *  查询所有产品列表
     * @return
     * @throws DAOException
     */
    public PageResult<ProjectInfo> queryProjectLists(String productName, int limit, int curPage) throws DAOException
    {
        Session session = sessionFactory.openSession();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT p.`product_id`,p.`product_code`,p.`fund_name` as product_name FROM tt_project p WHERE p.`is_delete`='10031002'");
        Parameters params = new Parameters();

        if (StringUtils.isNotEmpty(productName)) {
            sql.append(" and p.fund_name like ? ");
            params.addLikeParam(productName);
        }
        return session.pageQuery(
                sql.toString(),
                params.getParams(),
                new POCallBack(ProjectInfo.class),
                limit,
                curPage);
    }
}
