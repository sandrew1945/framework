package com.sandrew.mvc.mapper.login;

import java.util.List;

import com.sandrew.mvc.bean.AclUserBean;
import com.sandrew.mvc.bean.MenuBean;
import com.sandrew.mvc.bean.RoleTreeNode;
import com.sandrew.mvc.core.page.Pager;
import com.sandrew.mvc.model.TmUserPO;

public interface LoginMapper
{
	public List<TmUserPO> selectByUserCode(TmUserPO userPO);
	
	public List<TmUserPO> pageQueryUser(Pager pager);
	
	public List<AclUserBean> selectRoleByUserCode(String userCode);
	
	public List<RoleTreeNode> selectRoleForChoice(Integer userId);
	
	public List<MenuBean> getMenuInfo(Integer roleId);
}