package com.cxx.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.cxx.reggie.common.BaseContext;
import com.cxx.reggie.common.R;
import com.cxx.reggie.mapper.AddressBookMapper;
import com.cxx.reggie.pojo.AddressBook;
import com.cxx.reggie.service.AddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 地址管理(AddressBook)表控制层
 *
 * @author 陈喜喜
 * @since 2022-09-02 14:38:10
 */
@RestController
@RequestMapping("addressBook")
@Slf4j
public class AddressBookController {
    /**
     * 服务对象
     */
    @Resource
    private AddressBookService addressBookService;
    @Resource
    private AddressBookMapper addressBookMapper;

    /**
     * 新增数据
     *
     * @param addressBook 实体
     * @return 新增结果
     */
    @PostMapping
    public R<AddressBook> save(@RequestBody AddressBook addressBook) {
        addressBook.setUserId(BaseContext.getCurrentId());
        AddressBookController.log.info("addressBook:{}", addressBook);
        addressBookService.save(addressBook);
        return R.success(addressBook);
    }

    /**
     * 编辑数据  修改默认地址
     *
     * @param addressBook 实体
     * @return 编辑结果
     */
    @PutMapping("default")
    public R<AddressBook> edit(@RequestBody AddressBook addressBook) {
        AddressBookController.log.info("addressBook:{}", addressBook.toString());
        LambdaUpdateWrapper<AddressBook> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(AddressBook::getUserId, BaseContext.getCurrentId());
        updateWrapper.set(AddressBook::getIsDefault, 0);
        //先将全部地址is_default设置为0
        addressBookService.update(updateWrapper);

        addressBook.setIsDefault(1);
        addressBookService.updateById(addressBook);
        return R.success(addressBook);
    }

    /**
     * 获取默认地址
     *
     * @return {@link R}<{@link AddressBook}>
     */
    @GetMapping("default")
    public R<AddressBook> getDefault() {
        LambdaQueryWrapper<AddressBook> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AddressBook::getUserId, BaseContext.getCurrentId());
        queryWrapper.eq(AddressBook::getIsDefault, 1);
        AddressBook addressBook = addressBookService.getOne(queryWrapper);
        if (addressBook != null) return R.success(addressBook);
        else return R.error("未知错误，没有默认地址！");
    }

    /**
     * 查询指定用户的所有地址
     *
     * @param addressBook 筛选条件
     * @return 查询结果
     */
    @GetMapping("/list")
    public R<List<AddressBook>> list(AddressBook addressBook) {
        addressBook.setUserId(BaseContext.getCurrentId());
        AddressBookController.log.info("addressBook:{}", addressBook);
        LambdaQueryWrapper<AddressBook> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(null != addressBook.getUserId(), AddressBook::getUserId, addressBook.getUserId());
        queryWrapper.orderByDesc(AddressBook::getUpdateTime);
        return R.success(addressBookService.list(queryWrapper));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R queryById(@PathVariable("id") Long id) {
        AddressBook addressBook = addressBookService.getById(id);
        if (addressBook != null) return R.success(addressBook);
        else return R.error("此地址不存在！");
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return null;
    }

}

