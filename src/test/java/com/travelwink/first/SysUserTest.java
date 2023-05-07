package com.travelwink.first;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.travelwink.first.common.paginaton.PageInfo;
import com.travelwink.first.common.paginaton.Paging;
import com.travelwink.first.system.user.entity.SysUser;
import com.travelwink.first.system.user.mapper.SysUserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SysUserTest {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<SysUser> userList = sysUserMapper.selectList(null);
        Assertions.assertEquals(1, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testPartition() {
        System.out.println(("----- selectAll method test ------"));
        IPage<SysUser> page =  new PageInfo<>(1,3);
        PageInfo<SysUser> userPageList = sysUserMapper.selectPageList(page);
        Paging<SysUser> paging = new Paging<>(userPageList);
        List<SysUser> userList = paging.getRecords();
        userList.forEach(System.out::println);
    }
}
