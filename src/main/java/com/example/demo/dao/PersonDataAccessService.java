package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonDataAccessService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public int insertPerson(Person person) {
        String sql = "INSERT INTO person (name, surname, address, age) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, person.getName(), person.getSurname(), person.getAddress(), person.getAge());
    }


    public List<Person> selectAllPeople() {
        final String sql = "SELECT id, name, surname, address, age FROM person";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String address = resultSet.getString("address");
            int age = resultSet.getInt("age");
            return new Person(id, name, surname, address, age);
        });
    }


    public Optional<Person> selectPersonById(int id) {
        final String sql = "SELECT id, name, surname, address, age FROM person WHERE id = ?";
        Person person = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) -> {
                    int personId = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String surname = resultSet.getString("surname");
                    String address = resultSet.getString("address");
                    int age = resultSet.getInt("age");
                    return new Person(personId, name, surname, address, age);
        });
        return Optional.ofNullable(person);
    }


    public int deletePersonById(int id) {

        String sql = "DELETE FROM person WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }


    public int updatePersonById(int id, Person person) {
        String sql = "UPDATE person SET name = ?, surname = ?, address = ?, age = ? WHERE id = ?";
        return jdbcTemplate.update(sql, person.getName(), person.getSurname(), person.getAddress(), person.getAge(), id);
    }
}
