package com.yys.spring.license.services.servicesImpl;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.yys.spring.license.services.ILicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicenseServiceImpl implements ILicenseService {

//    @Autowired
//    private LicenseRepository  licenseRepository;

    /**
     *  @HystrixCommand注解来将Java类方法标记为
     *  Hystrix 断路器进行管理，当Spring框架看到@HystrixCommand时
     *  它将动态申请一个代理，该代理将包装该方法，并通过专门的用于
     *  远程调用的线程池来管理对该方法的所有调用
     *  默认超时时间1000ms
     *  默认情况下，即默认所有配置项，所有@HystrixCommand，这个注解
     *  会将所有的远程调用放在同一个线程池下，这样会导致应用程序出现问题
     *  可以使用舱壁模式，实现远程服务的调用隔离到它们自己的线程池中
     * @param organizationId
     * @return
     */
    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty( name = "execution.isolation.thread.timeoutInMilliseconds",value = "12000"),
            },
            //如果Hystrix调用失败,就会调用这个方法，需要定义在同一个类中
            fallbackMethod = "**方法",
            threadPoolKey = "xxThreadPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize",value = "3"),
                    //如果将value设置为-1，将使用SyschronousQueue来保存所有请求
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            }
    )


    public List<?> getLicenseService(String organizationId){
        return null;
    }
}
