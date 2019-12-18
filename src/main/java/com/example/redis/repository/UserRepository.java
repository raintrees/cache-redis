package com.example.redis.repository;

import com.example.redis.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author raintrees
 * @date 2019/12/17 17:45
 */
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("select u.id as id,u.username as username,u.password as password from User u where id = id1")
    User findByUserId(Integer id);

}
