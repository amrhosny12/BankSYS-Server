package com.OnlineBanking.config;

import java.io.IOException;
import java.security.Key;
import java.security.Principal;

import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

import com.OnlineBanking.services.SecurityUtil;

import io.jsonwebtoken.Jwts;

@Provider
@Secure
@Priority(Priorities.AUTHENTICATION)
public class SecurityFilter implements ContainerRequestFilter {

	private static final String BEARER = "Bearer";
	
	//private SessionStore sessionStore = new SessionStore();
	private SecurityUtil securityUtil = new SecurityUtil();
	
	
	@Override
	public void filter(ContainerRequestContext reqCtx) throws IOException {
		
		String authHeader = reqCtx.getHeaderString(HttpHeaders.AUTHORIZATION);
		if(authHeader == null || !authHeader.startsWith(BEARER)) {
			throw new NotAuthorizedException("No Authorization Header Provider");
		}
		
		String token = authHeader.substring(BEARER.length()).trim();
		
		try {
			Key key = null;
			//securityUtil.generateKey(sessionStore.getEncryptedPW());
			Jwts.parser().setSigningKey(key).parseClaimsJws(token);
			SecurityContext securityContext = reqCtx.getSecurityContext();
			reqCtx.setSecurityContext(new SecurityContext() {

				@Override
				public String getAuthenticationScheme() {
					return securityContext.getAuthenticationScheme();
				}

				@Override
				public Principal getUserPrincipal() {
					return () -> Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject();
				}

				@Override
				public boolean isSecure() {
					return securityContext.isSecure();
				}

				@Override
				public boolean isUserInRole(String s) {
					return securityContext.isUserInRole(s);
				}
			}); 
			
		}catch(Exception e) {
			
			reqCtx.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
		}
	}
}
