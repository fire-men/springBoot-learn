package cn.fire.elasticjob.lite.controller;

import org.apache.shardingsphere.elasticjob.lite.api.bootstrap.impl.ScheduleJobBootstrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhangle
 * @CreateTime 2021-10-19 17:05:24
 * @Description
 */
@RestController
public class ScheduleJobController {
    @Autowired
    private ScheduleJobBootstrap simpleJobScheduleJobBootstrap;

    @GetMapping("/startup")
    public String startup(){
        simpleJobScheduleJobBootstrap.schedule();
        return "定时任务已开启";
    }

    @GetMapping("/shutdown")
    public String shutdown(){
        simpleJobScheduleJobBootstrap.shutdown();
        return "定时任务已关闭";
    }
}
