//package com.example.java8.easy.code.mapper;
//
//import com.example.java8.easy.code.entity.SysUser;
//import java.util.List;
//
///**
// * 用户表(SysUser)表数据库访问层
// *
// * @author makejava
// * @since 2020-04-21 22:12:51
// */
//
//public interface SysUserMapper extends BaseMapper<SysUser> {
//
//    /**
////     * 通过ID查询单条数据
//     *
//     * @param userId 主键
//     * @return 实例对象
//     */
//    SysUser queryById(Integer userId);
//
//    /**
//     * 查询指定行数据
//     *
//     * @param offset 查询起始位置
//     * @param limit 查询条数
//     * @return 对象列表
//     */
//    List<SysUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);
//
//
//    /**
//     * 通过实体作为筛选条件查询
//     *
//     * @param sysUser 实例对象
//     * @return 对象列表
//     */
//    List<SysUser> queryAll(SysUser sysUser);
//
//    /**
//     * 新增数据
//     *
//     * @param sysUser 实例对象
//     * @return 影响行数
//     */
//    int insert(SysUser sysUser);
//
//    /**
//     * 修改数据
//     *
//     * @param sysUser 实例对象
//     * @return 影响行数
//     */
//    int update(SysUser sysUser);
//
//    /**
//     * 通过主键删除数据
//     *
//     * @param userId 主键
//     * @return 影响行数
//     */
//    int deleteById(Integer userId);
//
//}