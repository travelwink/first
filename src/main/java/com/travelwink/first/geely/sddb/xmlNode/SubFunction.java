package com.travelwink.first.geely.sddb.xmlNode;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@TableName("t110_service_ecu_variant")
public class SubFunction {

    @JacksonXmlProperty(localName = "ID", isAttribute = true)
    private String mode;

    @JacksonXmlProperty(localName = "Name", isAttribute = true)
    private String modeName;

    @JsonIgnore
    private String id;

    @JsonIgnore
    private String fkTInit130TimingServiceDefault;

    @JsonIgnore
    private String fkT130InitTimingService;

    @JacksonXmlElementWrapper(localName = "Sessions")
    @JsonProperty("Session")
    private List<Session> sessions;

    @JacksonXmlElementWrapper(localName = "ResponseItems")
    @JsonProperty("ResponseItem")
    private List<ResponseItem> responseItems;

}
