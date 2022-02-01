package com.alkemy.disney.disney.auth.service;

import com.alkemy.disney.disney.auth.dto.UserDTO;
import com.alkemy.disney.disney.auth.repository.UserRepository;
import com.alkemy.disney.disney.auth.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Collections;

@Service
public class UserDetailCustomService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    //@Autowired
    //private EmailService emailService;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
        UserEntity userEntity = userRepository.findByUsername(userName);
        if (userEntity == null) {
            throw new UsernameNotFoundException("Username or Password not found");
        }
        return new User(userEntity.getUsername(),userEntity.getPassword(), Collections.emptyList());
    }

    public boolean save(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(userDTO.getPassword());
        userEntity = this.userRepository.save(userEntity);
        //TODO:Activar el if por el emailService issue.arriba en la linea 22 tambien
        //if (userEntity != null){
           // emailService.sendWelcomeEmailTo(userEntity.getUsername());
        //}
        return userEntity != null;
    }
}
