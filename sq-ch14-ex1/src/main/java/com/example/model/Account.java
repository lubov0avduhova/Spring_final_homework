package com.example.model;

import com.example.patternComposite.Human;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
public class Account implements Human {

  @Id
  private long id;
  private String name;
  private BigDecimal amount;

  @Override
  public String getAccount() {
    return name;
  }
}
