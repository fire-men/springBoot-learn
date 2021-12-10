package cn.fire.easyexcel.service;

import cn.fire.easyexcel.domain.User;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.Sheet;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @Author zhangle
 * @CreateTime 2021-11-08 14:54:33
 * @Description
 */
public interface ExcelService {
    /**
     *
     * @param filePath 文件路径
     * @param cla 读取一行内容时，封装到一个实体类中
     * @param
     * @return 无返回值
     */
   void read(String filePath, Class cla, AnalysisEventListener analysisEventListener);


    /**
     *
     * @param filePath
     * @param cla
     * @param analysisEventListener
     * @return 有返回值
     */
   List<User> readAndBack(String filePath, Class cla, AnalysisEventListener analysisEventListener);


    /**
     * 读取多个sheet并返回
     * 多个sheet的名称相同，只不过第一页数据太大了，第一页放不了了，只能在第二页存放
     * @param filePath
     * @param cla
     * @param analysisEventListener
     * @return
     */
//   List<User> readManySheetAndBack(String filePath, Class cla, AnalysisEventListener analysisEventListener);


    /**
     * 读取多个sheet并返回
     *  多个sheet的名称不一样
     * @param filePath
     * @param cla
     * @param analysisEventListener
     * @return
     */
//   List<User> readManySheet2AndBack(String filePath, Class cla, AnalysisEventListener analysisEventListener);




    /**
     *
     * @param filePath
     * @return
     */
    List<User> read(String filePath);



    /**
     * WEB 文件上传，解析excel
     * @param inputStream
     * @param cla
     * @param sheet
     * @return
     */
    List<User> upload(InputStream inputStream,Class cla,Sheet sheet,AnalysisEventListener analysisEventListener);

    /**
     * 写入excel表中
     * @param filePath
     * @param cla
     * @param sheet
     * @param data
     */
    void simpleWrite(String filePath, Class cla, Sheet sheet, List<User> data);


    /**
     * WEB 文件下载
     * @param outputStream
     * @param cla
     * @param sheet
     * @param data
     */
    void download(OutputStream outputStream, Class cla, Sheet sheet, List<User> data);


}
