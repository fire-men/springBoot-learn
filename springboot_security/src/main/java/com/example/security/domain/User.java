package com.example.security.domain;

import com.example.security.util.UserStateEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
    private Integer id;

    private String password;

    private String userName;

    private String nickName;

    private String address;

    private String email;

    private String remark;

    private Integer isDelete;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private Integer state;

    private List<Role> roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role r :
                roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+r.getRoleName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
      if(this.state.equals(1)){
          return false;
      }
      return true;

    }


    @Override
    public boolean isAccountNonLocked() {
        if(this.state.equals(2)){
            return false;
        }
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        if(this.state.equals(0)){
            return true;
        }
        return false;
    }
}