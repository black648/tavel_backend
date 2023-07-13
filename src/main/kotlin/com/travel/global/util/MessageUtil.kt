package com.travel.global.util

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.stereotype.Component
import java.util.*


@Component
class MessageUtil {
    @Autowired
    fun setMessageSource(messageSource: MessageSource?) {
        Companion.messageSource = messageSource
    }

    companion object {
        private var messageSource: MessageSource? = null
        fun getMessage(message: String): String {
            return try {
                messageSource!!.getMessage(message, null, Locale.KOREA)
            } catch (e: Exception) {
                "$message not found message"
            }
        }
    }
}
