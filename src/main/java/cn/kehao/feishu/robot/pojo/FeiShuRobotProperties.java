package cn.kehao.feishu.robot.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "kehao.feishu.robot")
public class FeiShuRobotProperties {
    private String webhookUrl;
}
