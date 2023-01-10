package com.travel.global.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageUtil {
    private static MessageSource messageSource;

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        MessageUtil.messageSource = messageSource;
    }

    public static String getMessage(String message) {
        try {
            return messageSource.getMessage(message, null, Locale.KOREA);
        } catch (Exception e) {
            return message + " not found message";
        }
    }
}
