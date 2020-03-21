package com.simba.security;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncodeTest {
    @Test
    public void encodePassword(){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedpassword = passwordEncoder.encode("123456");
        System.out.println(encodedpassword);
    }
}
