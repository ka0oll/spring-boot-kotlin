package com.kotlin.web.common

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.databind.module.SimpleModule
import java.time.LocalDateTime
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer
import java.time.LocalDate
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import java.time.LocalTime
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer

object ObjectMapperFactory {
    fun newDefault(): ObjectMapper {
        val objectMapper = ObjectMapper()
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        objectMapper.registerModule(JavaTimeModule())
        val simpleModule = SimpleModule()
        simpleModule.addSerializer(
            LocalDateTime::class.java,
            LocalDateTimeSerializer(DateFormatterFactory.dateTimeFormatter())
        )
        simpleModule.addDeserializer(
            LocalDateTime::class.java,
            LocalDateTimeDeserializer(DateFormatterFactory.dateTimeFormatter())
        )
        simpleModule.addSerializer(
            LocalDate::class.java,
            LocalDateSerializer(DateFormatterFactory.dateFormatter())
        )
        simpleModule.addDeserializer(
            LocalDate::class.java,
            LocalDateDeserializer(DateFormatterFactory.dateFormatter())
        )
        simpleModule.addSerializer(
            LocalTime::class.java,
            LocalTimeSerializer(DateFormatterFactory.timeFormatter())
        )
        simpleModule.addDeserializer(
            LocalTime::class.java,
            LocalTimeDeserializer(DateFormatterFactory.timeFormatter())
        )
        objectMapper.registerModule(simpleModule)
        return objectMapper
    }
}
