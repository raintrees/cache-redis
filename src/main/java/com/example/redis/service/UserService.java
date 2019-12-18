package com.example.redis.service;

import com.example.redis.pojo.User;
import com.example.redis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author raintrees
 * @date 2019/12/17 17:38
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User queryUserById(Integer id) {
        return userRepository.findByUserId(id);
    }
}
