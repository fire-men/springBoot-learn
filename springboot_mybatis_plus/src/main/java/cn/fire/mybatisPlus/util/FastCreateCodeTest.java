package cn.fire.mybatisPlus.util;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @Author zhangle
 * @CreateTime 2021-10-15 10:13:05
 * @Description
 */
public class FastCreateCodeTest {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/pro_cloud?useSSL=false&useUnicode=yes&characterEncoding=UTF8&serverTimezone=Asia/Shanghai&zeroDateTimeBehavior=CONVERT_TO_NULL", "zl", "zl123")
                .globalConfig(builder -> {
                    builder.author("zl") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("E:\\springBoot-learn\\springboot_mybatis_plus\\src\\main\\java\\cn\\fire\\mybatisPlus"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("cn.fire.mybatisPlus") // 设置父包名
                            .moduleName("") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "E:\\springBoot-learn\\springboot_mybatis_plus\\src\\main\\resources\\mybatis")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(new String[]{"sys_user","sys_role","sys_menu","sys_tenant"}) // 设置需要生成的表名
                            .addTablePrefix("sys_", "gen_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
