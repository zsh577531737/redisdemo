package com.example.redisdemo.pattern.single;

/**\
 * 懒汉式  （线程安全） 不推荐
 */
public class Singelton4 {
    private static Singelton4 instance;

    private Singelton4() {
    }

    public synchronized static Singelton4 getInstance() {
        if(null == instance){
            return new Singelton4();
        }
        return instance;
    }
}
