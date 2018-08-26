package com.tianwen.common.entity;

/**
 * 字典类型实体类。
 * 
 * @author 罗军林
 * 
 */
public class DictType
{
    /** 字典类型编码，同时也是主键 */
    private String dictTypeId;

    /** 字典类型名 */
    private String dictTypeName;

    /** 备注 */
    private String remak;

    public String getDictTypeId()
    {
        return dictTypeId;
    }

    public void setDictTypeId(String dictTypeId)
    {
        this.dictTypeId = dictTypeId;
    }

    public String getDictTypeName()
    {
        return dictTypeName;
    }

    public void setDictTypeName(String dictTypeName)
    {
        this.dictTypeName = dictTypeName;
    }

    public String getRemak()
    {
        return remak;
    }

    public void setRemak(String remak)
    {
        this.remak = remak;
    }

}
