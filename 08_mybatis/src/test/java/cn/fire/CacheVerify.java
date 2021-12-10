package cn.fire;

import cn.fire.mybatis.mapper.GoodsMapper;
import cn.fire.mybatis.model.Goods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@SpringBootTest
class CacheVerify {

    @Resource
    private GoodsMapper goodsMapper;

    //验证mybatis的一级缓存
    @Test
    void verifyCacheTest() {
        Goods goods = new Goods();
        goods.setGoodsName("阿迪达斯跑鞋2代");
        goods.setPrice(4000.0);
        goods.setStock(1000L);
        goods.setIsShelf(1);
        goods.setAddTime(new Date());

        goodsMapper.insertGoods(goods);
        System.out.println("id----"+goods.getId());

        List<Goods> goods1 = goodsMapper.selectGoodsList();
        goods1.forEach(System.out::println);
    }

}
