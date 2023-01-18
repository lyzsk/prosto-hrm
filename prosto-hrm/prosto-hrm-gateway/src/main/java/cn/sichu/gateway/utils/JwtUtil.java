package cn.sichu.gateway.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @author sichu
 * @date 2023/01/18
 **/
@Component
public class JwtUtil {

    /**
     * 签名用的密钥
     */
    private static final String SIGNING_KEY = "prosto-hrm-signing-key-lyzsk";

    /**
     * 用户登录成功后生成JWT token
     *
     * @param exp    过期时间
     * @param claims 保存在payload中的内容
     * @return jwt token
     */
    public String generateToken(Date exp, Map<String, Object> claims) {
        // 指定签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        Date currentTime = new Date();
        // 设置jwt的body
        JwtBuilder builder = Jwts.builder()
            // payload有效载荷中的内容
            .setClaims(claims)
            // 签发时间
            .setIssuedAt(currentTime)
            // 过期时间
            .setExpiration(exp)
            // 签名算法和密钥
            .signWith(signatureAlgorithm, SIGNING_KEY);
        return builder.compact();
    }

    /**
     * 解析token, 获取到payload中的内容, 包括验证签名, 判断过期
     *
     * @param token jwt token
     * @return claims payload
     */
    public Claims parseToken(String token) {
        Claims claims = Jwts.parser()
            // 设置签名的密钥
            .setSigningKey(SIGNING_KEY)
            // 解析输入的token
            .parseClaimsJws(token).getBody();
        return claims;
    }
}
