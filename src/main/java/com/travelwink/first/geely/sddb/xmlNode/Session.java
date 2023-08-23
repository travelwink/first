package com.travelwink.first.geely.sddb.xmlNode;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("")
public class Session {

    @JacksonXmlProperty(localName = "ID", isAttribute = true)
    private String mode;

    @JacksonXmlProperty(localName = "Name", isAttribute = true)
    private String modeName;

    @JacksonXmlProperty(localName = "P2ServerMax", isAttribute = true)
    private String p2ServerMax;

    @JacksonXmlProperty(localName = "P4ServerMax", isAttribute = true)
    private String p4ServerMax;
}
