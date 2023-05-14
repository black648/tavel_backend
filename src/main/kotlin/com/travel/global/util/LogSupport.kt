package com.travel.global.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory

interface LogSupport {
    val logger: Logger get() = LoggerFactory.getLogger(this.javaClass)
}

//interface LogSupport {
//    val logger: Logger get() {
//        return LoggerFactory.getLogger(this.javaClass)
//    }
//}