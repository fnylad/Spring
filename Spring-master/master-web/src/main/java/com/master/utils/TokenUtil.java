package com.master.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.master.Entity.User;

import java.util.Date;

public class TokenUtil {


    private static  final long EXOURE_TIME = 10*60*60*1000;
    private static  final String TOKEN_SECRET = "txdy";


    /**
     * 签名生成
     * @parame user
     * @return
     */
    public static  String sign(User user){
        String token =null;

        try {
            Date expireAt= new Date(System.currentTimeMillis()+EXOURE_TIME);
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("phone",user.getPhone())
                    .withExpiresAt(expireAt)
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  token;
    }

    /**
     * 签名验证
     * @param token
     * @return
     */

    public static boolean verify(String token){
        try {
           JWTVerifier verifier =JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("athu0").build();
           DecodedJWT jwt = verifier.verify(token);
//            System.out.println("认证通过：");
//            System.out.println("phone: " + jwt.getClaim("phone").asString());
//            System.out.println("过期时间：      " + jwt.getExpiresAt());
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();

            return false;
        }
    }

}


