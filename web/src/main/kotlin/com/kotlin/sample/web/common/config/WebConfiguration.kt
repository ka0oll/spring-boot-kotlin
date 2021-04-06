package com.kotlin.sample.web.common.config

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.kotlin.sample.web.common.ObjectMapperFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.util.*

@EnableWebMvc
@Configuration
class WebConfiguration : WebMvcConfigurer {
    override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>?>) {
        converters.add(mappingJackson2HttpMessageConverter())
        converters.add(StringHttpMessageConverter())
    }

    @Bean
    fun objectMapper(): ObjectMapper {
        val objectMapper = ObjectMapperFactory.newDefault()
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
        return objectMapper
    }

    @Bean
    fun mappingJackson2HttpMessageConverter(): MappingJackson2HttpMessageConverter {
        val converter = MappingJackson2HttpMessageConverter()
        converter.objectMapper = objectMapper()
        val mediaTypes: MutableList<MediaType> = ArrayList(converter.supportedMediaTypes)
        mediaTypes.add(MediaType.APPLICATION_JSON)
        converter.supportedMediaTypes = mediaTypes
        return converter
    }
}

