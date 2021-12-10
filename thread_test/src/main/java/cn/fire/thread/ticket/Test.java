package cn.fire.thread.ticket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author zhangle
 * @CreateTime 2021-10-19 14:11:47
 * @Description
 */
public class Test {
    private static long leftTicket = 10;

    public static void main(String[] args) {
        //模拟100个用户抢夺10张票，出现超卖
        for (int i = 0; i < 100; i++) {
            new Thread(new BuyTicketsJob("微信"+i)).start();
        }


    }

    static class BuyTicketsJob implements Runnable {
        private static final Logger log = LoggerFactory.getLogger(BuyTicketsJob.class);


        private String channel;

        public BuyTicketsJob(String channel) {
            this.channel = channel;
        }


        @Override
        public void run() {
            System.out.println("渠道:" + this.channel + "::抢到了一张票,车站还剩" + (--leftTicket) + "张余票");
            if (leftTicket==0) {
                System.out.println("没有票了，请稍后重试!!!!");
                return;
            }
        }
    }
}
