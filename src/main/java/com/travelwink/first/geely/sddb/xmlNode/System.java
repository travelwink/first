package com.travelwink.first.geely.sddb.xmlNode;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@JacksonXmlRootElement(localName = "System")
public class System {

    @JacksonXmlProperty(localName = "Name", isAttribute = true)
    private String name = "SPA_system";

    @JacksonXmlElementWrapper(localName = "NegativeResponseCodes")
    private List<NegativeResponseCode> negativeResponseCode;

    private Tester tester;

    @JacksonXmlElementWrapper(localName = "ECUs")
    private Ecu ecu;

}
