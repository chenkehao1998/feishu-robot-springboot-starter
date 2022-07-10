# 简介
自用的飞书机器人spring-starter

# 进度
刚刚开始写，只实现了基本文本和富文本的消息发送

# 使用方法
配置webhookUrl地址
```yaml
kehao:
  feishu:
    robot:
      webhookUrl: https://open.feishu.cn/open-apis/bot/v2/hook/xxxxxxxxxxxx
```
然后使用
```java
/**
 * 普通文本的推送
 */
@Autowired
private TextMessageSender textMessageSender;

void textMessageTest() {
    TextMessage textMessage = new TextMessage("123");
    log.info("{}",textMessageSender.send(textMessage));
}

/**
 * 富文本消息的推送
 */
@Autowired
private PostMessageSender postMessageSender;

void postMessageTest() {
    String result = postMessageSender.send(PostMessageBuilder.getBuilder()
    .title("标题")
    .line("第一行")
    .line("第2行")
    .line("xxxxxxxxxx")
    .appendMessage("111")
    .build());
    log.info("{}",result);
}
```

# 飞书开发者文档
[消息体格式](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/im-v1/message/create_json#392c2afd)