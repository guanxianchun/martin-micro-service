package com.martin.euop.license;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.util.Random;

/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 2/22/18 11:16 AM
 * Descrition
 */
@RestController
public class LicenseController {
    private final Logger logger = LoggerFactory.getLogger(LicenseController.class);
    @Autowired
    private DiscoveryClient client;
    @RequestMapping(value = "/licenseInfo",method = RequestMethod.GET)
    public String getLicenseInfo(@Param("userId") String userId){
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/users/"+userId+"/licenseInfo, host : "+instance.getHost()+" service instance id : "+instance.getServiceId());
        //设置阻塞场景　来触发断蹯器
        int sleepTime = new Random().nextInt(3000);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "licenseInfo";
    }
}
