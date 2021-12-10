package cn.fire.mybatis.mapper;

import cn.fire.mybatis.model.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @Author:zl
 * @Date:2020/12/22 09:29:09
 * @Userful:
 */
public interface GoodsMapper {
    void insertGoods(Goods goods);

    List<Goods> selectGoodsList();

    void updateGoods(Goods goods);

    void batchInsertGoods(List<Goods> goodsList);
}
