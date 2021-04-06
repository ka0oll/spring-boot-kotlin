package com.kotlin.sample.web.common

import org.modelmapper.ModelMapper
import org.modelmapper.config.Configuration.AccessLevel

object ModelMapperFactory {
    fun newFieldModelMapper(): ModelMapper {
        val modelMapper = ModelMapper()
        modelMapper.configuration.isFieldMatchingEnabled = true
        modelMapper.configuration.fieldAccessLevel = AccessLevel.PRIVATE
        return modelMapper
    }
}
