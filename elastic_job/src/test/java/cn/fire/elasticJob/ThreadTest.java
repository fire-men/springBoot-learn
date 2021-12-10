package cn.fire.elasticJob;

import cn.fire.elasticJob.entity.Menu;
import cn.fire.elasticJob.mapper.Menu2Mapper;
import cn.fire.elasticJob.mapper.MenuMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhangle
 * @CreateTime 2021-10-19 10:29:45
 * @Description
 */
@SpringBootTest
public class ThreadTest {

    @Autowired
     private MenuMapper menuMapper;

    @Autowired
     private Menu2Mapper menu2Mapper;

    /**
     * 模拟多线程从统一数据源读取数据
     */
    void operateShareDataByMulThread() {
        ArrayList<Integer> datas = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
            add(7);
            add(8);
            add(9);
            add(10);
            add(11);
            add(12);
            add(13);
            add(14);
        }};

//        for (int i = 0; i < 2; i++) {
//            new Thread(() -> {
//                for (int j = 0; j < 10; j++) {
//                    System.out.println(Thread.currentThread().getName()+"打印："+j);
//                }
//            }).start();
//        }

        //获取总数据
        int total = datas.size();
        int pageSize = 4;
        int pageNum = total % pageSize == 0 ? (total / pageSize) : ((total / pageSize) + 1);
        System.out.println("共有" + pageNum + "页");
        for (int i = 1; i <= pageNum; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println("第" + (finalI) + "个线程开始执行Job>>>>>>>>>>>>>");
                int skipNum = (finalI - 1) * pageSize;
                List<Integer> result = queryDataByLimit(skipNum, pageSize, datas, total);
                result.stream().forEach(x -> System.out.println(Thread.currentThread().getName() + "----" + x));
            }).start();
        }
    }

    /**
     * 从一个数据源数据里面进行分页操作
     * 注意：
     * 循环条件里面必须要添加 i< total边界，否则出现异常
     *
     * @param skipNum
     * @param pageSize
     * @param datas
     * @param total
     * @return
     */
    private List<Integer> queryDataByLimit(int skipNum, int pageSize, ArrayList<Integer> datas, int total) {
        ArrayList<Integer> newList = new ArrayList<>();
        for (int i = skipNum; i < skipNum + pageSize && i < total; i++) {
            newList.add(datas.get(i));
        }
        return newList;
    }

    /**
     * 多线程实现查询和添加一个原子操作
     */
    @Test
    void queryAndInsertByMultiThread() {
//        ConfigurableApplicationContext context = SpringApplication.run(ThreadTest.class);
//        MenuMapper menuMapper = (MenuMapper) context.getBean("menuMapper");
//        Menu2Mapper menu2Mapper = (Menu2Mapper) context.getBean("menu2Mapper");
        Long total = menuMapper.selectCount(null);
        long pageSize = 6;
        long pageNum = total % pageSize == 0 ? (total / pageSize) : ((total / pageSize) + 1);
        try {
            for (int i = 1; i <= pageNum; i++) {
                int finalI = i;
                new Thread(() -> {
                    System.out.println("第" + (finalI) + "个线程开始执行Job>>>>>>>>>>>>>");
                    long skipNum = (finalI - 1) * pageSize;
                    //分页查询
                    List<Menu> menus = menuMapper.selectPage2(skipNum,pageSize);
                    //批量添加
                    menu2Mapper.batchInsert(menus);

                }).start();
            }
        } catch (Exception ex) {

        }

    }

    public static void main(String[] args) {
        //new ThreadTest().operateShareDataByMulThread();

        new ThreadTest().queryAndInsertByMultiThread();
    }
}
