//package org.bsuir.rankingapp.web.security.service;
//
//import java.nio.charset.StandardCharsets;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.util.Base64;
//import java.util.List;
//import java.util.Map;
//import lombok.RequiredArgsConstructor;
//import org.bsuir.rankingapp.web.security.constant.ErrorMessages;
//import org.bsuir.rankingapp.web.security.constant.SecurityConstraints;
//import org.bsuir.rankingapp.web.security.dal.entity.BasicAuthToken;
//import org.bsuir.rankingapp.web.security.dal.entity.User;
//import org.bsuir.rankingapp.web.security.dal.repository.AuthorityRepository;
//import org.bsuir.rankingapp.web.security.dal.repository.TokenReposiroty;
//import org.bsuir.rankingapp.web.security.dal.repository.UserRepository;
//import org.bsuir.rankingapp.web.security.exception.InvalidUserCredentialsException;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@Transactional
//@RequiredArgsConstructor
//public class SimpleSecurityService /* implements UserDetailsService */ {
//
//  private final AuthorityRepository authorityRepository;
//  private final BCryptPasswordEncoder bCryptPasswordEncoder;
//  private final TokenReposiroty tokenReposiroty;
//  private final UserRepository userRepository;
//
//  public HttpEntity<Void> createUserOrHandleError(String credentialString) {
//    try {
//      var credentials = decodeCredentials(credentialString);
//      var user = createUser(credentials.get("username"), credentials.get("password"));
//      return authorizeOrHandleError(credentialString);
//
//    } catch (InvalidUserCredentialsException e) {
//      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    } catch (Exception e) {
//      e.printStackTrace();
//      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//  }
//
//  public HttpEntity<Void> authorizeOrHandleError(String credentialString) {
//    var credentials = decodeCredentials(credentialString);
//    return authorizeOrHandleError(credentials.get("username"), credentials.get("password"));
//  }
//
//  public HttpEntity<Void> authorizeOrHandleError(String username, String password) {
//    try {
//      validateCredentials(username, password);
//      var token = authenticateOrThrow(username, password);
////      var headers = new HttpHeaders();
////      headers.setBasicAuth();
////      var response = new ResponseEntity<>(HttpStatus.OK);
//
//      return null;
//
//    } catch (InvalidUserCredentialsException e) {
//      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    } catch (UsernameNotFoundException e) {
//      var headers = new HttpHeaders();
//      headers.set("Error-Message", e.getMessage());
//      return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
//    }
//  }
//
//  private User createUser(String username, String password)
//      throws InvalidUserCredentialsException {
//    validateCredentials(username, password);
//    var passwordEncrypted = bCryptPasswordEncoder.encode(password);
//    var authorities = authorityRepository
//        .getAuthorities(List.of(SecurityConstraints.AUTHORITY_USER_BASIC));
//    var index = getMessageDigest(username, SecurityConstraints.MD5);
//    return userRepository.save(new User(index, username, passwordEncrypted, authorities));
//  }
//
//  private BasicAuthToken authenticateOrThrow(String username, String password)
//      throws UsernameNotFoundException {
//    var user = userRepository.findByUsernameAndPassword(username, password)
//        // TODO: User not found
//        .orElseThrow(() -> new UsernameNotFoundException(ErrorMessages.USER_NOT_FOUND));
//    var credentialString = String.format("%s:%s", user.getUsername(), user.getPassword());
//    var token = getMessageDigest(credentialString, credentialString);
//    return tokenReposiroty.save(new BasicAuthToken(token, user.getAuthorities()));
//  }
//
//  private void validateCredentials(String username, String password)
//      throws InvalidUserCredentialsException {
//    if (username.isBlank() || !username.matches(SecurityConstraints.USERNAME_PATTERN)) {
//      throw new InvalidUserCredentialsException(ErrorMessages.INVALID_USERNAME, username);
//    }
//    if (password.isBlank() || !password.matches(SecurityConstraints.PASSWORD_PATTERN)) {
//      throw new InvalidUserCredentialsException(ErrorMessages.INVALID_PASSWORD);
//    }
//  }
//
//  private String getMessageDigest(String message, String algorithm) {
//    try {
//      var md = MessageDigest.getInstance(algorithm);
//      md.update(message.getBytes(StandardCharsets.UTF_8));
//      return new String(md.digest());
//
//    } catch (NoSuchAlgorithmException e) {
//      e.printStackTrace();
//      return null;
//    }
//  }
//
//  private Map<String, String> decodeCredentials(String credentials) {
//    var usernamePassword = new String(Base64.getDecoder().decode(credentials))
//        .split(SecurityConstraints.CREDENTAILS_SEPARATOR);
//    return Map.of(
//        "username", usernamePassword[0],
//        "password", usernamePassword[1]);
//  }
//}
