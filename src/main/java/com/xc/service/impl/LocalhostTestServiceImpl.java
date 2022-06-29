package com.xc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xc.mapper.LocalTestMapper;
import com.xc.model.entity.LocalTest;
import com.xc.service.LocalhostTestService;
import org.springframework.stereotype.Service;

/**
 * @Author cuilb
 * @Data 2022 06 28 11:16
 * @Description
 */
@Service
public class LocalhostTestServiceImpl extends ServiceImpl<LocalTestMapper, LocalTest>
        implements LocalhostTestService {
}
