package com.sandrew.boot.mapper.login;


import com.sandrew.boot.bean.MenuBean;
import com.sandrew.boot.bean.RoleTreeNode;
import com.sandrew.boot.core.bean.AclUserBean;
import com.sandrew.boot.core.page.Pager;
import com.sandrew.boot.model.TmUserPO;

import java.util.List;

public interface LoginMapper
{
	public List<TmUserPO> selectByUserCode(TmUserPO userPO);

	public List<TmUserPO> pageQueryUser(Pager pager);

	public List<AclUserBean> selectRoleByUserCode(String userCode);

	public List<RoleTreeNode> selectRoleForChoice(Integer userId);

	public List<MenuBean> getMenuInfo(Integer roleId);
}