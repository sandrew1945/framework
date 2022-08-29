/**********************************************************************
* <pre>
* FILE : MySqlSessionDAO.java
* CLASS : MySqlSessionDAO
*
* AUTHOR : Administrator
*
* FUNCTION : TODO
*
*
*======================================================================
* CHANGE HISTORY LOG
*----------------------------------------------------------------------
* MOD. NO.| DATE | NAME | REASON | CHANGE REQ.
*----------------------------------------------------------------------
* 		  |2017年5月8日| Administrator| Created |
* DESCRIPTION:
* </pre>
***********************************************************************/
/**
* $Id: MySqlSessionDAO.java,v 0.1 2017年5月8日 上午10:35:36 Administrator Exp $
*/

package com.sandrew.bootcas.shiro.session;

import com.sandrew.bootcas.core.common.ObjectUtils;
import com.sandrew.bootcas.mapper.TtSessionPOMapper;
import com.sandrew.bootcas.model.TtSessionPO;
import com.sandrew.bootcas.model.TtSessionPOExample;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;

import javax.annotation.Resource;
import java.io.Serializable;


/**
 * Function    : 
 * @author     : Administrator
 * CreateDate  : 2017年5月8日
 * @version    :
 */
@Log4j2
public class MySqlSessionDAO extends CachingSessionDAO
{

	@Resource
	TtSessionPOMapper ttSessionPOMapper;

	/* (non-Javadoc)
	 * @see org.apache.shiro.session.mgt.eis.CachingSessionDAO#doUpdate(org.apache.shiro.session.Session)
	 */
	@Override
	protected void doUpdate(Session session)
	{
		//如果会话过期/停止 没必要再更新了
		if (session instanceof ValidatingSession && !((ValidatingSession) session).isValid())
		{
			return;
		}
		TtSessionPO value = new TtSessionPO();
		value.setSession(Base64.encodeToString(ObjectUtils.serialize(session)));
		TtSessionPOExample example = new TtSessionPOExample();
		TtSessionPOExample.Criteria criteria = example.createCriteria();
		criteria.andSessionIdEqualTo(String.valueOf(session.getId()));
		ttSessionPOMapper.updateByExampleSelective(value, example);
	}

	/* (non-Javadoc)
	 * @see org.apache.shiro.session.mgt.eis.CachingSessionDAO#doDelete(org.apache.shiro.session.Session)
	 */
	@Override
	protected void doDelete(Session session)
	{
//		TtSessionPO cond = new TtSessionPO();
//		cond.setSessionId(String.valueOf(session.getId()));
		ttSessionPOMapper.deleteByPrimaryKey(String.valueOf(session.getId()));
	}

	/* (non-Javadoc)
	 * @see org.apache.shiro.session.mgt.eis.AbstractSessionDAO#doCreate(org.apache.shiro.session.Session)
	 */
	@Override
	protected Serializable doCreate(Session session)
	{
		TtSessionPO value = new TtSessionPO();
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session, sessionId);
		value.setSessionId(String.valueOf(sessionId));
		value.setSession(Base64.encodeToString(ObjectUtils.serialize(session)));
		ttSessionPOMapper.insertSelective(value);
		return session.getId();
	}

	/* (non-Javadoc)
	 * @see org.apache.shiro.session.mgt.eis.AbstractSessionDAO#doReadSession(java.io.Serializable)
	 */
	@Override
	protected Session doReadSession(Serializable sessionId)
	{
		TtSessionPO cond = new TtSessionPO();
		cond.setSessionId(String.valueOf(sessionId));
		TtSessionPO sessionPO = ttSessionPOMapper.selectByPrimaryKey(String.valueOf(sessionId));
		if(null != sessionPO)
		{
			return (Session) ObjectUtils.unserialize(Base64.decode(sessionPO.getSession()));
		}
		return null;
	}

}
