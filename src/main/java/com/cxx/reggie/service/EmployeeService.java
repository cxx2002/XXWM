package com.cxx.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxx.reggie.pojo.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 员工信息(Employee)表服务接口
 *
 * @author 陈喜喜
 * @since 2022-08-18 10:19:52
 */
public interface EmployeeService extends IService<Employee> {

    int insertSelective(Employee employee);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Employee queryById(Long id);

    /**
     * 分页查询
     *
     * @param employee 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Employee> queryByPage(Employee employee, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    Employee insert2(Employee employee);

    /**
     * 修改数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    Employee update(Employee employee);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
