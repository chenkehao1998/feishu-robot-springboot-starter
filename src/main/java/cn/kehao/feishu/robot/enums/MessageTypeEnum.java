package cn.kehao.feishu.robot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageTypeEnum {

    TEXT("text","文本"),
    POST("post","富文本"),
    IMAGE("image","图片"),
    SHARE_CHAT("share_chat","分享群名片"),
    INTERACTIVE("interactive","消息卡片")
    ;

    private final String code;
    private final String description;
}
