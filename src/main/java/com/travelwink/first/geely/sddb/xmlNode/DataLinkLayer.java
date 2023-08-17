package com.travelwink.first.geely.sddb.xmlNode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DataLinkLayer {

    @JacksonXmlProperty(localName = "Type", isAttribute = true)
    private String type;

    @JacksonXmlProperty(localName = "LINVersion")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String linVersion;

    @JacksonXmlProperty(localName = "AddressFormat")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String addressFormat;

    @JacksonXmlProperty(localName = "Baudrate")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String baudRate;
}
