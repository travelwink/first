package com.travelwink.first.geely.sddb.xmlNode;

import com.baomidou.mybatisplus.annotation.OrderBy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * @description Negative Response Code <br>
 * 消极响应代码 XML Node
 *
 * @author Min.Liao
 * @createTime 2023-08-17
 */
@Data
@JacksonXmlRootElement(localName = "NegativeResponseCode")
@TableName("t115_nrc")
public class NegativeResponseCode {

    @TableField("nrc")
    @OrderBy(asc = true)
    @JacksonXmlProperty(localName = "Code", isAttribute = true)
    private String code;

    @TableField("description")
    @JacksonXmlProperty(localName = "Name", isAttribute = true)
    private String name;
}
