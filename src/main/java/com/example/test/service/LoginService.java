package com.example.test.service;

import com.example.test.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService implements UserDetailsService {
    @Autowired
    private  ClientService clientService;

    @Override
    public UserDetails loadUserByUsername(String idCard) throws UsernameNotFoundException {
        Client client=clientService.getClientByCard(idCard).get();
        User user =new User(client.getIdCard(),"{noop}"+client.getIdCard(),buildGranted());
        return user;
    }

    public List<GrantedAuthority> buildGranted(){
        String[]rol={"user","admin"};
        List<GrantedAuthority> auths= new ArrayList<>();
        auths.add(new SimpleGrantedAuthority(rol[0]));
        return auths;
    }
}
