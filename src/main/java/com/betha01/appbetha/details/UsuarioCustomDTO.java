package com.betha01.appbetha.details;

import java.util.Collection;

import com.betha01.appbetha.models.Users;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * UsuarioCustomDTO
 */

public class UsuarioCustomDTO implements UserDetails {

  private String username;
  private String userpass;

  public UsuarioCustomDTO(Users user) {
    this.username = user.getUsername();
    this.userpass = user.getUserpass();
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
      return null;
  }

  @Override
  public String getPassword() {
      return userpass;
  }

  @Override
  public String getUsername() {
      return username;
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

}