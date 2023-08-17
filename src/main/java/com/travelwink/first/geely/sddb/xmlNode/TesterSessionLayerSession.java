package com.travelwink.first.geely.sddb.xmlNode;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TesterSessionLayerSession {

    @JacksonXmlProperty(localName = "DeltaP2VehicleFunc_multichannel", isAttribute = true)
    private String deltaP2VehicleFunc_multichannel = "90000";

    @JacksonXmlProperty(localName = "ID", isAttribute = true)
    private String id;

    @JacksonXmlProperty(localName = "Name", isAttribute = true)
    private String name;

    @JacksonXmlProperty(localName = "P2ServerFunc_default", isAttribute = true)
    private String p2ServerFunc_default = "50";

    @JacksonXmlProperty(localName = "P2StarServerFunc_default", isAttribute = true)
    private String p2StarServerFunc_default = "5000";

    @JacksonXmlProperty(localName = "P4ServerFunc_default", isAttribute = true)
    private String p4ServerFunc_default = "400";

}
