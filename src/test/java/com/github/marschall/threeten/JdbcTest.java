package com.github.marschall.threeten;

import static org.junit.Assert.assertEquals;
import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.DERBY;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

public class JdbcTest {

  private EmbeddedDatabase db;
  private JdbcTemplate jdbcTemplate;

  @Before
  public void setUp() {
    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
    this.db = builder.setType(DERBY)
        .addScript("schema.sql")
        .addScript("data.sql")
        .build();
    this.jdbcTemplate = new JdbcTemplate(this.db);
  }

  @After
  public void tearDown() {
    this.db.shutdown();
  }

  @Test
  @Ignore("SPR-11600")
  public void queryJustClass() {
    LocalDate date = this.jdbcTemplate.queryForObject("SELECT DATE_COLUMN FROM JAVA_TIME", LocalDate.class);
    assertEquals(LocalDate.of(1988, 12, 25), date);
  }

  @Test
  @Ignore("driver support")
  public void queryRowMapper() {
    LocalDate date = this.jdbcTemplate.queryForObject("SELECT DATE_COLUMN FROM JAVA_TIME",
        (rs, rowNum) -> rs.getObject(1, LocalDate.class));
    assertEquals(LocalDate.of(1988, 12, 25), date);
  }
  
  @Test
  @Ignore("driver support")
  public void insert() {
    LocalDate date = LocalDate.of(1988, 12, 25);
    LocalTime time = LocalTime.of(15, 9, 2);
    int count = this.jdbcTemplate.update("INSERT INTO JAVA_TIME (DATE_COLUMN, TIME_COLUMN, TIMESTAMP_COLUMN) VALUES (?, ?, ?)",
        date, time, LocalDateTime.of(date, time));
    assertEquals(1, count);
  }

}
