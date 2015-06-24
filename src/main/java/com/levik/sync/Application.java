package com.levik.sync;

import com.levik.sync.dao.PersonDAO;
import com.levik.sync.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");

        final PersonDAO personDAO = (PersonDAO) context.getBean("PersonDAO1");

        final Person person = new Person();
        person.setName("Levik");
        person.setCountry("Ukraine");

        personDAO.save(person);

        System.out.println("Person::" + person);

        final List<Person> list = personDAO.list();

        for(final Person p : list){
            System.out.println("Person:: " + p);
        }
    }
}
