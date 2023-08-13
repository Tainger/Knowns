package com.bonbon.knowns.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.bonbon.knowns.model.entity.KnownsUser;
import org.apache.commons.lang3.StringUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * @author jiazhiyuan
 * @date 2023/8/12 7:42 PM
 */
public class TokenUtil {

    /**
     * secret
     */
    public static final String SECRET = "areyoucrazy?pojie?bukenengde?";

    /**
     * 过期时间
     */
    public static final int EXPIRE = 30;

    public static String getToken(KnownsUser knownsUser){
        Calendar nowTime = Calendar.getInstance();
        //过期时间
        nowTime.add(Calendar.SECOND, EXPIRE);
        Date expireDate = nowTime.getTime();
        return JWT.create()
                //这是在设置第二部分信息，不要设置密码之类的，因为这些信息可以通过浏览器获取
                //用户id
                .withClaim("id", knownsUser.getId())
                //用户名
                .withClaim("username",knownsUser.getUsername())
                .withClaim("phone",knownsUser.getPhone())
                .withClaim("mail",knownsUser.getMail())
                //创建token的时间
                .withIssuedAt(new Date())//签名时间
                //设置token的过期时间
                .withExpiresAt(expireDate)//过期时间
                //设置第一部分
                .sign(Algorithm.HMAC256(SECRET));
    }

    /**
     * 验证token合法性 成功返回token
     */
    public static DecodedJWT verify(String token)  {
        if(StringUtils.isBlank(token)){
            throw new RuntimeException("token不能为空");
        }
        JWTVerifier build = JWT.require(Algorithm.HMAC256(SECRET)).build();
        return build.verify(token);
    }
    public static void main(String[] args) {
    }
}



    
