package com.example;

import java.util.*;

public class LambdaCollectionTest {

    public static void main(String[] args) {
        List<Person> personList = Person.createList();
        
        // 使用 Lambda Expression 定義以LastName來升冪排序           
        System.out.println("++++++以LastName來升冪排序++++++");
        Collections.sort(personList, (p1,p2)->p1.getLastName().compareTo(p2.getLastName()));
        for(Person p:personList) {
	    	System.out.println(p);
	    }
        // 使用 Lambda Expression 定義以Age來降冪排序         
        System.out.println("++++++以Age來降冪排序++++++");
        Collections.sort(personList, (p1,p2)->p2.getAge()-p1.getAge());
        for(Person p:personList) {
	    	System.out.println(p);
	    }
        // 使用 Lambda Expression 定義移除所有女性成員        
        System.out.println("++++++移除所有女性成員++++++");
        personList.removeIf(p->p.getGender()==Gender.FEMALE);
        for(Person p:personList) {
	    	System.out.println(p);
	    }
        // 使用 Lambda Expression 定義移除年齡小於35成員  
        List<Person> personList2 = Person.createList();
        System.out.println("++++++移除年齡小於35成員++++++");
        personList2.removeIf(p->p.getAge()<35);
        for(Person p:personList2) {
	    	System.out.println(p);
	    }
    }
    
}