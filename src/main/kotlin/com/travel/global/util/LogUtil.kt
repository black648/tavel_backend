//package com.travel.global.util
//
//import org.slf4j.Logger
//import org.slf4j.LoggerFactory
//import org.springframework.data.annotation.ReadOnlyProperty
//import kotlin.reflect.KProperty
//
//// https://www.reddit.com/r/Kotlin/comments/8gbiul/slf4j_loggers_in_3_ways/
//
//class LogUtil : ReadOnlyProperty<Any?, Logger> {
//    companion object {
//        private fun <T>createLogger(clazz: Class<T>) : Logger {
//            return LoggerFactory.getLogger(clazz)
//        }
//    }
//
//    private var logger : Logger? = null
//
//    override operator fun getValue(thisRef: Any?, property: KProperty<*>): Logger {
//        if(logger == null) {
//            logger = createLogger(thisRef!!.javaClass)
//        }
//        return logger!!
//    }
//}