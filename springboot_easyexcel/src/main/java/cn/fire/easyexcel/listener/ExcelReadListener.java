package cn.fire.easyexcel.listener;

import cn.fire.easyexcel.domain.User;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;



/**
 * @Author zhangle
 * @CreateTime 2021-11-08 15:02:16
 * @Description 监听器
 */
@Component
public class ExcelReadListener extends AnalysisEventListener<User> {
     private List<User> users = new ArrayList<>();

    /**
     * 这个每一条数据解析都会来调用
     * @param user
     * @param context
     */
    @Override
    public void invoke(User user, AnalysisContext context) {
        System.out.println("第"+context.getCurrentRowNum()+"行记录: "+user.toString());
        users.add(user);
    }

    /**
     * 所有数据解析完成了 都会来调用
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        System.out.println("------end----------,result:"+ JSON.toJSONString(users));
    }
}
