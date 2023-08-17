package com.travelwink.first.geely.sddb.xmlNode;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TransmissionRate {

    @JacksonXmlProperty(localName = "Fast", isAttribute = true)
    private String fast = "10";

    @JacksonXmlProperty(localName = "Medium", isAttribute = true)
    private String medium = "100";

    @JacksonXmlProperty(localName = "Slow", isAttribute = true)
    private String slow = "1000";
}
