package com.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.dao.CrmCustomerMapper;
import com.ssm.pojo.CrmCustomer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author lg
 * @version 1.0
 * @Date 2020/1/11 0011
 * @since 1.8
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PageHelperTest {
    @Autowired
    private CrmCustomerMapper customerMapper;
    @Test
    public void testPage(){
        // 设置分页信息 页码start row
        PageHelper.startPage(1,10);

//        执行查新
        List<CrmCustomer> customerList = customerMapper.selectByExample(null);
        PageInfo<CrmCustomer> pageInfo = new PageInfo<CrmCustomer>(customerList);
        System.out.println("总记录: " + pageInfo.getTotal());
        System.out.println("总页数: " + pageInfo.getPages());
        System.out.println("list :" + pageInfo.getSize());
    }

}
