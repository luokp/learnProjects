package com.luokp;

public class HelloService {

    private String name;
    private String gender;
    private int age;
    private Dog dog;

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void hello(){
        System.out.println("hello: \n name:" + name + ", gender:" + gender + ", age:" + age + ", dog:" + dog);
        if(dog != null){
            dog.call(name);
        }
    }
}
