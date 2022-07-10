package cn.kehao.feishu.robot.aop;


import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class FeiShuRobotAspect {
    @Around(value = "execution(* cn.kehao.feishu.robot.sender.*.send(..))")
    public Object logForSend(ProceedingJoinPoint proceedingJoinPoint){
        Object proceed = null;
        try {
            proceed = proceedingJoinPoint.proceed();
            String result = (String) proceed;
            JSONObject jsonObject = JSONObject.parseObject(result);
            if(!"success".equals(jsonObject.getString("StatusMessage"))){
                log.error("发送消息失败");
            }
        }catch (Throwable e){
            log.error("发送消息失败：{}",e);
        }
        return proceed;
    }
}
