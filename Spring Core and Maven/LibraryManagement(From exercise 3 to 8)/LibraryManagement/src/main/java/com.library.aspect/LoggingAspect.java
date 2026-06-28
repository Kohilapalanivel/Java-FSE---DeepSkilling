/*package com.library.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
public class LoggingAspect 
{
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable 
    {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("Method Executed : " + joinPoint.getSignature().getName());
        System.out.println("Execution Time : " + (end - start) + " ms");
        return result;
    }
}
*/
package com.library.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
public class LoggingAspect 
{
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable 
    {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("Method Executed : " + joinPoint.getSignature().getName());
        System.out.println("Execution Time : " + (end - start) + " ms");
        return result;
    }
	 public void beforeMethod() 
	   {
	        System.out.println("Before Method Execution: ");
	    }
	    public void afterMethod() 
	    {
	        System.out.println("After Method Execution:  ");
	    }
}
