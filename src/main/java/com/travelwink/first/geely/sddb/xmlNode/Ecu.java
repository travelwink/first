package com.travelwink.first.geely.sddb.xmlNode;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@TableName("t101_ecu")
public class Ecu {

    @JsonIgnore
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    @JsonIgnore
    private String projectEcuRelId;

    @JacksonXmlProperty(localName = "IsBootloader", isAttribute = true)
    private String isBootloader = "1";

    @JacksonXmlProperty(localName = "Name", isAttribute = true)
    private String name;

    @JacksonXmlProperty(isAttribute = true)
    private String address;

    @JacksonXmlElementWrapper(localName = "Sws")
    @JsonProperty("Sw")
    private List<Sw> sw;
}
