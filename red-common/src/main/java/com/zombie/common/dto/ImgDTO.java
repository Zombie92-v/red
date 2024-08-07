package com.zombie.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 图片数据
 *
 * @author XiePeiXun
 * @since 2024/08/05 12:34
 */
@Data
@ApiModel("图片数据")
@NoArgsConstructor
@AllArgsConstructor
public class ImgDTO {
    @ApiModelProperty("图片名")
    private String name;
    @ApiModelProperty("图片URL")
    private String url;
}
