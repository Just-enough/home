package com.ssm.service;

import com.ssm.pojo.CrmDict;

import java.util.List;

/**
 * @author Administrator
 */
public interface DictService {
    /**
     * 通过类型码 获取 字节
     * @param typeCode
     * @return
     */
   List<CrmDict> getDicListByTypeCode(String typeCode);
}
