package cn.fire.mybatis.model;

import lombok.*;

import javax.persistence.*;
import javax.sql.DataSource;
import java.util.Date;

/**
 * @Author:zl
 * @Date:2020/12/22 08:44:19
 * @Userful:
 */
//@Entity
//@Table(name = "tbl_goods")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Goods  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String goodsName;

    @Column
    private Double price;

    @Column
    private Long stock;

    @Column
    private Integer isShelf;

    @Column
    private Date addTime;
}
