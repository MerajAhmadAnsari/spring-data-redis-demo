package com.example.SpringDataRedis;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.sql.*;

@SpringBootApplication
@EnableCaching
public class SpringDataRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRedisApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner() {
		return (args) -> {
			Class.forName("com.mysql.jdbc.Driver");
			Connection dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
					"test", "test");
			if (dbConn != null) {
				ResultSet resultSet = null;
				Statement statement = null;
				String query = "select * from worker";
				try {
					statement = dbConn.createStatement();
					resultSet = statement.executeQuery(query);
					while (resultSet.next()) {
						resultSet.getString("name");
					}

					resultSet.close();
					statement.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				finally {
					dbConn.close();
				}
			}
		};
	}
}
