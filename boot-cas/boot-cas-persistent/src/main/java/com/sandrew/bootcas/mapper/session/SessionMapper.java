package com.sandrew.bootcas.mapper.session;


import com.sandrew.bootcas.bean.SessionPager;
import com.sandrew.bootcas.model.TtSessionPO;

import java.util.List;


public interface SessionMapper
{
	public List<TtSessionPO> pageQuerySession(SessionPager pager);
}