package com.vivek.userLoginModel;



import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

	/**
	 * 
	 */
	private static final long serialVersionUID = 121928;
	private String Token;
	public JwtAuthenticationToken(String token) {
		super(null, null);
		this.Token = token;
	}
	public String getToken() {
		return Token;
	}
	public void setToken(String token) {
		Token = token;
	}
	
	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

}
