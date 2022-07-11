package cn.kehao.feishu.robot.sender;

import cn.hutool.http.HttpRequest;
import cn.kehao.feishu.robot.msg.ImageMessage;
import cn.kehao.feishu.robot.msg.TextMessage;
import cn.kehao.feishu.robot.pojo.FeiShuRobotProperties;
import cn.kehao.feishu.robot.req.RequestBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 图片消息发送器
 */
@Component
public class ImageMessageSender {
    @Autowired
    private FeiShuRobotProperties feiShuRobotProperties;

    public static String send(String url, ImageMessage msg) {
        String result = HttpRequest.post(url)
                .body(RequestBuilder.buildImageMessageReq(msg))
                .execute().body();
        return result;
    }

    public String send(ImageMessage msg) {
       return ImageMessageSender.send(feiShuRobotProperties.getWebhookUrl(),msg);
    }
}
