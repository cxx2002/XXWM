package com.cxx.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxx.reggie.pojo.AddressBook;
import com.cxx.reggie.service.AddressBookService;
import com.cxx.reggie.mapper.AddressBookMapper;
import org.springframework.stereotype.Service;

/**
* @author 陈喜喜
* @description 针对表【address_book(地址管理)】的数据库操作Service实现
* @createDate 2022-09-02 14:37:58
*/
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook>
    implements AddressBookService{

}




