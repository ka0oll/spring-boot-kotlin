package com.kotlin.sample.web.common

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.DeserializationFeature
import java.time.LocalDateTime
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer
import java.time.LocalDate
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import java.time.LocalTime
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer
import com.fasterxml.jackson.module.kotlin.KotlinModule

object ObjectMapperFactory {
    fun newDefault(): ObjectMapper {
        val objectMapper = ObjectMapper()
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        val kotlinModule = KotlinModule()
        kotlinModule.addSerializer(
            LocalDateTime::class.java,
            LocalDateTimeSerializer(DateFormatterFactory.dateTimeFormatter())
        )
        kotlinModule.addDeserializer(
            LocalDateTime::class.java,
            LocalDateTimeDeserializer(DateFormatterFactory.dateTimeFormatter())
        )
        kotlinModule.addSerializer(
            LocalDate::class.java,
            LocalDateSerializer(DateFormatterFactory.dateFormatter())
        )
        kotlinModule.addDeserializer(
            LocalDate::class.java,
            LocalDateDeserializer(DateFormatterFactory.dateFormatter())
        )
        kotlinModule.addSerializer(
            LocalTime::class.java,
            LocalTimeSerializer(DateFormatterFactory.timeFormatter())
        )
        kotlinModule.addDeserializer(
            LocalTime::class.java,
            LocalTimeDeserializer(DateFormatterFactory.timeFormatter())
        )
        objectMapper.registerModule(kotlinModule)
        return objectMapper
    }
}
