package cn.kehao.feishu.robot.msg;

import cn.kehao.feishu.robot.msg.item.MessageItem;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PostMessage {
    private String title;
    private List<List<MessageItem>> msg = new ArrayList<>();

    public JSONObject buildJsonObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title",title);
        JSONArray jsonArray = new JSONArray();
        jsonObject.put("content",jsonArray);
        msg.forEach(list->{
            JSONArray array = new JSONArray();
            list.forEach(item->{
                array.add(item.buildJsonObject());
            });
            jsonArray.add(array);
        });
        return jsonObject;
    }

}
