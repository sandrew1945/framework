package com.sandrew.bootcas.controller.register;

import com.sandrew.bootcas.core.common.AjaxResult;
import com.sandrew.bootcas.core.controller.BaseController;
import com.sandrew.bootcas.core.exception.ActionException;
import com.sandrew.bootcas.model.TmUserPO;
import com.sandrew.bootcas.service.register.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/register")
public class RegisterController extends BaseController
{
	@Resource
	RegisterService registerService;

	/**
	 * 
	 * Function    : 注册
	 * LastUpdate  : 2014年5月30日
	 * @param user
	 * @return
	 * @throws ActionException
	 */
	@RequestMapping(value = "/create")
	public @ResponseBody
	AjaxResult create(TmUserPO user) throws ActionException
	{
		try
		{
			registerService.createUser(user.getUserCode(), user.getUserName(), user.getPassword());
			AjaxResult result = new AjaxResult();
			return result.requestSuccess();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new ActionException("注册用户失败", e);
		}
	}
	
	@RequestMapping(value = "/validateUser")
	public @ResponseBody
	String validateUser(String userCode) throws ActionException
	{
		try
		{
			return registerService.validateUser(userCode);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new ActionException("验证用户失败", e);
		}
	}
}
