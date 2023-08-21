package com.travelwink.first.geely.sddb.xmlNode;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DTC {

    @JacksonXmlProperty(localName = "ID", isAttribute = true)
    private String id;

    @JacksonXmlProperty(localName = "Name", isAttribute = true)
    private String name;

    @JacksonXmlProperty(localName = "SWLabel", isAttribute = true)
    private String sWLabel;

    @JacksonXmlProperty(localName = "ConfirmedDTCLimit", isAttribute = true)
    private String confirmedDTCLimit;

    @JacksonXmlProperty(localName = "UnconfirmedDTCLimit", isAttribute = true)
    private String unconfirmedDTCLimit;

    @JacksonXmlProperty(localName = "AgedDTCLimit", isAttribute = true)
    private String agedDTCLimit;

    @JacksonXmlProperty(localName = "AgingCounter", isAttribute = true)
    private String agingCounter;

    @JacksonXmlProperty(localName = "WarningIndicator", isAttribute = true)
    private Boolean warningIndicator;

    @JacksonXmlProperty(localName = "DTCEventPriority", isAttribute = true)
    private String dtcEventPriority;

    @JacksonXmlProperty(localName = "FailedThreshold", isAttribute = true)
    private String failedThreshold;

    @JacksonXmlProperty(localName = "PassedThreshold", isAttribute = true)
    private String passedThreshold;

    @JacksonXmlProperty(localName = "IncrementStepSize", isAttribute = true)
    private String incrementStepSize;

    @JacksonXmlProperty(localName = "DecrementStepSize", isAttribute = true)
    private String decrementStepSize;

    @JacksonXmlProperty(localName = "JumpDown", isAttribute = true)
    private Boolean jumpDown;
}
