package cn.sichu.security.utils;

import cn.sichu.common.exception.GlobalException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT token的格式：header.payload.signature
 * header的格式: {"alg": "HS512","typ": "JWT"}
 * payload的格式: {"sub":"wang","created":1489079981393,"exp":1489684781}
 * signature的生成算法:
 * HMACSHA512(base64UrlEncode(header) + "." +base64UrlEncode(payload),secret)
 *
 * @author sichu
 * @date 2023/01/09
 **/
public class JwtTokenUtil {

    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    /**
     * 根据 token 获取 username
     *
     * @param token jwt token
     * @return username
     */
    public String getUsernameFromToken(String token) {
        String username;
        try {
            final Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (final Exception e) {
            throw new GlobalException(e.getMessage());
        }
        return username;
    }

    /**
     * 根据 token 获取 created
     *
     * @param token jwt token
     * @return created date
     */
    public Date getCreationDateFromToken(String token) {
        Date created;
        try {
            final Claims claims = getClaimsFromToken(token);
            created = new Date((Long)claims.get(CLAIM_KEY_CREATED));
        } catch (final Exception e) {
            throw new GlobalException(e.getMessage());
        }
        return created;
    }

    /**
     * 根据 token 获取 expiration
     *
     * @param token jwt token
     * @return expiration date
     */
    public Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (final Exception e) {
            throw new GlobalException(e.getMessage());
        }
        return expiration;
    }

    /**
     * 根据 userdetails 生成 token
     *
     * @param userDetails userdetails
     * @return token
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>(1);
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    /**
     * 验证 token 是否有效
     *
     * @param token       客户端传入的 token
     * @param userDetails 数据库查到的 userdetails
     * @return true/false
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = getUsernameFromToken(token);
        return username.equals(userDetails.getUsername());
    }

    /**
     * 根据 httpServletRequest 获取 username
     *
     * @param request httpServletRequest
     * @return username
     */
    public String getUsernameFromRequest(HttpServletRequest request) {
        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)) {
            return "";
        }
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return (String)claims.get("sub");
    }

    /**
     * 根据 claims 生成 token
     *
     * @param claims claims
     * @return token
     */
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder().setClaims(claims).setExpiration(generateExpirationDate())
            .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    /**
     * 生成 token's expiration
     *
     * @return expiration date
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (final Exception e) {
            claims = null;
        }
        return claims;
    }
}
