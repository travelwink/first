package com.travelwink.first.geely.sddb.xmlNode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Tester {

    @JacksonXmlProperty(localName = "Name", isAttribute = true)
    private String name = "DVAorDSA";

    @JacksonXmlProperty(isAttribute = true)
    private String address = "0E80";

    @JacksonXmlProperty(localName = "S3Client")
    private String s3Client = "2000";

    @JacksonXmlProperty(localName = "DeltaP2ExternalResponseMax")
    private String deltaP2ExternalResponseMax = "5";

    @JacksonXmlProperty(localName = "DeltaP2ExternalRequestMax")
    private String deltaP2ExternalRequestMax = "1000";

    @JacksonXmlElementWrapper(localName = "SessionLayer")
    @JsonProperty("Session")
    private List<TesterSessionLayerSession> testerSessionLayerSession;

}
