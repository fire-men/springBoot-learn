package cn.fire.mybatisPlus.service;

import cn.fire.mybatisPlus.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author zl
 * @since 2021-10-15
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 根据sort查询指定的菜单列表
     * @param sort
     * @return
     */
    List<Menu> selectMenuListBySort(Double sort);

    /**
     * 根据id查单条
     * @param id
     * @return
     */
    Menu queryById(Integer id);
}
