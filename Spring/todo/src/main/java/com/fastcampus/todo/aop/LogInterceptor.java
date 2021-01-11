package com.fastcampus.todo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
// @CustomLog //컴파일 에러를 내기 위한 설정 ( 컴파일에러 > 테스트페일 > 부트런실패런타임에러 > 런타임에러 > 논리적인 에러)
public class LogInterceptor {
    // @Around("execution(* com.fastcampus..*.UserService.*(..))") // -> 메서드 전체 + 파라미터는 아무거나
    // 일반적으론 스트링이 복잡해서 어노테이션을 사용하게 됨
    @Around("@annotation(CustomLog)")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(); // -> 이런식으로 많이 사용 시간이나 로그를 찍을 때 사용
        System.out.println(">>> Log Interceptor Start! ");

        // pjp.getArgs() -> 메서드에 전달되는 파라미터 값을 다 받을 수 있음
        Object retVal = pjp.proceed();
        // retVal == retrunValue -> 옛날 관습 표현

        System.out.println(">>> Log Interceptor End! ");
        stopWatch.stop();

        System.out.println(">>> " + stopWatch.prettyPrint());
        return retVal;
    }
}
