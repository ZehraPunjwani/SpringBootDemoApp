package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class FakePersonDataAccessService implements PersonDao {

    Logger logger = Logger.getLogger(FakePersonDataAccessService.class.getName());

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        Person newPerson = new Person(id, person.getName());
        DB.add(newPerson);
        logger.log(Level.INFO, "Added: " + newPerson);
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        logger.log(Level.INFO, "Records: " + DB);
        return DB;
    }
}
