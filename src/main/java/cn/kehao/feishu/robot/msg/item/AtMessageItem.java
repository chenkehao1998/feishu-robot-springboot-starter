package cn.kehao.feishu.robot.msg.item;

import com.alibaba.fastjson.JSONObject;

public class AtMessageItem implements MessageItem{
    private String userId;
    private String userName;

    @Override
    public JSONObject buildJsonObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tag","at");
        jsonObject.put("user_id",userId);
        jsonObject.put("user_name",userName);
        return jsonObject;
    }
}
