package com.travelwink.first.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ContentTypeEnum {
    // video

    // audio

    // image

    // text 文本
    TEXT_HTML("text/html"),
    TEXT_SSE("text/event-stream"), // Server Send Events
    TEXT_XML("text/xml"),

    // application 某种二进制数据
    APP_JSON("application/json"),
    APP_OCTET("application/octet-stream"), // Note: 无特定的、未知的字节流，配合 Content-Disposition: attachment; filename=<fileName> 的 response header，客户端会直接下载 (8 bit = 1 byte = 1 octet)
    APP_XML("application/xml"),

    ;

    private final String value;

}
