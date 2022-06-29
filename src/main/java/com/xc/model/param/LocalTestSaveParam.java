package com.xc.model.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * @Author cuilb
 * @Data 2022 06 28 13:51
 * @Description
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ApiModel("localTest保存类")
public class LocalTestSaveParam {


    @ApiModelProperty("名字")
    @NotNull(message = "姓名不能为空")
    private String name;

    @ApiModelProperty("年龄")
    @NotNull(message = "年龄不能为空")
    private Integer age;

}
