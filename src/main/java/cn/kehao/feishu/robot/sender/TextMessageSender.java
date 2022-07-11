package cn.kehao.feishu.robot.sender;

import cn.hutool.http.HttpRequest;
import cn.kehao.feishu.robot.msg.TextMessage;
import cn.kehao.feishu.robot.pojo.FeiShuRobotProperties;
import cn.kehao.feishu.robot.req.RequestBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 文本消息发送器
 */
@Component
public class TextMessageSender  {

    @Autowired
    private FeiShuRobotProperties feiShuRobotProperties;


    public String send(TextMessage msg) {
        return TextMessageSender.send(feiShuRobotProperties.getWebhookUrl(),msg);
    }

    public static String send(String url,TextMessage msg){
        String result = HttpRequest.post(url)
                .body(RequestBuilder.buildTextMessageReq(msg))
                .execute().body();
        return result;
    }
}
