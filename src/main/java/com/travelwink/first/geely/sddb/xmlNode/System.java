package com.travelwink.first.geely.sddb.xmlNode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class System {

    @JacksonXmlProperty(localName = "Name", isAttribute = true)
    private String name = "SPA_system";

    @JacksonXmlElementWrapper(localName = "NegativeResponseCodes")
    @JsonProperty("NegativeResponseCode")
    private List<NegativeResponseCode> negativeResponseCode;

    @JacksonXmlProperty(localName = "Tester")
    private Tester tester;

    @JacksonXmlElementWrapper(localName = "ECUs")
    @JsonProperty("ECU")
    private List<Ecu> ecu;

}
