package cn.kehao.feishu.robot.msg;

import cn.kehao.feishu.robot.msg.item.MessageItem;
import cn.kehao.feishu.robot.msg.item.TextMessageItem;
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

    private PostMessage(String title){
        this.title = title;
    }

    public static PostMessage newInstance(String title){
        return new PostMessage(title);
    }

    public PostMessage line(String line){
        TextMessageItem textMessageItem = new TextMessageItem(line);
        line(textMessageItem);
        return this;
    }

    public PostMessage line(MessageItem messageItem){
        List<MessageItem> list = new ArrayList<>();
        list.add(messageItem);
        this.msg.add(list);
        return this;
    }

    public PostMessage line(List<MessageItem> messageItemList){
        //传入new ArrayList<>(messageItemList) 是为了做安全保护，以免传入的是不可变的list导致异常
        this.msg.add(new ArrayList<>(messageItemList));
        return this;
    }

    public PostMessage appendMessage(String str){
        appendMessage(new TextMessageItem(str));
        return this;
    }

    public PostMessage appendMessage(MessageItem messageItem){
        this.msg.get(this.msg.size()-1).add(messageItem);
        return this;
    }

    public PostMessage appendMessages(List<MessageItem> messageItemList){
        this.msg.get(this.msg.size()-1).addAll(messageItemList);
        return this;
    }

    public PostMessage newLine(){
        this.msg.add(new ArrayList<>());
        return this;
    }


}
