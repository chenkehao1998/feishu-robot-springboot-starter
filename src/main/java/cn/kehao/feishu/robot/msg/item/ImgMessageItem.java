package cn.kehao.feishu.robot.msg.item;

import com.alibaba.fastjson.JSONObject;

public class ImgMessageItem implements MessageItem{
    private String imgKey;
    private Integer width;
    private Integer height;

    @Override
    public JSONObject buildJsonObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tag","img");
        jsonObject.put("image_key",imgKey);
        jsonObject.put("width",width);
        jsonObject.put("height",height);
        return jsonObject;
    }
}
