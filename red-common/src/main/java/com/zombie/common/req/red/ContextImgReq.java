package com.zombie.common.req.red;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 小红书图片获取请求
 *
 * @author XiePeiXun
 * @since 2024/08/05 11:11
 */
@Data
@ApiModel("小红书图片获取请求")
public class ContextImgReq {
    @ApiModelProperty("小红书链接")
    @NotBlank(message = "小红书链接不能为空")
    private String url;
}
