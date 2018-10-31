package com.sandrew.mvc.core.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Created by summer on 2018/7/3.
 */
public class FixcodeRewriteListener implements ApplicationListener<ContextRefreshedEvent>
{
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        String path = this.getClass().getClassLoader().getResource("/").getPath();
        System.out.println("path =============" + path);
    }
}
