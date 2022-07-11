package cn.kehao.feishu.robot;

import cn.kehao.feishu.robot.config.FeiShuRobotConfiguration;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest(classes = FeiShuRobotConfiguration.class)
public class FeishuRobotSpringbootStarterTests {

    @Autowired
    private TextMessageSender textMessageSender;

    @Autowired
    private PostMessageSender postMessageSender;

    @Autowired
    private ImageMessageSender imageMessageSender;

    @Autowired
    private ShareChatMessageSender shareChatMessageSender;

    @Test
    void textMessageTest() {
        TextMessage textMessage = new TextMessage("123");
        log.info("{}",textMessageSender.send(textMessage));
    }


    @Test
    void postMessageTest() {
        String result = postMessageSender.send(
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
        String result = imageMessageSender.send(imageMessage);
        log.info("{}",result);
    }

    @Test
    void shareChatMessageTest(){
        ShareChatMessage shareChatMessage = new ShareChatMessage("oc_f5b1a7eb27ae2c7b6adc2a74faf339ff");
        String result = shareChatMessageSender.send(shareChatMessage);
        log.info("{}",result);
    }

}
