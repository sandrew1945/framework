package com.sandrew.bootsec.core.util.http;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class HttpUtils {

    public static String getRemoteIP(HttpServletRequest request) {
        try {
            String ipAddress;
            //ipAddress = request.getRemoteAddr();
            ipAddress = request.getHeader("x-forwarded-for");
            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if(ipAddress.equals("127.0.0.1")){
                    //根据网卡取本机配置的IP
                    InetAddress inet=null;
                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                    ipAddress= inet.getHostAddress();
                }

            }

            //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15
                if(ipAddress.indexOf(",")>0){
                    ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));
                }
            }
            return ipAddress;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static String getUserAgent(HttpServletRequest request) {
        return request.getHeader("user-agent");
    }

    public static void printHeaders(HttpServletRequest request){
        //2.获得所有头的名称
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {//判断是否还有下一个元素
            String nextElement = headerNames.nextElement();//获取headerNames集合中的请求头
            String header2 = request.getHeader(nextElement);//通过请求头得到请求内容
            System.out.println(nextElement + ":" + header2);
        }
    }
}
