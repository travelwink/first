package com.travelwink.first.test;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author chris
 */
@Data
@AllArgsConstructor
public class Payload {
    private LocalDate date;
    private LocalDateTime dateTime;


}
