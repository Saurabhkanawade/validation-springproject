package com.example.validation.mapper;

import com.example.validation.entity.PersonEntity;
import com.example.validation.model.PersonModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonEntity modelToEntity(PersonModel personModel);
}
