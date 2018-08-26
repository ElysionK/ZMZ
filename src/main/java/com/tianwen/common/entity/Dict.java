package com.tianwen.common.entity;

import java.io.Serializable;


/**
 * 数据字典实体类。
 * 
 * 
 */
public class Dict implements Serializable
{
	private static final long serialVersionUID = 6991780120219659980L;

	/** 字典主键 */
    private Long dictId;

    /** 字典类型编码 */
    private String dictTypeId;

    /** 字典名称 */
    private String dictName;

    /** 字典值 */
    private String dictCode;

    /** 排序码 */
    private Integer sortNo;

    /** 状态 */
    private Integer status;

    /** 备注 */
    private String remark;

    public Long getDictId()
    {
        return dictId;
    }

    public void setDictId(final Long dictId)
    {
        this.dictId = dictId;
    }

    public String getDictName()
    {
        return dictName;
    }

    public void setDictName(final String dictName)
    {
        this.dictName = dictName;
    }

    public String getDictCode()
    {
        return dictCode;
    }

    public void setDictCode(final String dictCode)
    {
        this.dictCode = dictCode;
    }

    public Integer getSortNo()
    {
        return sortNo;
    }

    public void setSortNo(final Integer sortNo)
    {
        this.sortNo = sortNo;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(final Integer status)
    {
        this.status = status;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(final String remark)
    {
        this.remark = remark;
    }

    public String getDictTypeId()
    {
        return dictTypeId;
    }

    public void setDictTypeId(final String dictTypeId)
    {
        this.dictTypeId = dictTypeId;
    }

    @Override
    public String toString()
    {
        return "Dict [dictId=" + dictId + ", dictTypeId=" + dictTypeId + ", dictName=" + dictName + ", dictCode=" + dictCode + ", sortNo=" + sortNo + ", status=" + status + ", remark=" + remark + "]";
    }

}
