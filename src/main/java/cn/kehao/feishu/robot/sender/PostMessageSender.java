package cn.kehao.feishu.robot.sender;

import cn.hutool.http.HttpRequest;
import cn.kehao.feishu.robot.msg.PostMessage;
import cn.kehao.feishu.robot.msg.TextMessage;
import cn.kehao.feishu.robot.pojo.FeiShuRobotProperties;
import cn.kehao.feishu.robot.req.RequestBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 富文本消息发送器
 */
@Component
public class PostMessageSender {
    @Autowired
    private FeiShuRobotProperties feiShuRobotProperties;

    public static String send(String url, PostMessage msg) {
        String result = HttpRequest.post(url)
                .body(RequestBuilder.buildPostMessageReq(msg))
                .execute().body();
        return result;
    }


    public String send(PostMessage msg) {
        return PostMessageSender.send(feiShuRobotProperties.getWebhookUrl(),msg);
    }

}
