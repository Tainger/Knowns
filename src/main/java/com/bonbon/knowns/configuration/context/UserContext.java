package com.bonbon.knowns.configuration.context;

import com.bonbon.knowns.model.entity.KnownsUser;

/**
 * @author jiazhiyuan
 * @date 2023/8/12 9:05 PM
 */
public class UserContext {


    public static ThreadLocal<KnownsUser> threadLocal = new ThreadLocal<>();



    public static KnownsUser getUser() {
        return threadLocal.get();
    }


    public static void put(KnownsUser knownsUser) {
         threadLocal.set(knownsUser);
    }


    public static void remove() {
        threadLocal.remove();
    }
}



    
