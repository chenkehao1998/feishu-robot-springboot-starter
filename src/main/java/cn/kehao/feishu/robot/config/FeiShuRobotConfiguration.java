package cn.kehao.feishu.robot.config;

import cn.kehao.feishu.robot.pojo.FeiShuRobotProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//@ConditionalOnMissingBean(FeiShuRobotConfiguration.class)
@EnableAspectJAutoProxy
@EnableConfigurationProperties({FeiShuRobotProperties.class})
@ComponentScan(basePackages = "cn.kehao.feishu.robot")
public class FeiShuRobotConfiguration {
}
