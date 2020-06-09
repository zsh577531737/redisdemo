package com.example.redisdemo.redis;


import com.example.redisdemo.utils.redis.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PfTest {
    @Autowired
    private RedisUtil redisUtil;


    @Test
    public void test1(){
        redisUtil.set("tongjirenshu","1",RedisConstants.DB_1.getDbId());
        String a = redisUtil.get("tongjirenshu",RedisConstants.DB_1.getDbId());
        System.out.println(a);
    }


    @Test
    public void pfAdd(){
        for (int i = 100000; i < 150000; i++) {
            redisUtil.pfadd("pageCount2","user_"+i,RedisConstants.DB_2.getDbId());
        }
    }

    @Test
    public void pfCount(){
       Long count =  redisUtil.pfcount("pageCount",RedisConstants.DB_2.getDbId());
        System.out.println(count);
    }


    @Test
    public void pfMerge(){
        redisUtil.pfmerge("pageCount2",RedisConstants.DB_2.getDbId(),"pageCount");

    }
}
