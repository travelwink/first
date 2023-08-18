package com.travelwink.first.geely.sddb.xmlNode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TransportLayerSession {

    @JacksonXmlProperty(localName = "ID", isAttribute = true)
    private String id;

    @JacksonXmlProperty(localName = "Name", isAttribute = true)
    private String name;

    @JacksonXmlProperty(localName = "C_Cs_FC_to_CF_Performance_us")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String fc2CfPerformance;

    @JacksonXmlProperty(localName = "C_Cs_CF_to_CF_Performance_us")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String cf2CfPerformance;

    @JacksonXmlProperty(localName = "C_Br_Performance_us")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String cBrPerformance;

    @JacksonXmlProperty(localName = "C_As_Timeout")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String cAsTimeout;

    @JacksonXmlProperty(localName = "C_Ar_Timeout")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String cArTimeout;

    @JacksonXmlProperty(localName = "C_Bs_Timeout")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String cBsTimeout;

    @JacksonXmlProperty(localName = "C_Cr_Timeout")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String cCrTimeout;

    @JacksonXmlProperty(localName = "N_Cs_Performance_us")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String nCsPerformance;

    @JacksonXmlProperty(localName = "N_Br_Performance_us")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String nBrPerformance;

    @JacksonXmlProperty(localName = "N_As_Timeout")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String nAsTimeout;

    @JacksonXmlProperty(localName = "N_Ar_Timeout")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String nArTimeout;

    @JacksonXmlProperty(localName = "N_Bs_Timeout")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String nBsTimeout;

    @JacksonXmlProperty(localName = "N_Cr_Timeout")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String nCrTimout;

    @JacksonXmlProperty(localName = "PDUMaxLength")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String pduMaxLength;

    @JacksonXmlProperty(localName = "A_DoIP_Diagnostic_Message_timeout")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String aDoIPDiagnosticMessageTimeout;

    @JacksonXmlProperty(localName = "STMin")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String sTMin;
}
