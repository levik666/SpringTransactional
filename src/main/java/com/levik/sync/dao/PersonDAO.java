package com.levik.sync.dao;

import com.levik.sync.entity.Person;
import java.util.List;

public interface PersonDAO{

    void save(final Person p);

    List<Person> list();
}
