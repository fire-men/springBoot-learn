package cn.fire.elasticJob.mapper;


import cn.fire.elasticJob.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
@Repository("menuMapper")
public interface MenuMapper extends BaseMapper<Menu> {


    List<Menu> selectPage2(long skipNum, long pageSize);

}
