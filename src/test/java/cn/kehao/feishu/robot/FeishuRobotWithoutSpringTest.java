package cn.kehao.feishu.robot;

import cn.kehao.feishu.robot.msg.ImageMessage;
import cn.kehao.feishu.robot.msg.PostMessage;
import cn.kehao.feishu.robot.msg.ShareChatMessage;
import cn.kehao.feishu.robot.msg.TextMessage;
import cn.kehao.feishu.robot.sender.ImageMessageSender;
import cn.kehao.feishu.robot.sender.PostMessageSender;
import cn.kehao.feishu.robot.sender.ShareChatMessageSender;
import cn.kehao.feishu.robot.sender.TextMessageSender;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FeishuRobotWithoutSpringTest {
    private String url = "https://open.feishu.cn/open-apis/bot/v2/hook/xxxx";

    @Test
    public void textMessageTest(){
        TextMessage textMessage = new TextMessage("456");
        String result = TextMessageSender.send(url, textMessage);
        log.info("{}",result);
    }

    @Test
    void postMessageTest() {
        String result = PostMessageSender.send(url,
                PostMessage.newInstance("标题")
                        .line("第一行")
                        .line("第2行")
                        .line("xxxxxxxxxx").appendMessage("111")
        );
        log.info("{}",result);
    }

    @Test
    void imgMessgaeTest(){
        ImageMessage imageMessage = new ImageMessage("img_ecffc3b9-8f14-400f-a014-05eca1a4310g");
        String result = ImageMessageSender.send(url,imageMessage);
        log.info("{}",result);
    }

    @Test
    void shareChatMessageTest(){
        ShareChatMessage shareChatMessage = new ShareChatMessage("oc_f5b1a7eb27ae2c7b6adc2a74faf339ff");
        String result = ShareChatMessageSender.send(url,shareChatMessage);
        log.info("{}",result);
    }
}
