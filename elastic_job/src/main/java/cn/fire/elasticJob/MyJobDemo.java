package cn.fire.elasticJob;

import cn.fire.elasticJob.job.MySimpleJob;
import org.apache.shardingsphere.elasticjob.api.JobConfiguration;
import org.apache.shardingsphere.elasticjob.lite.api.bootstrap.impl.OneOffJobBootstrap;
import org.apache.shardingsphere.elasticjob.lite.api.bootstrap.impl.ScheduleJobBootstrap;
import org.apache.shardingsphere.elasticjob.reg.base.CoordinatorRegistryCenter;
import org.apache.shardingsphere.elasticjob.reg.zookeeper.ZookeeperConfiguration;
import org.apache.shardingsphere.elasticjob.reg.zookeeper.ZookeeperRegistryCenter;

/**
 * @Author zhangle
 * @CreateTime 2021-10-18 13:51:05
 * @Description
 */
public class MyJobDemo {
    public static void main(String[] args) {
        new ScheduleJobBootstrap(createRegistryCenter(),
                new MySimpleJob(),
                createJobConfiguration()
        ).schedule();

        //创建一次性调度作业(不使用定时cron表达式)
        new OneOffJobBootstrap(createRegistryCenter(),
                new MySimpleJob(),
                createOneOffJobConfiguration()
        ).execute();
    }

    /**
     * 创建定时任务配置
     *
     * @return
     */
    private static JobConfiguration createJobConfiguration() {
        return JobConfiguration.newBuilder("mySimpleJob", 3).
                cron("0/5 * * * * ?").
                //使用记录日志策略
                        jobErrorHandlerType("LOG").
                        build();
    }

    private static JobConfiguration createOneOffJobConfiguration() {
        return JobConfiguration.newBuilder("mySimpleJob2", 3).
                //使用记录日志策略
                        jobErrorHandlerType("LOG").
                        build();
    }

    private static CoordinatorRegistryCenter createRegistryCenter() {
        //在zk根节点创建一个持久根节点my-job,并在该节点下创建mySimpleJob节点且value=[config, instances, leader, servers, sharding]
        CoordinatorRegistryCenter registryCenter = new ZookeeperRegistryCenter(new ZookeeperConfiguration("192.168.88.131:2181", "my-job"));
        registryCenter.init();
        return registryCenter;
    }

}
