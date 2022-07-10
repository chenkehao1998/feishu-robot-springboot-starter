# 简介
自用的飞书机器人spring-starter

# 进度
刚刚开始写，只实现了基本文本的消息发送

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
@Autowired
private TextMessageSender textMessageSender;

void textMessageTest() {
    TextMessage textMessage = new TextMessage("123");
    log.info("{}",textMessageSender.send(textMessage));
}
```