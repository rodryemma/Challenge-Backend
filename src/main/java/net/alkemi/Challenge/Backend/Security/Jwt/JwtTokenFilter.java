package net.alkemi.Challenge.Backend.Security.Jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import net.alkemi.Challenge.Backend.Security.Service.UserDetailsServiceImp;

//Valida cada Token , si es asi permite el acceso al recurso o si no larga excepcion
//se ejecuta una ves por cada peticion

public class JwtTokenFilter extends OncePerRequestFilter {

	//verificar que metodo nos esta dando error
	private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
			
	@Autowired
	JwtProvider jwtProvider;
	
	@Autowired
	UserDetailsServiceImp userDetailServiceImp;
	
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
			throws ServletException, IOException {
	
		try {
			String token =getToken(req);
			if(token!= null && jwtProvider.validateToken(token)) {
				String nombreUsuario = jwtProvider.getNombreUsuarioFromToken(token);
				UserDetails userDetails = userDetailServiceImp.loadUserByUsername(nombreUsuario);
				UsernamePasswordAuthenticationToken auth = 
						new UsernamePasswordAuthenticationToken(userDetails, null , userDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		}catch(Exception e) {
			logger.error("fail en el metodo doFilter");
		}
		filterChain.doFilter(req, res);
	}

	private String getToken(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		if(header!=null && header.startsWith("Bearer")) {
			return header.replace("Bearer ", "");
		}else {
			return null;
		}		
	}
	
	
	
}
