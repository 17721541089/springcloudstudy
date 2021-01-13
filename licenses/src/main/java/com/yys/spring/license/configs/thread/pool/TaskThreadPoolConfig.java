package com.yys.spring.license.configs.thread.pool;

import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskThreadPoolConfig {
    private int corePoolSize = 5;
    private int maxPoolSize = 50;
    private int keepAliveSeconds = 60;
    private  int queueCapacity = 10000;
    private String threadPoolNamePrefix = "FSH_asyncTask_Linsece";
}
