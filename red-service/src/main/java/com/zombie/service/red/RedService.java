package com.zombie.service.red;


import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;
import com.zombie.common.dto.ImgDTO;
import com.zombie.common.req.red.ContextImgReq;
import com.zombie.common.resp.red.ContextImgResp;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * 小红书服务
 *
 * @author XiePeiXun
 * @since 2024/08/02 17:06
 */
@Service
public class RedService {

    public ContextImgResp parseContextImg(ContextImgReq req) {
        // eg: http://xhslink.com/vysLuR
        String url = req.getUrl();
        ContextImgResp resp = new ContextImgResp();
        List<ImgDTO> imgList = Lists.newArrayList();
        try {
            Document doc = Jsoup.connect(url).get();
            Elements select = doc.select("meta[name=og:image]");
            for (Element element : select) {
                String content = element.attr("content");
                if(StrUtil.isNotBlank(content)) {
                    // 以/分割content
                    String[] contentList = content.split("/");
                    imgList.add(new ImgDTO(contentList[contentList.length-1], content));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        resp.setImgList(imgList);
        return resp;
    }

}
