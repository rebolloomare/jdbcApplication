package omare.com.mx.springboot.jdbcjpa.jdbcjpaapplication;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import omare.com.mx.springboot.jdbcjpa.jdbcjpaapplication.dao.PersonJdbcDao;
import omare.com.mx.springboot.jdbcjpa.jdbcjpaapplication.entity.Person;

@SpringBootApplication
public class JdbcjpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(JdbcjpaApplication.class);

	@Autowired
	private PersonJdbcDao personJdbcDao;

	public static void main(String[] args) {
		SpringApplication.run(JdbcjpaApplication.class, args);
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo declara
	 * (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {} ", personJdbcDao.findAll());
		logger.info("User id -> {} ", personJdbcDao.findById(10001));
		logger.info("Deleting 10002 -> No of rows Deleted - {} ",
			personJdbcDao.deleteById(10002));
		logger.info("Inserting 10004 -> {} ",
			personJdbcDao.insert(new Person(10004, "Omar", "Mexico", new Date())));
		logger.info("Update 10003 -> {} ",
			personJdbcDao.update(new Person(10003, "Pieter", "Alemania", new Date())));
	}
}
