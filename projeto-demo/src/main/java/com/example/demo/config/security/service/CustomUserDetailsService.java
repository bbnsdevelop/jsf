/**
 * 
 */
package com.example.demo.config.security.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ApplicationUser;
import com.example.demo.repositories.ApplicationUserRepository;

/**
 * @author bbnsdevelop
 *
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private ApplicationUserRepository applicationUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ApplicationUser applicationUser = loadApplicationUserByUsername(username);		
		return new CustomUserDetails(applicationUser);
	}
	
	public ApplicationUser loadApplicationUserByUsername(String username) {
		return Optional.ofNullable(applicationUserRepository.findByUserName(username))
				.orElseThrow(() -> new UsernameNotFoundException("ApplicationUser note found"));
	}
	
	private final static class CustomUserDetails extends ApplicationUser implements UserDetails {		
		private static final long serialVersionUID = 1L;

		private CustomUserDetails(ApplicationUser applicationUser) {
			super(applicationUser);
		}
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			List<GrantedAuthority> authorityListProfessor = AuthorityUtils.createAuthorityList("ROLE_PROFESSOR");
			List<GrantedAuthority> authorityListStudent = AuthorityUtils.createAuthorityList("ROLE_STUDENT");
			return this.getPassword() != null ? authorityListProfessor : authorityListStudent;
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}

		@Override
		public String getUsername() {
			return null;
		}
		
	}
	

}
