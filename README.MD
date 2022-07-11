## 简介
自用的飞书机器人spring-starter，目前只支持群机器人，因为我用飞书个人版

## 进度
只实现了基本文本、富文本、图片、群名片的消息发送

消息卡片有空再实现

最新进度在dev分支

## 使用方法
### 在非spring项目中使用
```java
/**
 * 普通文本的推送
 */
public void textMessageTest(){
    TextMessage textMessage = new TextMessage("456");
    String result = TextMessageSender.send(url, textMessage);
    log.info("{}",result);
}
```

```java
/**
 * 富文本消息的推送
 */
void postMessageTest() {
    String result = PostMessageSender.send(url,
            PostMessage.newInstance("标题")
                    .line("第一行")
                    .line("第2行")
                    .line("xxxxxxxxxx").appendMessage("111")
    );
    log.info("{}",result);
}
```
```java
/**
 * 图片消息的发送（这个需要申请应用机器人，否则没法上传图片，传入的是图片key）
 */
void imgMessgaeTest(){
    ImageMessage imageMessage = new ImageMessage("img_ecffc3b9-8f14-400f-a014-05eca1a4310g");
    String result = ImageMessageSender.send(url,imageMessage);
    log.info("{}",result);
}
```
```java
/**
 * 群名片的发送
 */
void shareChatMessageTest(){
    ShareChatMessage shareChatMessage = new ShareChatMessage("oc_f5b1a7eb27ae2c7b6adc2a74faf339ff");
    String result = ShareChatMessageSender.send(url,shareChatMessage);
    log.info("{}",result);
}
```
### 在springboot中使用
配置webhookUrl地址
```yaml
kehao:
  feishu:
    robot:
      webhook-url: https://open.feishu.cn/open-apis/bot/v2/hook/xxxxxxxxxxxx
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
```
```java
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
```java
/**
 * 图片消息的发送（这个需要申请应用机器人，否则没法上传图片，传入的是图片key）
 */
@Autowired
private ImageMessageSender imageMessageSender;

void imgMessgaeTest(){
    ImageMessage imageMessage = new ImageMessage("img_ecffc3b9-8f14-400f-a014-05eca1a4310g");
    String result = imageMessageSender.send(imageMessage);
    log.info("{}",result);
}
```
```java
/**
 * 群名片的发送
 */
@Autowired
private ShareChatMessageSender shareChatMessageSender;

void shareChatMessageTest(){
    ShareChatMessage shareChatMessage = new ShareChatMessage("oc_f5b1a7eb27ae2c7b6adc2a74faf339ff");
    String result = shareChatMessageSender.send(shareChatMessage);
    log.info("{}",result);
}
```


## 飞书开发者文档
[消息体格式](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/im-v1/message/create_json#392c2afd)