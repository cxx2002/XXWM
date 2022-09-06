package com.cxx.reggie;

import com.cxx.reggie.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ReggieApplicationTests {

    @Resource
    EmployeeMapper employeeDao;

    @Test
    void contextLoads() {

        employeeDao.queryById(1L);
        employeeDao.count(null);
    }

}
