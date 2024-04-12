package com.travelwink.first.common.util;

import lombok.extern.slf4j.Slf4j;
import org.fusesource.jansi.Ansi;

/**
 * @author chris
 */
@Slf4j
public class AnsiUtil {

    public static String getAnsi(Ansi.Color color,String text){
        return Ansi.ansi().eraseScreen().fg(color).a(text).reset().toString();
    }

}
