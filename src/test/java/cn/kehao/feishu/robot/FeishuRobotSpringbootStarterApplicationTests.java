package cn.kehao.feishu.robot;

import cn.kehao.feishu.robot.config.FeiShuRobotConfiguration;
import cn.kehao.feishu.robot.msg.PostMessageBuilder;
import cn.kehao.feishu.robot.msg.TextMessage;

import cn.kehao.feishu.robot.sender.PostMessageSender;
import cn.kehao.feishu.robot.sender.TextMessageSender;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest(classes = FeiShuRobotConfiguration.class)
class FeishuRobotSpringbootStarterApplicationTests {

    @Autowired
    private TextMessageSender textMessageSender;

    @Autowired
    private PostMessageSender postMessageSender;

    @Test
    void textMessageTest() {
        TextMessage textMessage = new TextMessage("123");
        log.info("{}",textMessageSender.send(textMessage));
    }

    @Test
    void postMessageTest() {
        String result = postMessageSender.send(PostMessageBuilder.getBuilder()
                .title("标题")
                .line("第一行")
                .line("第2行")
                .line("xxxxxxxxxx").appendMessage("111")
                .build());
        log.info("{}",result);
    }

}
