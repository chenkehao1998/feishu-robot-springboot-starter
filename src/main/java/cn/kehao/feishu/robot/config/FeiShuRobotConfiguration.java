package cn.kehao.feishu.robot.config;

import cn.kehao.feishu.robot.pojo.FeiShuRobotProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ConditionalOnProperty(prefix = "kehao.feishu.robot",name = "webhookUrl")
@EnableAspectJAutoProxy
@EnableConfigurationProperties({FeiShuRobotProperties.class})
@ComponentScan(basePackages = "cn.kehao.feishu.robot")
public class FeiShuRobotConfiguration {
}
