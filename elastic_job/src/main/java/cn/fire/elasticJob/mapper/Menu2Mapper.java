package cn.fire.elasticJob.mapper;


import cn.fire.elasticJob.entity.Menu;
import cn.fire.elasticJob.entity.Menu2;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author zl
 * @since 2021-10-15
 */
@Repository("menu2Mapper")
public interface Menu2Mapper extends BaseMapper<Menu2> {


    void batchInsert(List<Menu> menus);

}
