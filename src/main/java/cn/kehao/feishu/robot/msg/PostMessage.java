package cn.kehao.feishu.robot.msg;

import cn.kehao.feishu.robot.msg.item.MessageItem;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PostMessage {
    private String title;
    private List<List<MessageItem>> msg;
}
