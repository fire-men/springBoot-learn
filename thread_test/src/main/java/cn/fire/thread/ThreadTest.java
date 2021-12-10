package cn.fire.thread;



import cn.fire.thread.util.MyTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhangle
 * @CreateTime 2021-10-19 13:11:54
 * @Description
 */

public class ThreadTest {
    private static final Logger log = LoggerFactory.getLogger(ThreadTest.class);

    /* 车站剩余车票 */
    private long leftTicket = 100;

//    @Autowired
//    private MenuMapper menuMapper;
//
//    @Autowired
//    private Menu2Mapper menu2Mapper;

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
     * 测试通过
     */

    /*void queryAndInsertByMultiThread() {
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

    }*/


    /**
     * 多渠道抢票
     */
    class BuyTicketsJob implements Runnable {
        private String channel;

        public BuyTicketsJob(String channel) {
            this.channel = channel;
        }


        @Override
        public void run() {
            log.info("渠道:" + this.channel + "::抢到了一张票,车站还剩" + (--leftTicket) + "张余票");
        }
    }


    @MyTest
    void buyTicketTest() {
        new Thread(new BuyTicketsJob("微信")).start();
    }


    public static void main(String[] args) {
        //new ThreadTest().operateShareDataByMulThread();

        // new ThreadTest().queryAndInsertByMultiThread();




    }
}
