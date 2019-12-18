package com.example.redis.service;

import com.example.redis.pojo.User;
import com.example.redis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author raintrees
 * @date 2019/12/17 17:38
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    //普通的缓存+数据库查询代码实现逻辑:
    //User user=RedisUtil.get(key);
    //   if(user==null){
    //   	  user=userDao.findById(id);
    //   	  //redis的key="product_item_"+id
    //   	  RedisUtil.set(key,user);
    //   }
    //   return user;

    //@Cacheable:查询的时候才使用该注解!
    //注意:在Cacheable注解中支持EL表达式
    //redis缓存的key=user_1/2/3....
    //redis的缓存雪崩,缓存穿透,缓存预热,缓存更新...
    //condition = "#result ne null",条件表达式,当满足某个条件的时候才进行缓存
    //unless = "#result eq null":当user对象为空的时候,不进行缓存
    @Cacheable(value = "user",key = "#id",unless = "#result eq null")
    public User queryUserById(Integer id) {
        return userRepository.findByUserId(id);
    }

    //@CachePut:一般用在添加和修改方法中
    //既往数据库中添加一个新的对象,于此同时也往redis缓存中添加一个对应的缓存.
    //这样可以达到缓存预热的目的.
    @CachePut(value = "user",key = "#result.id",unless = "#result eq null")
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
