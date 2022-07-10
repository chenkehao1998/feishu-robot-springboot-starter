package cn.kehao.feishu.robot.msg.item;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class LinkMessageItem implements MessageItem{
    private String link;
    private String text;

    @Override
    public JSONObject buildJsonObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tag","a");
        jsonObject.put("href",link);
        jsonObject.put("text",text);
        return jsonObject;
    }
}
