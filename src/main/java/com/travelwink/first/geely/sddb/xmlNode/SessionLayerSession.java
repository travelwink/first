package com.travelwink.first.geely.sddb.xmlNode;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SessionLayerSession {

    @JacksonXmlProperty(localName = "ID", isAttribute = true)
    private String id;

    @JacksonXmlProperty(localName = "Name", isAttribute = true)
    private String name;

    @JacksonXmlProperty(localName = "S3Server", isAttribute = true)
    private String s3Server = "5000";

    @JacksonXmlProperty(localName = "P2ServerMax_default", isAttribute = true)
    private String p2ServerMax_default;

    @JacksonXmlProperty(localName = "P2StarServerMax_default", isAttribute = true)
    private String p2StarServerMax_default = "5000";

    @JacksonXmlProperty(localName = "p4ServerMax_default", isAttribute = true)
    private String p4ServerMax_default = "400";

    @JacksonXmlProperty(localName = "DeltaP2Vehicle_sigleframe", isAttribute = true)
    private String deltaP2Vehicle_sigleframe = "200";

    @JacksonXmlProperty(localName = "DeltaP2Vehicle_multiframe", isAttribute = true)
    private String deltaP2Vehicle_multiframe;

    @JacksonXmlProperty(localName = "DeltaP2Vehicle_multichannel", isAttribute = true)
    private String deltaP2Vehicle_multichannel = "90000";

    @JacksonXmlProperty(localName = "SupportOfQueuedRequests", isAttribute = true)
    private String SupportOfQueuedRequests = "0";

    @JacksonXmlProperty(localName = "MaxNumberOfDIDsForReadDID", isAttribute = true)
    private String maxNumberOfDIDsForReadDID;
}
