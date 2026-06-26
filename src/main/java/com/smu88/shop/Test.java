package com.smu88.shop;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Test {
    private Integer age;
    private String name;
    public void setageplus1(){
        this.age+=1;
    }
    public void setage(Integer a){
        this.age=a;
    }
}
