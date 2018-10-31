package com.sandrew.boot.mapper.usermanager;


import com.sandrew.boot.core.bean.AclUserBean;
import com.sandrew.boot.core.page.Pager;
import com.sandrew.boot.model.TmRolePO;
import com.sandrew.boot.model.TmUserPO;

import java.util.List;
import java.util.Map;


public interface UserManagerMapper
{
	public List<TmUserPO> userManagerPageQuery(Pager pager);
	
	public List<TmRolePO> queryRelationRole(Integer userId);
	
	public List<TmRolePO> getRoleExistOwn(AclUserBean userBean);

	public int updateClearAvatar(Map<String, Object> paramMap);
}