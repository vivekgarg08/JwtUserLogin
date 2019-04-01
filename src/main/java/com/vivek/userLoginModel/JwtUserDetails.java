package com.vivek.userLoginModel;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUserDetails implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String userID;
	private List<GrantedAuthority> grantedAutherties;
	private String token;

	public JwtUserDetails(String userID, String userName, List<GrantedAuthority> grantedAutherties, String token) {
		super();
		this.userID = userID;
		this.grantedAutherties = grantedAutherties;
		this.token = token;
		this.userName = userName;
	}

	public String getToken() {
		return token;
	}
	
	public String getUserID() {
		return userID;
	}
	
	public List<GrantedAuthority> getGrantedAutherties() {
		return grantedAutherties;
	}

	public String getUserName() {
		return userName;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return grantedAutherties;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


}
