package com.sandrew.bootcas.mapper.login;


import com.sandrew.bootcas.bean.MenuBean;
import com.sandrew.bootcas.bean.RoleTreeNode;
import com.sandrew.bootcas.model.TmUserPO;
import com.sandrew.bootcas.core.bean.AclUserBean;
import com.sandrew.bootcas.core.page.Pager;

import java.util.List;

public interface LoginMapper
{
	public List<TmUserPO> selectByUserCode(TmUserPO userPO);

	public List<TmUserPO> pageQueryUser(Pager pager);

	public List<AclUserBean> selectRoleByUserCode(String userCode);

	public List<RoleTreeNode> selectRoleForChoice(Integer userId);

	public List<MenuBean> getMenuInfo(Integer roleId);
}