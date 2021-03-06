package com.yl.dao;

import com.yl.bean.TypeBlog;

import java.util.List;

/**
 * 博客-类型接口
 * @author YL
 * @date 2019/9/24 17:36
 */
public interface TypeBlogMapper extends BaseMapper<TypeBlog>{
    /**
     * 根据博客编号获取博客类型
     * @author yl
     * @date 2019/10/3 16:31
     * @param blogId id
     * @return java.util.List<com.yl.bean.TypeBlog>
     */
    List<TypeBlog> selectByBlogId(Integer blogId);

    /**
     * 删除
     * @author yl
     * @date 2019/10/3 20:04
     * @param typeBlog
     * @return int
     */
    int delete(TypeBlog typeBlog);
}