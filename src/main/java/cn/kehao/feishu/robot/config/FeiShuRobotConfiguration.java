package cn.kehao.feishu.robot.config;

import cn.kehao.feishu.robot.pojo.FeiShuRobotProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ConditionalOnExpression("'${kehao.feishu.robot.webhook-url}'.startsWith('http')")
@EnableAspectJAutoProxy
@EnableConfigurationProperties({FeiShuRobotProperties.class})
@ComponentScan(basePackages = "cn.kehao.feishu.robot")
@Configuration
public class FeiShuRobotConfiguration {
}
