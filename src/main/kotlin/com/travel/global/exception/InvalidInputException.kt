package com.travel.global.exception

class InvalidInputException(
    val fieldName: String = "",
    message: String = "Invalid Input"
): RuntimeException(message)