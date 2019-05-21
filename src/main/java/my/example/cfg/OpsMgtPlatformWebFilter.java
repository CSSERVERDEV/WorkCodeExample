package my.example.cfg;


import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @Author:ZengSong
 * @Description:
 * @Date:Created in 16:17 2018/4/24
 * @Modified By:
 */
@Aspect
@Component
@Order(-5)
public class OpsMgtPlatformWebFilter {
    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    /**
     * 定义一个切入点,第一个 *代表任意修饰符及任意返回值.第二个 *任意包名 第三个 *代表任意方法 第四个 *定义在web包或者子包 第五个 *任意方法 匹配任意数量的参数
     */
    @Pointcut("execution(public * com.sengled.cloud.ops.*.controller..*.*(..))")
    public void webLog(){}

    @Before("webLog()")

    /**
     * 前置
     */
    public void doBefore(JoinPoint joinPoint){
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request =attributes.getRequest();
        HttpSession session = request.getSession();
        SecurityContextImpl securityContextImpl = (SecurityContextImpl)session.getAttribute("SPRING_SECURITY_CONTEXT");
        if(securityContextImpl!=null){
            logger.info("session:"+securityContextImpl.getAuthentication().getName());

            WebAuthenticationDetails details = (WebAuthenticationDetails) securityContextImpl
                    .getAuthentication().getDetails();
            // 获得访问地址
            logger.info("RemoteAddress" + details.getRemoteAddress());
            // 获得sessionid
            logger.info("SessionId" + details.getSessionId());

            List<GrantedAuthority> authorities = (List<GrantedAuthority>) securityContextImpl
                    .getAuthentication().getAuthorities();
            for (GrantedAuthority grantedAuthority : authorities) {
                logger.info("Authority:" + grantedAuthority.getAuthority());
            }
        }

        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName()+ "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

        //获取所有参数方法一：
        Enumeration<String> enu=request.getParameterNames();
        while(enu.hasMoreElements()){
            String paraName=(String)enu.nextElement();
            logger.info(paraName+": "+request.getParameter(paraName));
        }
    }


    /**
     * 后置
     * @param joinPoint
     */
    @AfterReturning("webLog()")
    public void doAfterReturning(JoinPoint joinPoint){
    }
}