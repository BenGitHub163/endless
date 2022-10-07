package team.seven.endless.util;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * TODO
 *
 * @author ben
 * @version 1.0
 * @date 2022/10/6 10:33
 */
public class IpAddressUtil {

    public static String getIpAddress(HttpServletRequest request) {

        String sourceIp = null;

        String ipAddresses = request.getHeader("x-forwarded-for");

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            ipAddresses = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            ipAddresses = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            ipAddresses = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            ipAddresses = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            ipAddresses = request.getRemoteAddr();
        }
        if (!StringUtils.hasLength(ipAddresses)) {
            sourceIp = ipAddresses.split(",")[0];
        }

        return sourceIp;
    }

}
