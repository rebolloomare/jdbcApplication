/**
 * PersonJdbcDao.java Fecha de creación: 19/12/2017, 19:46:16 Copyright (c) 2017 Omar Rebollo
 * Todos los derechos reservados. Este software es información confidencial, propiedad de Omar
 * Rebollo. Esta información confidencial no deberá ser divulgada y solo se podrá utilizar de
 * acuerdo a los términos que determine la propia persona.
 */
package omare.com.mx.springboot.jdbcjpa.jdbcjpaapplication.dao;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import omare.com.mx.springboot.jdbcjpa.jdbcjpaapplication.PersonRowMapper;
import omare.com.mx.springboot.jdbcjpa.jdbcjpaapplication.entity.Person;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Omar Rebollo (omar.rebollo@gmail.com)
 * @version 1.0
 * @since
 */
@Repository
public class PersonJdbcDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Person> findAll() {
		return jdbcTemplate.query("select * from person", new PersonRowMapper());
	}

	public Person findById(int id) {
		return jdbcTemplate.queryForObject("select * from person where id = ?",
			new Object[] { id }, new PersonRowMapper());
	}

	public List<Person> findByName(String name) {
		return jdbcTemplate.query("select * from person where name = ?",
			new PersonRowMapper());
	}

	public int deleteById(int id) {
		return jdbcTemplate.update("delete from person where id = ?", new Object[] { id });
	}

	public int insert(Person person) {
		return jdbcTemplate.update(
			"insert into person (id, name, location, birth_date) values(?, ?, ?, ?)",
			new Object[] { person.getId(), person.getName(), person.getLocation(),
				new Timestamp(person.getBirthDate().getTime()) });
	}

	public int update(Person person) {
		return jdbcTemplate.update(
			"update person set name=?, location=?, birth_date=? where id=?",
			new Object[] { person.getName(), person.getLocation(),
				new Timestamp(person.getBirthDate().getTime()), person.getId() });
	}

}
