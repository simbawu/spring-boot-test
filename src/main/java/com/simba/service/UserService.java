package com.simba.service;

import java.util.ArrayList;
import java.util.List;

import com.simba.domain.FKRole;
import com.simba.domain.FKUser;
import com.simba.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * 需要实现UserDetailsService接口
 * 因为在Spring Security中配置的相关参数需要是UserDetailsService类型的数据
 * */
@Service
public class UserService implements UserDetailsService{

	// 注入持久层接口UserRepository
	@Autowired
	UserRepository userRepository;
	
	/*
	 *  重写UserDetailsService接口中的loadUserByUsername方法，通过该方法查询到对应的用户(non-Javadoc)
	 *  返回对象UserDetails是Spring Security中一个核心的接口。
	 *  其中定义了一些可以获取用户名、密码、权限等与认证相关的信息的方法。
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 调用持久层接口findByLoginName方法查找用户，此处的传进来的参数实际是loginName
		FKUser fkUser = userRepository.findByLoginName(username);
        if (fkUser == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        // 创建List集合，用来保存用户权限，GrantedAuthority对象代表赋予给当前用户的权限
        List<GrantedAuthority> authorities = new ArrayList<>();
        // 获得当前用户权限集合
        List<FKRole> roles = fkUser.getRoles();
        for (FKRole role : roles) {
        	// 将关联对象Role的authority属性保存为用户的认证权限
        	authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }
        // 此处返回的是org.springframework.security.core.userdetails.User类，该类是Spring Security内部的实现
        return new User(fkUser.getUsername(), fkUser.getPassword(), authorities);
	}

}
