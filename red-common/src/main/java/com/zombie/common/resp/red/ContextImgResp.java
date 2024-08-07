package com.zombie.common.resp.red;

import com.zombie.common.dto.ImgDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 小红书图片数据返回
 *
 * @author XiePeiXun
 * @since 2024/08/05 12:34
 */
@Data
@ApiModel("小红书图片数据返回")
public class ContextImgResp {
    @ApiModelProperty("图片集合")
    private List<ImgDTO> imgList;
}
