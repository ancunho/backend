package online.buza.blog.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.GsonBuilder;
import online.buza.blog.annotation.AdminUserLogin;
import online.buza.blog.annotation.PassLogin;
import online.buza.blog.annotation.WechatPassLogin;
import online.buza.blog.common.BaseResponse;
import online.buza.blog.common.Const;
import online.buza.blog.common.ResponseCode;
import online.buza.blog.dto.CustomerDto;
import online.buza.blog.dto.SysUserDto;
import online.buza.blog.entity.TbAccessHist;
import online.buza.blog.service.CommonService;
import online.buza.blog.util.Box;
import online.buza.blog.util.HttpUtility;
import online.buza.blog.util.StringUtils;
import online.buza.blog.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

@Component
public class BuzaInterceptor implements HandlerInterceptor {

    @Autowired
    private CommonService commonService;

    /**
     * 在DispatcherServlet处理方法之前执行，一般用来做一些准备工作：比如日志，权限检查
     * 如果返回false 表示被拦截，将不会执行处理方法
     * 返回true继续执行处理方法
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1. 如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        if (method.isAnnotationPresent(PassLogin.class)) {
            PassLogin passLogin = method.getAnnotation(PassLogin.class);
            if (passLogin.required()) {
                return true;
            }
        }

        if (method.isAnnotationPresent(WechatPassLogin.class)) {
            WechatPassLogin wechatPassLogin = method.getAnnotation(WechatPassLogin.class);
            if (wechatPassLogin.required()) {
                return true;
            }
        }

        if (method.isAnnotationPresent(AdminUserLogin.class)) {
            AdminUserLogin adminUserLogin = method.getAnnotation(AdminUserLogin.class);
            if (adminUserLogin.required()) {
                HttpSession session = request.getSession(true);
                SysUserDto sysUserDto = (SysUserDto) session.getAttribute("LOGINED_USER");
                String basePath = request.getScheme() + "://" + request.getServerName() + ":"  + request.getServerPort()+request.getContextPath();
                if (sysUserDto == null) {
                    PrintWriter pw = null;
                    try {
                        pw = response.getWriter();
                        response.setCharacterEncoding("UTF-8");
                        response.setContentType("text/html; charset=UTF-8");
//                        StringBuilder builder = new StringBuilder();
//                        builder.append("<html>");
//                        builder.append("<script type='text/javascript'>");
//                        builder.append("window.location.href=" + "'" + basePath + "/admin/login.ahn';");
//                        builder.append("</script>");
//                        builder.append("</html>");
//                        pw.write(builder.toString());

                        BaseResponse serverResponse = BaseResponse.valueOfFailureCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
                        response.setContentType("application/json; charset=UTF-8");
                        pw.write(JSONObject.toJSONString(serverResponse));

                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        pw.flush();
                        pw.close();
                    }

                } else {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 在处理方法执行之后执行，在DispatcherServlet处理方法之后执行，一般用来做一些清理工作
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        Box box = HttpUtility.getBox(request);
//
//        HttpSession session = request.getSession(true);
//        TbAccessHist tbAccessHist = new TbAccessHist();
//
//        try {
//            if (request.getRequestURI().contains("admin")) {
//                SysUserDto sysUserDto = (SysUserDto) session.getAttribute("LOGINED_USER");
//                if (sysUserDto == null) {
//                    tbAccessHist.setCuser("admin_stranger");
//                    tbAccessHist.setCustomerSeq(null);
//                } else {
//                    tbAccessHist.setCuser(Util.nullreplace(sysUserDto.getUsername(), ""));
//                    tbAccessHist.setCustomerSeq(sysUserDto.getUserSeq());
//                }
//                tbAccessHist.setMemo("backend");
//
//            } else {
//                CustomerDto customerDto = (CustomerDto) session.getAttribute("CUSTOMER_USER");
//                if (customerDto == null || customerDto.getUserSeq() == null || "".equals(Util.nullempty(customerDto.getUserSeq()))) {
//                    tbAccessHist.setCuser("stranger");
//                    tbAccessHist.setCustomerSeq(null);
//                } else {
//                    tbAccessHist.setCuser(customerDto.getUsername());
//                    tbAccessHist.setCustomerSeq(customerDto.getUserSeq());
//                }
//                tbAccessHist.setMemo("portal");
//            }
//
//            tbAccessHist.setIpAddr(Util.getRemortIP(request));
//            tbAccessHist.setUserAgent(request.getHeader("User-Agent"));
//            tbAccessHist.setSessionId(request.getSession(true).getId());
//            tbAccessHist.setReferer(request.getHeader("Referer"));
//            tbAccessHist.setRequestUrl(request.getRequestURL().toString());
//            tbAccessHist.setRequestUri(request.getRequestURI());
//
//            StringBuffer sbHeader = new StringBuffer();
//            sbHeader.append("RemoteAddr=" + request.getRemoteAddr()).append("&");
//
//            Enumeration eHeader = request.getHeaderNames();
//            while (eHeader.hasMoreElements()) {
//                String hName = (String) eHeader.nextElement();
//                String hValue = request.getHeader(hName);
//                sbHeader.append(hName + "=" + hValue).append("&");
//            }
//            tbAccessHist.setHeaderInfo(sbHeader.toString());
//            tbAccessHist.setParameters(box.toString());
//            tbAccessHist.setUseYn("1");
//
////            commonService.insertTbAccessHist(tbAccessHist);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 在结果返回给客户端之前执行，一般用来释放资源
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

}
