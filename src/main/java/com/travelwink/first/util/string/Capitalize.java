package com.travelwink.first.util.string;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class Capitalize {
    public static void main(String[] args) {
        String str = "my name is chris.";
        log.info("Result is: " + StringUtils.capitalize(str));
    }
}
