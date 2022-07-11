package com.atguigu.nginx.nginxdome.com.atguigu;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@RestController
public class MainController {

    @GetMapping()
    public String main (HttpServletRequest request) {
        StringBuffer sb = new StringBuffer();

        Enumeration<String> headerNames = request.getHeaderNames();

        while(headerNames.hasMoreElements()) {
            String hname = headerNames.nextElement();
            sb.append(hname + ":" + request.getHeader(hname) + "<br>");
        }

        String remoteHost = request.getRemoteHost();
        Integer remotePort = request.getRemotePort();
        String remoteAddr  = request.getRemoteAddr();

        sb.append("remoteHost: " + remoteHost + "<br>");
        sb.append("remotePort: " + remotePort + "<br>");
        sb.append("remoteAddr: " + remoteAddr + "<br>");

        String ipAddress = request.getHeader("x-forwarded-fon");
        sb.append("ipAddress: " + ipAddress);
        return sb.toString();
    }

}
