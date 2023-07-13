package com.travel.global.entity

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter
class BooleanConverter : AttributeConverter<Boolean, String> {
    override fun convertToDatabaseColumn(attribute: Boolean?): String {
        return if (attribute != null && attribute) "Y" else "N"
    }

    override fun convertToEntityAttribute(dbData: String): Boolean {
        return "Y" == dbData
    }
}