package cn.fire;

import cn.fire.mybatis.mapper.GoodsMapper;
import cn.fire.mybatis.model.Goods;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Author:zl
 * @Date:2020/12/22 14:59:37
 * @Userful:
 */
@SpringBootTest
public class ManageGoodsTest {
   // @Resource
    private GoodsMapper goodsMapper;

    //@Test
    public void updateGoods() {
        Goods goods = new Goods();
        goods.setId(1);
        goods.setGoodsName("特步X");
        goods.setPrice(150.0);
        goods.setStock(1000L);
        goods.setIsShelf(0);
        // goods.setAddTime();

        goodsMapper.updateGoods(goods);

    }

    //@Test
    public void batchInsertGoods() {
        List<Goods> goodsList = new ArrayList<>();
        Goods goods = new Goods();
        goods.setGoodsName("李宁2代");
        goods.setPrice(0.0);
        goods.setStock(0L);
        goods.setIsShelf(0);

        Goods goods2 = new Goods();
        goods2.setGoodsName("李宁3代");
        goods2.setPrice(150.0);
        goods2.setStock(1000L);
        goods2.setIsShelf(1);
        goods2.setAddTime(new Date());

        goodsList.add(goods2);
        goodsList.add(goods);

        goodsMapper.batchInsertGoods(goodsList);

    }
}
