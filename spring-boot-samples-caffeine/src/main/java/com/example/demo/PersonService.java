package com.example.demo;/**
 * Created by HUXU on 2017/9/18.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * How to use Caffeine
 *
 * @author huxu
 * @create 2017-09-18 14:53
 **/

@Service
public class PersonService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /*@Autowired
    private PersonDAO personDao;*/

    /**
     * 根据id获取Person对象，使用缓存
     * @param id
     * @return Person对象
     */
    @Cacheable(value="getPersonById", sync=true)
    public Person getPersonById(int id){
        logger.debug("getting data from database, personId={}", id);

        Person person = new Person();
        person.setId(1);
        person.setName("cowboy");
        person.setTime(new Date());

        return person;
    }

}