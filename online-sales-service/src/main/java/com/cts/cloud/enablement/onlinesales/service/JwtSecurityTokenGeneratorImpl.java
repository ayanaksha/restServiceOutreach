package com.cts.cloud.enablement.onlinesales.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.cts.cloud.enablement.onlinesales.domain.SalesUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtSecurityTokenGeneratorImpl implements SecurityTokenGenerator {

	/**
	 * Generate jwt token
	 */
	@Override
	public Map<String, Object> generateToken(SalesUser user) {
		String jwtToken = "";
		jwtToken = Jwts.builder().setSubject(user.getId().toString()).setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "secretkey").compact();
		Map<String, Object> map = new HashMap<>();
		map.put("token", jwtToken);
		map.put("message", "User successfully logged in");
		return map;
	}

}
