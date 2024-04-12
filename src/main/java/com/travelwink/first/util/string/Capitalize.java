package com.travelwink.first.util.string;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class Capitalize {

    /**
     * 首字母大写
     * @param sentence
     * @return
     */
    public String capitalizeTheFirstLetter (String sentence) {
        log.info("Result is: " + StringUtils.capitalize(sentence));
        return StringUtils.capitalize(sentence);
    }

    public static void main(String[] args) {
        String str = "my name is chris.";

        String isMoreThanOrEqualTo = "≥";
        String greaterThan = ">";
        String isLessThanOrEqualTo = "≤";
        String notEqualTo = "≠";
        String lessThan = "<";

        log.info("≥ syntax encoder is:" + StringEscapeUtils.escapeXml(isMoreThanOrEqualTo));
        log.info("> syntax encoder is:" + StringEscapeUtils.escapeXml(greaterThan));
        log.info("≤ syntax encoder is:" + StringEscapeUtils.escapeXml(isLessThanOrEqualTo));
        log.info("≠ syntax encoder is:" + StringEscapeUtils.escapeXml(notEqualTo));
    }
}
