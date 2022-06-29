package com.xc.model.converter;

import com.xc.model.entity.LocalTest;
import com.xc.model.param.LocalTestSaveParam;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author cuilb
 * @Data 2022 06 28 14:04
 * @Description
 */
@Mapper
public interface LocalTestConverter {

    LocalTestConverter INSTANCE = Mappers.getMapper(LocalTestConverter.class);

    LocalTest localTestParam2LocalTest(LocalTestSaveParam localTestSaveParam);

}
