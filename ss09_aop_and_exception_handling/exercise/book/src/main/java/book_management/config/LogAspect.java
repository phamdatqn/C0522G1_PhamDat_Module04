package book_management.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class LogAspect {

    @Pointcut("execution(* book_management.controller.BookController.update*(..))")
    public void callUpdate() {
    }

    @AfterReturning("callUpdate()")
    public void afterThrowingCallUpdate(JoinPoint joinPoint) {
        System.out.println("End method name: " + joinPoint.getSignature().getName() + " Time:" + LocalDateTime.now());
    }

    @Pointcut("within(book_management.controller.*)")
    public void callAllMethod() {
    }

    int count = 0;

    @AfterReturning("callAllMethod()")
    public void afterThrowingAllMethod(JoinPoint joinPoint) {
        count++;
        System.out.println("End method name: " + joinPoint.getSignature().getName() + " Time:" + LocalDateTime.now());
        System.out.println("Số người thao tác với thư viện: " + count);
    }


}
