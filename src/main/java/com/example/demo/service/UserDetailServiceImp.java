package com.example.demo.service;

import com.example.demo.domain.Custumer;
import com.example.demo.repository.CustumerRepository;
import com.example.demo.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by loliveira on 26/11/18.
 */
@Service
public class UserDetailServiceImp implements UserDetailsService {

    @Autowired
    private CustumerRepository custumerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Custumer custumer = custumerRepository.findByEmail(email);

        if(custumer == null) {
            throw new UsernameNotFoundException(email);
        }

        return new UserSS(custumer.getId(), custumer.getEmail(), custumer.getPassword(), custumer.getRoles());
    }
}
