package com.github.marschall.threeten;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class JdbcTest {
  
  @Test
  public void derby() throws SQLException, ClassNotFoundException {
    Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
    String url = "jdbc:derby:memory:myDB;create=true";
    try (Connection connection = DriverManager.getConnection(url)) {
      
    }
  }

}
