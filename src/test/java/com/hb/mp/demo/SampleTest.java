package com.hb.mp.demo;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hb.mp.demo.entity.User;
import com.hb.mp.demo.mapper.UserMapper;

@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.ge("id", 2);
        List<User> userList = userMapper.selectList(queryWrapper);
        Assert.assertEquals(4, userList.size());
        userList.forEach(System.out::println);
    }

}