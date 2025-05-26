package com.example;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamFilterTest {

    public static void main(String[] args) {
        List<Person> personList = Person.createList();
        ContactService service = new ContactService();
        Consumer<Person> sendEmail = p->service.sendEmail(p);
        Consumer<Person> sendMessage = p->service.sendMessage(p);
        
        
        // 將集合轉為串流物件
        // 使用forEach()寄送Email給成員
        System.out.println("Email 給成員");
        personList.forEach(p->service.sendEmail(p));
        
        //使用filter()過濾小於30歲的成員後,使用forEach()寄送Email
        System.out.println("Email 給小於30歲的成員");
        personList.stream()
                  .filter(p->p.getAge()<30)
                  .forEach(sendEmail);
                
        //傳簡訊給南部成員
        System.out.println("傳簡訊給南部成員");
        personList.stream()
		  		  .filter(p->p.getCity()!=City.Taipei)
		  		  .forEach(sendMessage);
                
        //宣告Predicte過濾高雄男性成員, 使用forEach()傳簡訊給過濾後成員
        System.out.println("傳簡訊給高雄男性成員");
        personList.stream()
		  		  .filter(p->p.getCity()==City.Kaohsiung)
		  		  .filter(p->p.getGender()==Gender.MALE)
		  		  .forEach(sendMessage);
                
        //使用鍊式呼叫Email給男性成員
        System.out.println("Email給男性成員");
        personList.stream()
		  		  .filter(p->p.getGender()==Gender.MALE)
		  		  .forEach(sendEmail);
        
        //使用鍊式呼叫傳簡訊給台南的女性成員
        System.out.println("傳簡訊給台南的女性成員");
        personList.stream()
		          .filter(p->(p.getCity()==City.Tainan && p.getGender()==Gender.FEMALE))
		          .forEach(sendMessage);
        
        //使用鍊式呼叫傳簡訊給台北25歲以上的男性成員
        System.out.println("傳簡訊給台北25歲以上的男性成員");
        personList.stream()
        		  .filter(p->p.getCity()==City.Taipei)
        		  .filter(p->p.getAge()>=25)
        		  .filter(p->p.getGender()==Gender.MALE)
        		  .forEach(sendMessage);
        
    }
    
}

