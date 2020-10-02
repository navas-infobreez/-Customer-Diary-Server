package com.planet.customer.diary.customer_diary.filter;

import static com.planet.customer.diary.customer_diary.model.constants.AppConstants.HEADER_STRING;
import static com.planet.customer.diary.customer_diary.model.constants.AppConstants.TOKEN_PREFIX;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.planet.customer.diary.customer_diary.util.JwtTokenUtil;

import io.jsonwebtoken.ExpiredJwtException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	protected void doFilterInternal(final HttpServletRequest req, final HttpServletResponse res,
			final FilterChain chain) throws IOException, ServletException {
		final String header = req.getHeader(HEADER_STRING);
		String username = null;
		String authToken = null;
		if (header != null && header.startsWith(TOKEN_PREFIX)) {
			authToken = header.replace(TOKEN_PREFIX, "");
			try {
				username = jwtTokenUtil.getUsernameFromToken(authToken);
			} catch (final IllegalArgumentException e) {
				logger.error("Error occured during getting username from token = ", e);
			} catch (final ExpiredJwtException e) {
				logger.warn("Token is expired and not valid anymore", e);
			}
		} else {
			logger.warn("Couldn't find bearer string, will ignore the header.");
		}
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			if (Boolean.TRUE.equals(jwtTokenUtil.validateToken(authToken, userDetails))) {
				final UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
				logger.info("Authenticated user " + username + ", setting security context.");
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}
		chain.doFilter(req, res);
	}

}