package com.luokp;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author: luokp
 * @date: 2018/11/30 16:33
 * @description: person's dog
 */
public class Dog {
    private String name;
    private String color;
    public int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void call(String master){
        System.out.println("hello: master~~" + master);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Dog dog = new Dog();
        dog.setColor("red");
        dog.setName("aha");
        System.out.println(dog);
        System.out.println("\n---------------------------------\n");
        Class clazz = dog.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for(Field f: fields){
            String propertyName = f.getName();
            int modifier = f.getModifiers();
            String mStr = Modifier.toString(modifier);
            System.out.println(propertyName + " 属性:" + mStr);
        }
        System.out.println("\n---------------------------------\n");
        Field field = clazz.getDeclaredField("age");
        field.setAccessible(true);
        field.set(dog, 12);

        System.out.println(dog);
    }
}
