package com.sandrew.bootsec.dao;

import com.sandrew.bootsec.core.common.Constants;
import com.sandrew.bootsec.core.exception.DAOException;
import com.sandrew.bootsec.model.TmFunctionPO;
import com.sandrew.bury.Session;
import com.sandrew.bury.SqlSessionFactory;
import com.sandrew.bury.callback.POCallBack;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by summer on 2019/7/26.
 */
@Slf4j
@Repository
public class MenuManagerDAO
{
    @Resource
    SqlSessionFactory sessionFactory;

    /**
     *  查询系统菜单
     * @return
     * @throws DAOException
     */
    public List<TmFunctionPO> getMenuList() throws DAOException
    {
        Session session = sessionFactory.openSession();
        TmFunctionPO cond = new TmFunctionPO();
        cond.setIsDelete(Constants.IF_TYPE_NO);
        List<TmFunctionPO> list = session.selectForOrder(cond, new POCallBack(TmFunctionPO.class), "asc","func_order");
        return list;
    }
}
