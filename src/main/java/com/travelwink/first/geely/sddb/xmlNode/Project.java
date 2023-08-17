package com.travelwink.first.geely.sddb.xmlNode;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@TableName("t104_project")
@JacksonXmlRootElement(localName = "Project")
@JsonPropertyOrder({"Version","GeneratedAt","GeneratedByDETVersion","ProjectVersion","System"})
public class Project {

    @JsonIgnore
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    @JacksonXmlProperty(localName = "Name", isAttribute = true)
    private String name;

    @JacksonXmlProperty(localName = "Version")
    private String version = "1.0";

    // 29 Oct 2020 5:21:44 PM
    @JsonFormat(pattern = "dd MMM yyyy h:m:s a",locale = "en")
    @JacksonXmlProperty(localName = "GeneratedAt")
    private Date generatedAt = new Date();

    @JacksonXmlProperty(localName = "GeneratedByDETVersion")
    private String generatedByDETVersion = "5.0";

    @JacksonXmlProperty(localName = "ProjectVersion")
    private String projectVersion;

    @JacksonXmlProperty(localName = "System")
    private System system;

}
