package com.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.dao.CrmCustomerMapper;
import com.ssm.pojo.CrmCustomer;
import com.ssm.pojo.CrmCustomerExample;
import com.ssm.pojo.QueryCriteria;
import com.ssm.service.CustomerService;
import com.ssm.utils.Paging;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lg
 * @version 1.0
 * @Date 2020/1/10 0010
 * @since 1.8
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CrmCustomerMapper crmCustomerMapper;
    @Override
    public Paging getCustomerList(QueryCriteria queryCriteria) {

        CrmCustomerExample example = new CrmCustomerExample();
        CrmCustomerExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(queryCriteria.getCustName())) {
            criteria.andCustNameLike("%"+queryCriteria.getCustName()+"%");
        }
        if (StringUtils.isNotBlank(queryCriteria.getCustSource())){
            criteria.andCustSourceEqualTo(queryCriteria.getCustSource());
        }
        if (StringUtils.isNotBlank(queryCriteria.getCustIndustory())) {
            criteria.andCustIndustryEqualTo(queryCriteria.getCustIndustory());
        }
        if (StringUtils.isNotBlank(queryCriteria.getCustLevel())) {
            criteria.andCustLevelEqualTo(queryCriteria.getCustLevel());
        }
        // 设置分页条件
        PageHelper.startPage(queryCriteria.getPage(),queryCriteria.getSize());
        // 条件查询的结果
        List<CrmCustomer> customerList = crmCustomerMapper.selectByExample(example);
        // 进行分页
        Paging<CrmCustomer> paging = new Paging<CrmCustomer>();

        // 将分页后的数据 传入PageInfo中 获取 分页信息
        PageInfo<CrmCustomer> pageInfo = new PageInfo<CrmCustomer>(customerList);
        // 设置 Pading 分页数据
        // 总记录数
        long total = pageInfo.getTotal();
        paging.setTotal((int) total);
        // 当前页数
        paging.setPage(queryCriteria.getPage());
        // 每页显示记录行数
        paging.setSize(queryCriteria.getSize());
        // 设置页面数据 List
        paging.setRows(customerList);
        // 返回页面数据
        return paging;
    }

}
