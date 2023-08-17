package com.travelwink.first;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.travelwink.first.common.paginaton.PageInfo;
import com.travelwink.first.common.paginaton.Paging;
import com.travelwink.first.system.user.entity.SysUser;
import com.travelwink.first.system.user.mapper.SysUserMapper;
import com.travelwink.first.system.user.param.SysUserPageParam;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SysUserTest {
    @Autowired
    private SysUserMapper sysUserMapper;

//    @Test
//    public void testSelect() {
//        System.out.println(("----- selectAll method test ------"));
//        List<SysUser> userList = sysUserMapper.selectList(null);
//        Assertions.assertEquals(1, userList.size());
//        userList.forEach(System.out::println);
//    }

//    @Test
//    public void testPartition() {
//        System.out.println(("----- selectAll method test ------"));
//        List<OrderItem> orderItemList = new ArrayList<>();
//        orderItemList.add(OrderItem.desc("username"));
//        IPage<SysUser> page =  new PageInfo<SysUser>(2,3).addOrder(orderItemList);
//        SysUserPageParam param = new SysUserPageParam();
//        IPage<SysUser> userPageList = sysUserMapper.selectPageList(page, param);
//        Paging<SysUser> paging = new Paging<>(userPageList);
//        List<SysUser> userList = paging.getRecords();
//        userList.forEach(System.out::println);
//    }
}
