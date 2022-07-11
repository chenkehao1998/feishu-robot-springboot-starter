package cn.kehao.feishu.robot.req;

import cn.kehao.feishu.robot.enums.MessageTypeEnum;
import cn.kehao.feishu.robot.msg.ImageMessage;
import cn.kehao.feishu.robot.msg.PostMessage;
import cn.kehao.feishu.robot.msg.ShareChatMessage;
import cn.kehao.feishu.robot.msg.TextMessage;
import com.alibaba.fastjson.JSONObject;


public class RequestBuilder {
    public static String buildTextMessageReq(TextMessage msg){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg_type", MessageTypeEnum.TEXT.getCode());
        JSONObject content = new JSONObject();
        jsonObject.put("content",content);
        content.put("text",msg.getText());
        return jsonObject.toJSONString();
    }

    public static String buildPostMessageReq(PostMessage msg){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg_type", MessageTypeEnum.POST.getCode());
        JSONObject content = new JSONObject();
        jsonObject.put("content",content);
        JSONObject post = new JSONObject();
        content.put("post",post);
        post.put("zh_cn",msg.buildJsonObject());
        return jsonObject.toJSONString();
    }

    public static String buildImageMessageReq(ImageMessage msg){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg_type", MessageTypeEnum.IMAGE.getCode());
        JSONObject content = new JSONObject();
        jsonObject.put("content",msg.buildJsonObject());
        return jsonObject.toJSONString();
    }


    public static String buildShareChatMessageReq(ShareChatMessage msg){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg_type", MessageTypeEnum.SHARE_CHAT.getCode());
        JSONObject content = new JSONObject();
        jsonObject.put("content",msg.buildJsonObject());
        return jsonObject.toJSONString();
    }
}
