package com.liguo.reservoirmanagement.interceptor;

import com.liguo.reservoirmanagement.pojo.UserInfo;
import com.liguo.reservoirmanagement.service.UserInfoService;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author nongChaTea
 * @date 2022/5/15 17:14
 */
@Configuration("myUserDetailService")
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserInfoService userInfoService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据用户名查找用户信息
        //根据查找到的用户信息判断用户是否被冻结
        UserInfo userInfo = userInfoService.identifyUser(username);
//        userInfo.setPassword("admin");
        System.out.println("数据库密码是:" + userInfo.getPassword());
        String pre_password = userInfo.getPassword();
        String password = passwordEncoder.encode(pre_password);

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        String authority = "ROLE_"+userInfo.getAuthority().toUpperCase();

        grantedAuthorities.add(new SimpleGrantedAuthority(authority));

        User user = new User(username, password,
                true, true, true, true,
                grantedAuthorities);
        System.out.println(user.toString());
        return user;
    }
}