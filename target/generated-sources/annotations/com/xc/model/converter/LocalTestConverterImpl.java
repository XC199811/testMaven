package com.xc.model.converter;

import com.xc.model.entity.LocalTest;
import com.xc.model.entity.LocalTest.LocalTestBuilder;
import com.xc.model.param.LocalTestSaveParam;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-29T10:19:10+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class LocalTestConverterImpl implements LocalTestConverter {

    @Override
    public LocalTest localTestParam2LocalTest(LocalTestSaveParam localTestSaveParam) {
        if ( localTestSaveParam == null ) {
            return null;
        }

        LocalTestBuilder localTest = LocalTest.builder();

        localTest.name( localTestSaveParam.getName() );
        localTest.age( localTestSaveParam.getAge() );

        return localTest.build();
    }
}
