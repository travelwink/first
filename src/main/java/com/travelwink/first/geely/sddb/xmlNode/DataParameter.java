package com.travelwink.first.geely.sddb.xmlNode;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DataParameter {

    @JacksonXmlProperty(localName = "ID", isAttribute = true)
    private String id = "FFFFFF";

    @JacksonXmlProperty(localName = "Name", isAttribute = true)
    private String name = "All groups";

    @JacksonXmlProperty(localName = "Size", isAttribute = true)
    private String size = "3";
}
