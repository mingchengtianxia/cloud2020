package concert;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
@Aspect
public class Audience {
    @Pointcut("execution(* concert.Performance.perform(..))")
    public void performance() {
    }
    @Before("performance()")
    public void silenceCellphone() {
        System.out.println("silence cell phone");
    }
    //    @Before("execution(** concert.Performance.perform(..))")
    @Before("performance()")   //上面定义了Pointcut  可以使用performance()代替上面的
    public void takeSeat() {
        System.out.println("Taking seats");
    }
    @After("execution(** concert.Performance.perform(..))")
    public void applause() {
        System.out.println("applause");
    }
    @AfterThrowing("execution(** concert.Performance.perform(..))")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }

    @Around("performance()")
    public void around(ProceedingJoinPoint joinPoint){
        System.out.println("player sit");
        System.out.println("player cell phone");
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            System.out.println("Demanding a refund");
        }
        System.out.println("CLAP CLAP");
    }

    public void test(){
        System.out.println("test");
    }
}
