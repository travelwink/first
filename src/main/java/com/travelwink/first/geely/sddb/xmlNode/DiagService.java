package com.travelwink.first.geely.sddb.xmlNode;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class DiagService {

    @JsonIgnore
    private String id;

    @JacksonXmlProperty(localName = "ID", isAttribute = true)
    private String service;

    @JacksonXmlProperty(localName = "Name", isAttribute = true)
    private String serviceName;

    @JsonIgnore
    private String fkT100EcuVariantId;

    @JacksonXmlElementWrapper(localName = "NegativeResponseCodes")
    @JsonProperty("NegativeResponseCode")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NegativeResponseCode> negativeResponseCodes;

    @JacksonXmlElementWrapper(localName = "DTCS")
    @JsonProperty("DTC")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DTC> dtcs;

    @JacksonXmlElementWrapper(localName = "StatusBits")
    @JsonProperty("ResponseItem")
    private List<ResponseItem> responseItem;

    @JacksonXmlElementWrapper(localName = "Subfunctions")
    @JsonProperty("Subfunction")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SubFunction> subFunctions;

    @JacksonXmlElementWrapper(localName = "Sessions")
    @JsonProperty("Session")
    private List<Session> sessions;

    @JacksonXmlElementWrapper(localName = "DataParameters")
    @JsonProperty("DataParameter")
    private List<DataParameter> dataParameters;

}
