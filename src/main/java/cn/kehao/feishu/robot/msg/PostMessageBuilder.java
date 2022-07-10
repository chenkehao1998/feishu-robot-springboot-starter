package cn.kehao.feishu.robot.msg;

import cn.kehao.feishu.robot.msg.item.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostMessageBuilder {

    private PostMessage postMessage;
    private PostMessageBuilder(){
        postMessage = new PostMessage();
    }

    public static PostMessageBuilder getBuilder(){
        return new PostMessageBuilder();
    }

    public PostMessageBuilder title(String title){
        postMessage.setTitle(title);
        return this;
    }

    public PostMessageBuilder line(String line){
        TextMessageItem textMessageItem = new TextMessageItem(line);
        return line(textMessageItem);
    }

    public PostMessageBuilder line(MessageItem messageItem){
        List<MessageItem> list = new ArrayList<>();
        list.add(messageItem);
        postMessage.getMsg().add(list);
        return this;
    }

    public PostMessageBuilder line(List<MessageItem> messageItemList){
        //传入new ArrayList<>(messageItemList) 是为了做安全保护，以免传入的是不可变的list导致异常
        postMessage.getMsg().add(new ArrayList<>(messageItemList));
        return this;
    }

    public PostMessageBuilder appendMessage(String str){
       return appendMessage(new TextMessageItem(str));
    }

    public PostMessageBuilder appendMessage(MessageItem messageItem){
        List<List<MessageItem>> msg = postMessage.getMsg();
        msg.get(msg.size()-1).add(messageItem);
        return this;
    }

    public PostMessageBuilder appendMessages(List<MessageItem> messageItemList){
        List<List<MessageItem>> msg = postMessage.getMsg();
        msg.get(msg.size()-1).addAll(messageItemList);
        return this;
    }


    public PostMessageBuilder newLine(){
        postMessage.getMsg().add(new ArrayList<>());
        return this;
    }

    public PostMessage build(){
        return postMessage;
    }

}
