package com.ssm.service.impl;

import com.ssm.dao.CrmDictMapper;
import com.ssm.pojo.CrmDict;
import com.ssm.pojo.CrmDictExample;
import com.ssm.service.DictService;
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
public class DictServiceImpl implements DictService {
    @Autowired
    private CrmDictMapper crmDictMapper;
    /**
     * 通过类型码查询列表
     * @param typeCode 传入类型码
     * @return 返回对应列表字段
     */
    @Override
    public List<CrmDict> getDicListByTypeCode(String typeCode) {
        CrmDictExample example = new CrmDictExample();
        CrmDictExample.Criteria criteria = example.createCriteria();
        criteria.andDictTypeCodeEqualTo(typeCode);
        return crmDictMapper.selectByExample(example);
    }
}
