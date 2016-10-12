package com.pivotal.platform.spring.employee.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscoveryRest
{
    private static Log logger = LogFactory.getLog(DiscoveryRest.class);

    @Autowired
    private EurekaClient discoveryClient;

    @RequestMapping(value = "/service_details", method = RequestMethod.GET)
    public String serviceUrl()
    {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("SPRINGBOOT-EMPLOYEE-SERVICE", false);

        return String.format("instanceID: {%s}, URL: {%s}", instance.getId(), instance.getHomePageUrl());
    }
}
