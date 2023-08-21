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
@TableName("t110_service_ecu_variant")
public class DiagService {

    @JacksonXmlProperty(localName = "ID", isAttribute = true)
    private String id;

    @JacksonXmlProperty(localName = "Name", isAttribute = true)
    private String name;

    @JsonIgnore
    private String fkT100EcuVariantId;

    @JacksonXmlElementWrapper(localName = "NegativeResponseCodes")
    @JsonProperty("NegativeResponseCode")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NegativeResponseCode> negativeResponseCodes;

    @JacksonXmlElementWrapper(localName = "Subfunctions")
    @JsonProperty("Subfunction")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SubFunction> subFunctions;

    @JacksonXmlElementWrapper(localName = "DTCS")
    @JsonProperty("DTC")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DTC> dtcs;

    @JacksonXmlElementWrapper(localName = "StatusBits")
    @JsonProperty("ResponseItem")
    private List<ResponseItem> responseItem;

}
