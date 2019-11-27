package cn.qianfg.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
public class LoginFilter extends ZuulFilter {
    /**
     * 过滤器类型
     * pre：可以在请求被路由之前调用。
     * routing：在路由请求时候被调用。
     * post：在routing和error过滤器之后被调用。
     * error：处理请求时发生错误时被调用。
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行的顺序
     * 通过int值来定义过滤器的执行顺序，数值越小优先级越高。
     */
    @Override
    public int filterOrder() {
        return 2;
    }

    /**
     * 判断该请求需不需要拦截
     * RequestContext:是所有服务共享的一个对象
     */
    @Override
    public boolean shouldFilter() {
        RequestContext rc = RequestContext.getCurrentContext();
        HttpServletRequest request = rc.getRequest();
        String path = request.getServletPath();
        System.out.println("当前拦截的请求为:" + path);
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        System.out.println("从session获取的用户名为:" + userName);
        //短路判断
        if ("/gateway/good/login".equals(path) || userName != null) {
            return false;
        }
        return true;
    }

    /**
     * 拦截到的请求作何处理
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext rc = RequestContext.getCurrentContext();
        //不进行路由,这个请求最终不会被zuul转发到后端服务器
        rc.setSendZuulResponse(false);
        //请求状态码
        rc.setResponseStatusCode(401);
        return null;
    }
}
