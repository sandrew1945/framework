package com.sandrew.bootcas.mapper.usermanager;


import com.sandrew.bootcas.model.TmRolePO;
import com.sandrew.bootcas.model.TmUserPO;
import com.sandrew.bootcas.core.bean.AclUserBean;
import com.sandrew.bootcas.core.page.Pager;

import java.util.List;
import java.util.Map;


public interface UserManagerMapper
{
	public List<TmUserPO> userManagerPageQuery(Pager pager);
	
	public List<TmRolePO> queryRelationRole(Integer userId);
	
	public List<TmRolePO> getRoleExistOwn(AclUserBean userBean);

	public int updateClearAvatar(Map<String, Object> paramMap);
}