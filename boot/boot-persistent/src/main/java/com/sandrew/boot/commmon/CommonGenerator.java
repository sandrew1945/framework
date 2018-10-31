/**********************************************************************
* <pre>
* FILE : CommonGenerator.java
* CLASS : CommonGenerator
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
* 		  |2016年11月15日| Administrator| Created |
* DESCRIPTION:
* </pre>
***********************************************************************/
/**
* $Id: CommonGenerator.java,v 0.1 2016年11月15日 上午11:02:35 Administrator Exp $
*/

package com.sandrew.boot.commmon;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Function    : 
 * @author     : Administrator
 * CreateDate  : 2016年11月15日
 * @version    :
 */
public class CommonGenerator
{

	/**
	 * Function    : 
	 * LastUpdate  : 2016年11月15日
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		try
		{
			List<String> warnings = new ArrayList<String>();
			boolean overwrite = true;
			URL url = ClassLoader.getSystemClassLoader().getResource("generatorConfig.xml");
			System.out.println(url.getPath());
			File configFile = new File(url.getPath());
			ConfigurationParser cp = new ConfigurationParser(warnings);
			Configuration config = cp.parseConfiguration(configFile);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
			for (String string : warnings)
			{
				System.out.println(string);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (XMLParserException e)
		{
			e.printStackTrace();
		}
		catch (InvalidConfigurationException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

}
