package org.bsuir.rankingapp.web.security.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SecurityConstraints {

  public final String AUTHORITY_USER_BASIC = "ROLE_USER_BASIC";
  public final String CREDENTAILS_SEPARATOR = ":";

  public final String MD5 = "MD5";
  public final String SHA256 = "SHA256";

  public final String PASSWORD_PATTERN = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,32}$";
  public final String USERNAME_PATTERN = "(?=[a-zA-Z1-9._])(?!^[1-9._])(?!.*[._]{2,}.*)(?!.*[._]$).{6,32}";
}
