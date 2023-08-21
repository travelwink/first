package com.travelwink.first.geely.sddb.xmlNode;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.List;

@Data
@JacksonXmlRootElement(localName = "SW")
@TableName("t100_ecu_variant")
public class Sw {

    @JsonIgnore
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    @JacksonXmlProperty(localName = "DiagnosticPartNumber",isAttribute = true)
    private String diagnosticPartNumber;

    @JacksonXmlProperty(localName = "Name",isAttribute = true)
    private String name;

    @JacksonXmlProperty(localName = "Type",isAttribute = true)
    private String type;

    @JsonIgnore
    private String busName;

    @JsonIgnore
    private String busRate;

    @JsonIgnore
    private String addressFormat;

    @JsonIgnore
    private String timingInitId;

    @JacksonXmlProperty(localName = "MaxNumberOfResendTransfer")
    private String maxNumberOfResendTransfer = "2";

    @JacksonXmlProperty(localName = "ExtraEraseTimePerMB")
    private String extraEraseTimePerMB = "20000";

    @JacksonXmlProperty(localName = "StartupTime")
    private String startupTime;

    @JacksonXmlProperty(localName = "DTCStatusAvailabilityMask")
    private String dTCStatusAvailabilityMask;

    @JacksonXmlProperty(localName = "TransmissionRate")
    private TransmissionRate transmissionRate;

    @JacksonXmlElementWrapper(localName = "DataLinkLayers")
    @JsonProperty("DataLinkLayer")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DataLinkLayer> dataLinkLayer;

    @JacksonXmlElementWrapper(localName = "TransportLayers")
    @JsonProperty("TransportLayer")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TransportLayer> transportLayer;

    @JacksonXmlElementWrapper(localName = "SessionLayers")
    @JsonProperty("SessionLayer")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SessionLayerSession> sessionLayer;

    @JacksonXmlElementWrapper(localName = "Services")
    @JsonProperty("Service")
    private List<DiagService> diagServices;
}
