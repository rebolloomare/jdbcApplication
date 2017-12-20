/**
 * PersonRowMapper.java Fecha de creación: 19/12/2017, 23:52:05 Copyright (c) 2017 Omar Rebollo
 * Todos los derechos reservados. Este software es información confidencial, propiedad de Omar
 * Rebollo. Esta información confidencial no deberá ser divulgada y solo se podrá utilizar de
 * acuerdo a los términos que determine la propia persona.
 */
package omare.com.mx.springboot.jdbcjpa.jdbcjpaapplication;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import omare.com.mx.springboot.jdbcjpa.jdbcjpaapplication.entity.Person;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Omar Rebollo (omar.rebollo@gmail.com)
 * @version 1.0
 * @since
 */
public class PersonRowMapper implements RowMapper<Person> {

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo declara
	 * (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person person = new Person();
		person.setId(rs.getInt("id"));
		person.setName(rs.getString("name"));
		person.setLocation(rs.getString("location"));
		person.setBirthDate(rs.getTimestamp("birth_date"));
		return person;
	}

}
