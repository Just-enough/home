package com.ssm.pojo;

/**
 * @author lg
 * @version 1.0
 * @Date 2020/1/10 0010
 * @since 1.8
 */
public class QueryCriteria {
    private String custName;
    private String custSource;
    private String custIndustory;
    private String custLevel;
    // 当前页码
    private int page=1;
    // 每页显示的行数
    private int size=10;

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustIndustory() {
        return custIndustory;
    }

    public void setCustIndustory(String custIndustory) {
        this.custIndustory = custIndustory;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
