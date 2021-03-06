package com.yl.service.impl;

import com.yl.dao.BaseMapper;
import com.yl.service.BaseService;

import java.util.List;

/**
 * 接口实现层父类
 * @author YL
 * @date 11:49 2019/9/16
 */
public class BaseServiceImpl<T> implements BaseService<T> {

    BaseMapper<T> baseMapper;

    @Override
    public int deleteByPrimaryKeys(String[] id) {
        return baseMapper.deleteByPrimaryKeys(id);
    }

    @Override
    public int insert(T record) {
        return baseMapper.insert(record);
    }

    @Override
    public int insertSelective(T record) {
        return baseMapper.insertSelective(record);
    }

    @Override
    public T selectByPrimaryKey(Integer id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        return baseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        return baseMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<T> selectAll() {
        return baseMapper.selectAll();
    }
}
