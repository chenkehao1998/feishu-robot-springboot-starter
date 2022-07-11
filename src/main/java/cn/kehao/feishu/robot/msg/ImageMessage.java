package cn.kehao.feishu.robot.msg;


import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ImageMessage {
    private String imageKey;

    public JSONObject buildJsonObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("image_key",imageKey);
        return jsonObject;
    }
}
