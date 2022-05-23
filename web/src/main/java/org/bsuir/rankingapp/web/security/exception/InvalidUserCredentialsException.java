package org.bsuir.rankingapp.web.security.exception;

public class InvalidUserCredentialsException extends Exception {

  public InvalidUserCredentialsException(String message) {
    super(message);
  }

  public InvalidUserCredentialsException(String template, String... values) {
    super(String.format(template, values[0]));
  }
}
