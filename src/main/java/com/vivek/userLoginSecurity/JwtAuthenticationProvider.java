package com.vivek.userLoginSecurity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.vivek.userLoginModel.JwtAuthenticationToken;
import com.vivek.userLoginModel.JwtUser;
import com.vivek.userLoginModel.JwtUserDetails;
import com.vivek.userLoginUtil.JwtValidator;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider  {

    @Autowired
    private JwtValidator validator;
	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		
			
		// TODO Auto-generated method stub
		
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken jwtAuthtoken)
			throws AuthenticationException {
		JwtAuthenticationToken jwttoken = (JwtAuthenticationToken) jwtAuthtoken;
		String token = jwttoken.getToken();
		JwtUser jwtuser =validator.validate(token);
		if(jwtuser == null) {
			throw new RuntimeException("Invalid Jwt token");
		}
		
		List<GrantedAuthority> grantedAutherties = AuthorityUtils.commaSeparatedStringToAuthorityList(jwtuser.getRole());
		return new JwtUserDetails(jwtuser.getUserName(), jwtuser.getUserID(),grantedAutherties,token);
		
	}

}
