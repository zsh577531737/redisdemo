package com.example.redisdemo;

import com.example.redisdemo.pojo.User;
import com.example.redisdemo.service.TestInterface;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.function.Consumer;
import java.util.function.Function;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void Test1(){
//        Jedis jedis = new Jedis("localhost",6379,100000);
//        int i = 0;
//       try{
//           long beginTime = System.currentTimeMillis();
//           while (true){
//               long endTime = System.currentTimeMillis();
//               if(endTime - beginTime > 1000){
//                   break;
//               }
//               i++;
//               jedis.set("test" + i,i + "");
//           }
//       }finally {
//           jedis.close();
//       }
//        System.out.println("jedis每秒钟操作"+i);
    }

    @Test
    public void method2(){
        stringRedisTemplate.opsForValue().set("aaa","123");
        System.out.println(stringRedisTemplate.opsForValue().get("aaa"));
        Assert.assertEquals("123",stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void method3(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application.yml");
        RedisTemplate redisTemplate = context.getBean(RedisTemplate.class);
        User user = new User();
        user.setAge(1);
        user.setName("张三");
        redisTemplate.opsForValue().set("user1",user);
        User user2 = (User)redisTemplate.opsForValue().get("user1");
        user2.method();
    }

    interface MathOperation{
        int operation(int a,int b);
    }
    interface GreetingService<T,F>{
        F sayMessage(T message);
    }
    static class InnerClass {
        static String me1(String a){
            return String.valueOf(a);
        }
    }
    @Test
    public void method4(){
        GreetingService<String,String> function = InnerClass::me1;
        System.out.println(function.sayMessage("das"));
    }

    private int operation(int a,int b,MathOperation mathOperation){
        return mathOperation.operation(a,b);
    }
}
