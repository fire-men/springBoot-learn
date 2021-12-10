package cn.fire.elasticJob.job;

import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;

/**
 * @Author zhangle
 * @CreateTime 2021-10-18 13:47:25
 * @Description 简单任务
 */
public class MySimpleJob implements SimpleJob {

    public void execute(ShardingContext shardingContext) {
        //将任务拆分成三个分片，分别执行
        switch (shardingContext.getShardingItem()) {
            case 0:
                System.out.println("do something by sharding item 0");
                break;
            case 1:
                System.out.println("do something by sharding item 1");
                break;
            case 2:
                System.out.println(" do something by sharding item 2");
                break;
            // case n: ...
        }
    }
}
