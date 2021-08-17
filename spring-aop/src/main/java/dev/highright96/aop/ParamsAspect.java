package dev.highright96.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect // AOP 로 동작
@Component // 스프링빈으로 관리
public class ParamsAspect {

    @Pointcut("execution(* dev.highright96.aop..*.*(..))") // aop 패키지 하위 모두 적용
    private void cut() {

    }

    @Before("cut()") // cut 메서드가 실행되기 전에 실행!
    public void before(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("method : " + methodSignature.getMethod().getName());

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("type : " + arg.getClass().getSimpleName());
            System.out.println("value : " + arg);
        }
    }

    @AfterReturning(value = "cut()", returning = "returnObj") // cut 메서드가 return 된 후
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        System.out.println("return : " + returnObj);
    }
    
    /*
    @After("cut()") // cut 메서드가 끝난 후
    public void after() {

    }
    */
}
