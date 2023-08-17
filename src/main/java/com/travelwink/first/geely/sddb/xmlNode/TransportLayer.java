package com.travelwink.first.geely.sddb.xmlNode;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class TransportLayer {

    @JacksonXmlProperty(localName = "Type", isAttribute = true)
    private String type;

    @JacksonXmlProperty(localName = "PeriodicResponseIDs")
    private String periodicResponseIDs;

    @JacksonXmlProperty(localName = "Sessions")
    private List<TransportLayerSession> transportLayerSessions;
}
