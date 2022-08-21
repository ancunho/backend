package online.buza.blog.controller.common;

import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import online.buza.blog.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Slf4j
@RestController
@RequestMapping(value = "/common")
public class CommonController {

    @Autowired
    private CommonService commonService;

    @Autowired
    public HttpServletRequest request;

    @Autowired
    public HttpServletResponse response;

    public void putPrintOut(Object obj) {
        try {
            response.setCharacterEncoding("UTF-8");
            PrintWriter pw = response.getWriter();
            pw.print(new GsonBuilder().serializeNulls().create().toJson(obj));
            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void putPrintOut(String msg) {
        try {
            response.setCharacterEncoding("UTF-8");
            PrintWriter pw = response.getWriter();
            pw.print(new GsonBuilder().serializeNulls().create().toJson(msg));
            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
