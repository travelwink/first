package com.travelwink.first.geely.sddb.xmlNode;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@TableName("")
public class SubFunction {

    @JacksonXmlElementWrapper(localName = "Sessions")
    @JsonProperty("Session")
    private List<Session> sessions;

    @JacksonXmlElementWrapper(localName = "ResponseItems")
    @JsonProperty("ResponseItem")
    private List<ResponseItem> responseItems;

}
