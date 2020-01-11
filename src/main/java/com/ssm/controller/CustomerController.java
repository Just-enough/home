package com.ssm.controller;

import com.ssm.pojo.CrmCustomer;
import com.ssm.pojo.CrmDict;
import com.ssm.pojo.QueryCriteria;
import com.ssm.service.CustomerService;
import com.ssm.service.DictService;
import com.ssm.utils.Paging;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author lg
 * @version 1.0
 * @Date 2020/1/10 0010
 * @since 1.8
 */
@Controller
@RequestMapping("customer")
public class CustomerController {

    @Value("${dict.type.source}")
    private String dicTypeSource;
    @Value("${dict.type.industry}")
    private String dicTypeIndustry;
    @Value("${dict.type.level}")
    private String dicTypeLevel;

    @Autowired
    private CustomerService customerService;
    @Autowired
    private DictService dictService;
    /**
     * 根据条件查询客户列表
     * @param queryCriteria 传递查询条件
     * @return 返回客户列表
     */
    @RequestMapping("list")
    public String showList(QueryCriteria queryCriteria, Model model) throws UnsupportedEncodingException {
        // 初始化查询条件的下拉列表
        // 客户来源

        List<CrmDict> sourceList = dictService.getDicListByTypeCode(dicTypeSource);

        // 客户行业
        List<CrmDict> industryList = dictService.getDicListByTypeCode(dicTypeIndustry);

        // 客户级别
        List<CrmDict> levelList = dictService.getDicListByTypeCode(dicTypeLevel);

        Paging paging = customerService.getCustomerList(queryCriteria);

        model.addAttribute("paging", paging);
        model.addAttribute("fromType", sourceList);
        model.addAttribute("industryType", industryList);
        model.addAttribute("levelType", levelList);

        // 查询条件 回显
        model.addAttribute("custSource", queryCriteria.getCustSource());
        model.addAttribute("custName", queryCriteria.getCustName());
        model.addAttribute("custIndustry", queryCriteria.getCustIndustory());
        model.addAttribute("custLevel",queryCriteria.getCustLevel());
        return "customer";

    }
}
