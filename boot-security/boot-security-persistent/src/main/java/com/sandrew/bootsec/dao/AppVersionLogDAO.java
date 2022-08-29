package com.sandrew.bootsec.dao;

import com.sandrew.bootsec.core.exception.DAOException;
import com.sandrew.bootsec.model.TmAppVersionLogPO;
import com.sandrew.bury.Session;
import com.sandrew.bury.SqlSessionFactory;
import com.sandrew.bury.callback.POCallBack;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class AppVersionLogDAO {
    @Resource
    SqlSessionFactory sessionFactory;
    public List<TmAppVersionLogPO> selectNewVersion() throws DAOException {
        Session session=sessionFactory.openSession();
        StringBuilder sql = new StringBuilder();
        sql.append("select log_id,app_version,aok_url,update_desc,is_force_update,apk_size,apk_md5\n" +
                "FROM tm_app_version_log\n" +
                "ORDER BY app_version desc limit 1");
        return session.select(sql.toString(),null,new POCallBack<>(TmAppVersionLogPO.class));

    }
}
