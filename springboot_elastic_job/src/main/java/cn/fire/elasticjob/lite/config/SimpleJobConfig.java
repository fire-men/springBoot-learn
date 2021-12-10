package cn.fire.elasticjob.lite.config;

import cn.fire.elasticjob.lite.job.SpringBootSimpleJob;
import org.apache.shardingsphere.elasticjob.api.JobConfiguration;
import org.apache.shardingsphere.elasticjob.lite.api.bootstrap.impl.OneOffJobBootstrap;
import org.apache.shardingsphere.elasticjob.lite.api.bootstrap.impl.ScheduleJobBootstrap;
import org.apache.shardingsphere.elasticjob.reg.base.CoordinatorRegistryCenter;
import org.apache.shardingsphere.elasticjob.reg.zookeeper.ZookeeperConfiguration;
import org.apache.shardingsphere.elasticjob.reg.zookeeper.ZookeeperRegistryCenter;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @Author zhangle
 * @CreateTime 2021-10-19 16:31:08
 * @Description
 */
@SpringBootConfiguration
public class SimpleJobConfig {

    @Value("${elasticjob.regCenter.serverLists}")
    private String serverLists;
    @Value("${elasticjob.regCenter.namespace}")
    private String namespace;
    @Value("${elasticjob.jobs.simpleJob.shardingTotalCount}")
    private int shardingTotalCount;
    @Value("${elasticjob.jobs.simpleJob.cron}")
    private String cron;
    @Value("${elasticjob.jobs.simpleJob.shardingItemParameters}")
    private String shardingItemParameters;


    @Bean
    public CoordinatorRegistryCenter coordinatorRegistryCenter() {
        CoordinatorRegistryCenter registryCenter = new ZookeeperRegistryCenter(new ZookeeperConfiguration(serverLists, namespace));
        registryCenter.init();
        return registryCenter;
    }

    @Bean
    public JobConfiguration jobConfiguration(){
        return JobConfiguration.
                newBuilder("SpringBootSimpleJob",shardingTotalCount).
                cron(cron).
                shardingItemParameters(shardingItemParameters).
                jobErrorHandlerType("LOG").
                build();

    }

    @Bean
    public SimpleJob simpleJob(){
        return new SpringBootSimpleJob();
    }

    @Bean
    public ScheduleJobBootstrap scheduleJobBootstrap(@Qualifier("coordinatorRegistryCenter") CoordinatorRegistryCenter registryCenter,
                                                     @Qualifier("simpleJob") SimpleJob simpleJob,
                                                     @Qualifier("jobConfiguration") JobConfiguration jobConfiguration){
        return new ScheduleJobBootstrap(registryCenter,simpleJob,jobConfiguration);
    }
}
