package org.zerock.springex.controller.formatter;

// 문자열 데이터를 날짜 데이터로 변경하는 클래스


import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateFormatter implements Formatter<LocalDate> {
    // alt + insert
    @Override
    public LocalDate parse(String text, Locale locale) throws ParseException {
        return LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
    }

    @Override
    public String print(LocalDate object, Locale locale) {
        // 날짜 데이터를 문자열 yyyy-mm-dd 형식으로 변경하여 출력
        return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(object);
    }
}
