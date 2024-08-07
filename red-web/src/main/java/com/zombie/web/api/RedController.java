package com.zombie.web.api;

import com.zombie.common.dto.ApiResponse;
import com.zombie.common.req.red.ContextImgReq;
import com.zombie.common.resp.red.ContextImgResp;
import com.zombie.service.red.RedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 小红书控制器
 *
 * @author XiePeiXun
 * @since 2024/08/05 14:01
 */
@RestController
@Api(value = "小红书-相关Api", tags = "小红书-相关Api")
public class RedController {
    @Resource
    private RedService redService;

    @PostMapping("/red/getImgList")
    @ApiOperation("获取小红书图片列表")
    public ApiResponse<ContextImgResp> getImgList(@RequestBody @Validated ContextImgReq req) {
        return ApiResponse.success(redService.parseContextImg(req));
    }
}