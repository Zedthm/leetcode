package com.zedthm.designParten;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/3/31 21:57
 * @description:
 */
class DCLSingletonTest {
    public static void main(String[] args) {
        DCLSingleton s1 = DCLSingleton.getSingleton();

        try {
            Constructor<DCLSingleton> constructor = DCLSingleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            DCLSingleton s2 = constructor.newInstance();
        } catch (Exception e) {
            System.out.println("反射攻击防御成功"+e.getMessage());
        }


    }
}