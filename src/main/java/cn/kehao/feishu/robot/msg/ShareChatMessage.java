package cn.kehao.feishu.robot.msg;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShareChatMessage {
    private String shareChatId;

    public JSONObject buildJsonObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("share_chat_id",shareChatId);
        return jsonObject;
    }
}
