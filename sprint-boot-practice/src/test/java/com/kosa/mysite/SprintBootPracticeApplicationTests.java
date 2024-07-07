package com.kosa.mysite;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SprintBootPracticeApplicationTests {

	@Autowired
	DataSource dataSource;
	
	@Test
	void datasourceConnectionTest() throws SQLException{
		// DataSource클래스 이름이 Hikari인지 확인
		assertThat(dataSource.getClass().getName()).isEqualTo("com.zaxxer.hikari.HikariDataSource");
		
		// 현재 사용하고 있는 DB가 Oracle인지 확인
		assertThat(dataSource.getConnection().getMetaData().getDatabaseProductName()).isEqualTo("Oracle");
		
	}

}
