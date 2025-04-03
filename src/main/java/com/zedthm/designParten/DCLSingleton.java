package com.zedthm.designParten;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/3/31 21:46
 * @description:
 */
public class DCLSingleton implements Serializable {
    private static volatile DCLSingleton singleton ;
    private DCLSingleton(){
        if (singleton != null) {
            throw new IllegalStateException("Singleton already initialized");
        }
    }

    public static DCLSingleton getSingleton() {
        if (singleton == null) {
            synchronized (DCLSingleton.class) {
                if (singleton == null) {
                    singleton = new DCLSingleton();
                }
            }
        }
        return singleton;
    }

    protected Object readResolve(){
        return getSingleton();
    }

    static{
        try{
            Constructor<DCLSingleton> constructor = DCLSingleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
            throw new IllegalStateException("Singleton broken by reflection");
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException ignored) {

        }
    }

    @Override
    protected Object clone() throws  CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton cannot be cloned");
    }

    public static void showMessage() {
        System.out.println("hello this is double check locked singleton instance constructor");
    }
}
