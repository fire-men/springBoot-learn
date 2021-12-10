package cn.fire.mybatisPlus.service.impl;

import cn.fire.mybatisPlus.entity.Tenant;
import cn.fire.mybatisPlus.mapper.TenantMapper;
import cn.fire.mybatisPlus.service.ITenantService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 租户管理 服务实现类
 * </p>
 *
 * @author zl
 * @since 2021-10-15
 */
@Service
public class TenantServiceImpl extends ServiceImpl<TenantMapper, Tenant> implements ITenantService {

}
