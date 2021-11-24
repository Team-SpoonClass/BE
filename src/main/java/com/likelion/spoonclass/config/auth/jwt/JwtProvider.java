package com.likelion.spoonclass.config.auth.jwt;

import com.likelion.spoonclass.config.auth.security.MemberAdapter;
import com.likelion.spoonclass.domain.member.Authority;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;

/**
 *  JWT Token의 생성과 유효성 검증을 담당하는 Provider
 */
@Component
public class JwtProvider {

    private final UserDetailsService securityService;
    private final Long validTimeMilli;
    private String key;

    public JwtProvider(@Value("${jwt.validTime}") Long validTime,
                       @Value("${jwt.secret}") String key,
                       UserDetailsService securityService){
        this.securityService = securityService;
        this.validTimeMilli = validTime * 1000L;
        this.key = key;
    }

    // Bean 객체 생성시 초기화, key를 Base64로 인코딩한다.
    @PostConstruct
    protected void init(){
        key = Base64.getEncoder().encodeToString(key.getBytes());
    }

    /**
     * JWT 생성 로직
     * @param email
     * @param authority
     * @return
     */
    public String create(String email, Authority authority){
        Date now = new Date();
        Claims claims = Jwts.claims().setSubject(email);
        claims.put("authority",authority);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + validTimeMilli))
                .signWith(SignatureAlgorithm.HS256,key)
                .compact()
                ;
    }

    /**
     * Jwt 토큰의 유효성과 만료일자를 검증한다.
     * @param jwtToken
     * @return
     */
    public boolean validate(String jwtToken){
        try{
            Jws<Claims> claimsJws = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(jwtToken)
                    ;
            // 현재 시간과 토큰 유효시간을 비교한다.
            // 현재 시간이 토큰 유효시간보다 before 라면 true,
            // 아니면 exception 발생 -> catch 하여 false 리턴
            return !claimsJws.getBody().getExpiration().before(new Date());
        }
        catch(Exception e){
            return false;
        }
    }

    /**
     * JWT 토큰을 통해 현재 로그인한 회원 정보를 가져온다.
     * @param jwtToken
     * @return
     */
    public Authentication getAuthentication(String jwtToken){
        MemberAdapter memberAdapter = (MemberAdapter)securityService
                .loadUserByUsername(getEmailFromJwt(jwtToken));


        return new UsernamePasswordAuthenticationToken(memberAdapter,
                null,
                memberAdapter.getAuthorities());
    }

    /**
     * JWT 토큰의 payload에 저장한 email을 불러온다.
     * @param jwtToken
     * @return
     */
    public String getEmailFromJwt(String jwtToken){
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwtToken)
                .getBody()
                .getSubject();
    }

    /**
     * request의 X-AUTH_TOKEN header 에 담긴 현재 회원의 jwt 토큰 정보를 가져온다.
     * @param request
     * @return
     */
    public String resolve(HttpServletRequest request){
        return request.getHeader("X-AUTH-TOKEN");
    }

    public String setInvalidJwtMessage(String jwtToken){
        try{
            Jwts.parser().setSigningKey(key).parseClaimsJws(jwtToken);
            return "Server 내부 로직에서 발생한 오류입니다. 백엔드에 문의하세요.";
        }
        catch (UnsupportedJwtException | MalformedJwtException e){
            return "지원되지 않는 JWT 구성입니다.";
        }
        catch (ExpiredJwtException e){
            return "유효시간이 경과된 JWT 입니다.";
        }
        catch (SignatureException e){
            return "유효하지 않은 서명입니다.";
        }
        catch (IllegalArgumentException e){
            return "JWT는 공백으로 주어질수 없습니다.";
        }

    }
}
