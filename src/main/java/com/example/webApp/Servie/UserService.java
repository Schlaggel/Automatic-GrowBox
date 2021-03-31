package com.example.webApp.Servie;

import com.example.webApp.dto.UserDTONotLazy;
import com.example.webApp.repository.DeviceRepository;
import com.example.webApp.repository.RoleRepository;
import com.example.webApp.repository.UserRepository;
import com.example.webApp.util.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import javax.validation.ValidationException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    DeviceRepository deviceRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    ModelMapper modelMapper;


    public UserDTONotLazy findByUsername(String username) {
        return modelMapper.map(userRepository.findByUsername(username),
                UserDTONotLazy.class);
    }

    public UserDTONotLazy saveUser(User user) throws ValidationException {
        user.setRoles(Collections.singleton(roleRepository.findByRole("ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setDevices(Collections.emptySet());
        return modelMapper.map(userRepository.save(user), UserDTONotLazy.class);
    }


    public void deleteUser(Long id) throws  Exception{
            userRepository.deleteById(id);
    }

    public  List<UserDTONotLazy> findAll(Pageable pageable){
        return userRepository.findAll(pageable)
                .stream()
                .map(user -> modelMapper.map(user, UserDTONotLazy.class))
                .collect(Collectors.toList());
    }

    public Long count(){
        return userRepository.count();
    }
}
