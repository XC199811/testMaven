package com.xc.busService.impl;

import com.xc.busService.BusLocalTestService;
import com.xc.model.converter.LocalTestConverter;
import com.xc.model.entity.LocalTest;
import com.xc.model.param.LocalTestSaveParam;
import com.xc.service.LocalhostTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Author cuilb
 * @Data 2022 06 28 14:26
 * @Description
 */
@Service
@RequiredArgsConstructor
public class BusLocalTestServiceImpl implements BusLocalTestService {

    private final LocalhostTestService localhostTestService;

    @Override
    public Boolean saveOne(LocalTestSaveParam saveParam) {
        LocalTest localTest = LocalTestConverter.INSTANCE.localTestParam2LocalTest(saveParam);
        return localhostTestService.save(localTest);
    }
}
