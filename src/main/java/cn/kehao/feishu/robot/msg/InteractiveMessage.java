package cn.kehao.feishu.robot.msg;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class InteractiveMessage {

    @Builder
    public static class Config{

        @JSONField(name = "enable_forward")
        private Boolean enableForward;

        @JSONField(name = "update_multi")
        private Boolean updateMulti;
    }

    @Builder
    public static class Header{
        private String title;
        private String color;
    }
}
