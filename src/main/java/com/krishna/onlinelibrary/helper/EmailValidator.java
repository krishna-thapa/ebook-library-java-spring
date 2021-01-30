package com.krishna.onlinelibrary.helper;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidator implements Predicate<String> {
  @Override
  public boolean test(String email) {
    // TODO add Regex to validate email
    return true;
  }
}
