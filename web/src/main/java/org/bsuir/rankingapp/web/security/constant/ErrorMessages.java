package org.bsuir.rankingapp.web.security.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ErrorMessages {

  public final String INVALID_USERNAME = "%s is an invalid value for username.";
  public final String INVALID_PASSWORD = "Password must contain from 8 to 32 characters, at least "
      + "one number and both lower and uppercase letters and special characters.";
  public final String USER_NOT_FOUND = "User was not found.";
}
