package com.travelwink.first.geely.sddb.xmlNode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ResponseItem {

    @JacksonXmlProperty(localName = "InDataType", isAttribute = true)
    private String inDataType;

    @JacksonXmlProperty(localName = "Name", isAttribute = true)
    private String name;

    @JacksonXmlProperty(localName = "Offset", isAttribute = true)
    private String offset;

    @JacksonXmlProperty(localName = "OutDataType", isAttribute = true)
    private String outDataType;

    @JacksonXmlProperty(localName = "ResultPrecision", isAttribute = true)
    private String resultPrecision;

    @JacksonXmlProperty(localName = "Size", isAttribute = true)
    private String size;

    @JacksonXmlProperty(localName = "ID")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String id;

    @JacksonXmlProperty(localName = "Formula")
    private String formula;

    @JacksonXmlProperty(localName = "CompareValue")
    private String compareValue;
}
