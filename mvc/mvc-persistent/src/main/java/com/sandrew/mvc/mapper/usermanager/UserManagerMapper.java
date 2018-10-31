package com.sandrew.mvc.mapper.usermanager;

import java.util.List;
import java.util.Map;

import com.sandrew.mvc.bean.AclUserBean;
import com.sandrew.mvc.core.page.Pager;
import com.sandrew.mvc.model.TmRolePO;
import com.sandrew.mvc.model.TmUserPO;

public interface UserManagerMapper
{
	public List<TmUserPO> userManagerPageQuery(Pager pager);
	
	public List<TmRolePO> queryRelationRole(Integer userId);
	
	public List<TmRolePO> getRoleExistOwn(AclUserBean userBean);

	public int updateClearAvatar(Map<String, Object> paramMap);
}