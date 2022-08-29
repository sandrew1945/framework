package com.sandrew.bootsec.dao;

import com.sandrew.bootsec.model.TmAppVersionLogPO;
import com.sandrew.bootsec.model.TtIosIpaInfoPO;
import com.sandrew.bury.Session;
import com.sandrew.bury.SqlSessionFactory;
import com.sandrew.bury.callback.POCallBack;
import com.sandrew.bury.util.Parameters;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Repository
public class MobileIpaInfoDAO
{
    @Resource
    SqlSessionFactory sessionFactory;

    public List<TtIosIpaInfoPO> findNoUseEntity() {
        Parameters params = new Parameters();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM tt_ios_ipa_info WHERE use_flag =0 ORDER BY id ASC LIMIT 1");
        Session session = sessionFactory.openSession();
        return session.select(sql.toString(),null,new POCallBack<>(TtIosIpaInfoPO.class));
    }

    public List<TmAppVersionLogPO> findAndroidEntity() {
        Parameters params = new Parameters();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM tm_app_version_log ORDER BY log_id DESC LIMIT 1");
        Session session = sessionFactory.openSession();
        return session.select(sql.toString(),null,new POCallBack<>(TmAppVersionLogPO.class));
    }

}
