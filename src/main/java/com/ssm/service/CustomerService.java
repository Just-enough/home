package com.ssm.service;

import com.ssm.pojo.CrmCustomer;
import com.ssm.pojo.QueryCriteria;
import com.ssm.utils.Paging;

import java.util.List;

/**
 * @author lg
 * @version 1.0
 * @Date 2020/1/10 0010
 * @since 1.8
 */
public interface CustomerService {
    /**
     * 通过查询条件查询结果
     * @param queryCriteria 查询条件
     * @return 查询结果
     */
    Paging getCustomerList(QueryCriteria queryCriteria);

}
