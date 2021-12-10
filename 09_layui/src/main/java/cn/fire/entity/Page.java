package cn.fire.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author:zl
 * @Date:2020/12/26 08:54:34
 * @Userful: 封装分页参数
 */
@Data
public class Page<T> {
    private Integer page; // 当前页
    private Integer limit; //每页的数据量
    private Integer PageNum; //总页数
    private Long count; // 返回数据的总数
    private List<T> data; //返回的数据
}
