package com.bonbon.knowns.utils;

import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author jiazhiyuan
 * @date 2023/8/6 9:12 PM
 */

@Slf4j
public class EnvUtils {


    /**
     * 获取主机名称
     * @return
     */
    public static String getHostName() {

        try {
            String hostName = InetAddress.getLocalHost().getHostName();
            return hostName;
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }


    public static String getHostAddress() {

        try {
            String hostName = InetAddress.getLocalHost().getHostAddress();
            return hostName;
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}



    
