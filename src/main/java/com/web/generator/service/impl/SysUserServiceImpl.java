package com.web.generator.service.impl;

import com.jfinal.plugin.activerecord.Page;
import io.jboot.aop.annotation.Bean;
import com.web.generator.service.SysUserService;
import com.web.generator.model.SysUser;
import io.jboot.components.cache.annotation.CacheEvict;
import io.jboot.components.cache.annotation.Cacheable;
import io.jboot.service.JbootServiceBase;


@Bean
public class SysUserServiceImpl extends JbootServiceBase<SysUser> implements SysUserService {

    @Cacheable(name = "myCache",key = "page:#(page)-#(size)")
    public Page<SysUser> paginate(int page, int size) {
        return DAO.paginate(page, size);
    }

    @Override
    @CacheEvict(name = "myCache",key = "*")
    public Object save(SysUser model) {
        return super.save(model);
    }

    @Override
    @CacheEvict(name = "myCache",key = "*")
    public boolean update(SysUser model) {
        return super.update(model);
    }

    @Override
    @CacheEvict(name = "myCache",key = "*")
    public boolean delete(SysUser model) {
        return super.delete(model);
    }
}