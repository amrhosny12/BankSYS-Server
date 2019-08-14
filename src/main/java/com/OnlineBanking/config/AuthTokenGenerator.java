package com.OnlineBanking.config;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import com.OnlineBanking.services.SecurityUtil;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


public class AuthTokenGenerator {
	

	SecurityUtil securityUtil = new SecurityUtil();
	

	public String getToken(String username, String pw, UriInfo uriInfo) {
		Key key = securityUtil.generateKey(securityUtil.encodeText(pw));
		String token = Jwts.builder().setSubject(username).setIssuer(uriInfo.getAbsolutePath().toString())
						.setIssuedAt(new Date()).setExpiration(toDate(LocalDateTime.now().plusMinutes(15)))
						.signWith(SignatureAlgorithm.HS256, key).setAudience(uriInfo.getBaseUri().toString())
						.compact();
		return token;
	}
		
	private Date toDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

}
