/**********************************************************************
* <pre>
* FILE : EBException.java
* CLASS : EBException
*
* AUTHOR : SuMMeR
*
* FUNCTION : TODO
*
*
*======================================================================
* CHANGE HISTORY LOG
*----------------------------------------------------------------------
* MOD. NO.| DATE | NAME | REASON | CHANGE REQ.
*----------------------------------------------------------------------
* 		  |2009-11-2| SuMMeR| Created |
* DESCRIPTION:
* </pre>
***********************************************************************/
/**
* $Id: JsonException.java,v 1.1 2013/07/31 08:32:47 xin.jin Exp $
*/
package com.sandrew.bootsec.core.exception;

import com.sandrew.bootsec.core.common.JsonResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Function    : 
 * @author     : SuMMeR
 * CreateDate  : 2009-11-2
 * @version    :
 */
@ControllerAdvice
public class JsonException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4042594687623349469L;

	public JsonException()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public JsonException(String message, Throwable cause)
	{
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public JsonException(String message)
	{
		super(message);
		// TODO Auto-generated constructor stub
	}

	public JsonException(Throwable cause)
	{
		super(cause);
		// TODO Auto-generated constructor stub
	}
	@ResponseBody
	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
	public JsonResult HandleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		JsonResult jsonResult = new JsonResult();

		jsonResult.setMsg(e.getBindingResult().getFieldError().getDefaultMessage());

		return jsonResult;
	}

}
