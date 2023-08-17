package com.travelwink.first.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class FormattedDateInfo {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date formalDate = new Date();

    @JsonFormat(pattern = "dd MMM yyyy h:m:s a",locale = "en")
    Date customEnDate = new Date();

    @JsonFormat(pattern = "dd M yyyy h:m:s a")
    Date customCnDate = new Date();
}
