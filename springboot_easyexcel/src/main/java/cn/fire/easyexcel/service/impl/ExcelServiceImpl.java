package cn.fire.easyexcel.service.impl;

import cn.fire.easyexcel.domain.User;
import cn.fire.easyexcel.service.ExcelService;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.Sheet;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @Author zhangle
 * @CreateTime 2021-11-08 14:58:31
 * @Description
 */
@Service
public class ExcelServiceImpl implements ExcelService {


    /**
     * sheet()方法，默认从第一行sheet开始
     * // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
     *   参数一：读取的excel文件路径
     *   参数二：读取sheet的一行，将参数封装在DemoData实体类中
     *   参数三：读取每一行的时候会执行DemoDataListener监听器
     */
    @Override
    public void read(String filePath, Class cla, AnalysisEventListener analysisEventListener) {
        EasyExcel.read(filePath,cla,  analysisEventListener).sheet().doRead();

    }

    @Override
    public List<User> readAndBack(String filePath, Class cla, AnalysisEventListener analysisEventListener) {
        List<User> objects = EasyExcel.read(filePath, cla, analysisEventListener).sheet().doReadSync();
        return objects;
    }



    @Override
    public List<User> read(String filePath) {
        List<User> list = EasyExcel.read(filePath).sheet().doReadSync();
        return list;
    }

    @Override
    public List<User> upload(InputStream inputStream, Class cla, Sheet sheet,AnalysisEventListener analysisEventListener) {
        List<User> objects = EasyExcel.read(inputStream, cla, analysisEventListener).sheet(sheet.getSheetNo(), sheet.getSheetName()).doReadSync();
        return objects;
    }

    @Override
    public void simpleWrite(String filePath, Class cla, Sheet sheet, List<User> data) {
        EasyExcel.write(filePath,cla).sheet(sheet.getSheetNo(),sheet.getSheetName()).doWrite(data);
        System.out.println("-------写入"+filePath+"成功");
    }

    @Override
    public void download(OutputStream outputStream, Class cla, Sheet sheet, List<User> data) {
        EasyExcel.write(outputStream,cla).sheet(sheet.getSheetNo(),sheet.getSheetName()).doWrite(data);
    }
}
