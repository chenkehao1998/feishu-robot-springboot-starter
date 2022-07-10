package cn.kehao.feishu.robot.msg.item;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TextMessageItem implements MessageItem {
    private String text;

    @Override
    public JSONObject buildJsonObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tag","text");
        jsonObject.put("text",text);
        return jsonObject;
    }
}
