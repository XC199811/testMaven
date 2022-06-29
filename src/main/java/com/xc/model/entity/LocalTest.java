package com.xc.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.LocalDateTime;

/**
 * @Author cuilb
 * @Data 2022 06 28 10:15
 * @Description
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@TableName("test2")
public class LocalTest {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer age;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
