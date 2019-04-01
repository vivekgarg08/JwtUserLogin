package com.vivek.userLoginUtil;

import org.springframework.stereotype.Component;

import com.vivek.userLoginModel.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {
	private String secret = "vivek" ;
	public JwtUser validate(String token) {
		 JwtUser jwtUser= null;
		 try {
			 
		 
		Claims claims = Jwts.parser()
				.setSigningKey(secret)
				.parseClaimsJws(token)
				.getBody();
		 jwtUser= new JwtUser();
		 jwtUser.setUserName(claims.getSubject());
		 jwtUser.setUserID((String)claims.get("userId"));
		 jwtUser.setRole((String)claims.get("role"));
		 }
		 catch(Exception e) {
			 System.out.println(e.getMessage());
			 
		 }
		
      return jwtUser;
		
	}

}
