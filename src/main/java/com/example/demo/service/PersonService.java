package com.example.demo.service;

import com.example.demo.dao.PersonDataAccessService;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDataAccessService personDao;

    @Autowired
    public PersonService(PersonDataAccessService personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(int id) {
        return personDao.selectPersonById(id);
    }

    public int deletePerson(int id) {
        return personDao.deletePersonById(id);
    }

    public int updatePerson(int id, Person newPerson) {
        return personDao.updatePersonById(id, newPerson);
    }
}
