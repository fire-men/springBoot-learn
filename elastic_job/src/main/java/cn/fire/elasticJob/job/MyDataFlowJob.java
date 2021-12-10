package cn.fire.elasticJob.job;

import cn.fire.elasticJob.entity.Menu;
import cn.fire.elasticJob.service.IMenuService;

import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.dataflow.job.DataflowJob;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

/**
 * @Author zhangle
 * @CreateTime 2021-10-18 15:12:31
 * @Description
 */
public class MyDataFlowJob implements DataflowJob<Menu> {

    //获取数据
    @Override
    public List<Menu> fetchData(ShardingContext shardingContext) {

        return null;
    }

    //处理数据
    @Override
    public void processData(ShardingContext shardingContext, List<Menu> list) {

    }
}
