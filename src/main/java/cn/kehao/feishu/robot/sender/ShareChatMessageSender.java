package cn.kehao.feishu.robot.sender;

import cn.hutool.http.HttpRequest;
import cn.kehao.feishu.robot.msg.ShareChatMessage;
import cn.kehao.feishu.robot.msg.TextMessage;
import cn.kehao.feishu.robot.pojo.FeiShuRobotProperties;
import cn.kehao.feishu.robot.req.RequestBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 群名片
 */
@Component
public class ShareChatMessageSender {

    @Autowired
    private FeiShuRobotProperties feiShuRobotProperties;

    public static String send(String url, ShareChatMessage msg) {
        String result = HttpRequest.post(url)
                .body(RequestBuilder.buildShareChatMessageReq(msg))
                .execute().body();
        return result;
    }


    public String send(ShareChatMessage msg) {
        return ShareChatMessageSender.send(feiShuRobotProperties.getWebhookUrl(),msg);
    }
}
