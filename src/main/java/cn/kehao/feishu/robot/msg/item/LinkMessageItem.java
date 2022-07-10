package cn.kehao.feishu.robot.msg.item;

import lombok.Data;

@Data
public class LinkMessageItem extends MessageItem{
    private String link;
    private String text;
}
