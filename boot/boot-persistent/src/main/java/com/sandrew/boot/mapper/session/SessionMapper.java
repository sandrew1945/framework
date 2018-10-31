package com.sandrew.boot.mapper.session;


import com.sandrew.boot.bean.SessionPager;
import com.sandrew.boot.model.TtSessionPO;

import java.util.List;


public interface SessionMapper
{
	public List<TtSessionPO> pageQuerySession(SessionPager pager);
}