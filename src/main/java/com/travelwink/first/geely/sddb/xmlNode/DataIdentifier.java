package com.travelwink.first.geely.sddb.xmlNode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class DataIdentifier {

    @JacksonXmlProperty(localName = "ID", isAttribute = true)
    private String id;

    @JacksonXmlProperty(localName = "Name", isAttribute = true)
    private String name;

    @JacksonXmlProperty(localName = "Size", isAttribute = true)
    private String size;

    @JacksonXmlElementWrapper(localName = "Sessions")
    @JsonProperty("session")
    private List<Session> sessions;

    @JacksonXmlElementWrapper(localName = "ResponseItems")
    @JsonProperty("ResponseItem")
    private List<ResponseItem> responseItems;
}
