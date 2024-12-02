package com.boothmanagement.pojo;

import java.util.Objects;

public class User {

  private long userId;
  private String userUsername;
  private String userPassword;
  private String userPhone;
  private String userEmail;
  private String userAvatar;
  private long userRole;


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getUserUsername() {
    return userUsername;
  }

  public void setUserUsername(String userUsername) {
    this.userUsername = userUsername;
  }


  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }


  public String getUserPhone() {
    return userPhone;
  }

  public void setUserPhone(String userPhone) {
    this.userPhone = userPhone;
  }


  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }


  public String getUserAvatar() {
    return userAvatar;
  }

  public void setUserAvatar(String userAvatar) {
    this.userAvatar = userAvatar;
  }


  public long getUserRole() {
    return userRole;
  }

  public void setUserRole(long userRole) {
    this.userRole = userRole;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof User)) return false;

    User user = (User) o;

    if (userId != user.userId) return false;
    if (userRole != user.userRole) return false;
    if (!Objects.equals(userUsername, user.userUsername)) return false;
    if (!Objects.equals(userPassword, user.userPassword)) return false;
    if (!Objects.equals(userPhone, user.userPhone)) return false;
    if (!Objects.equals(userEmail, user.userEmail)) return false;
    return Objects.equals(userAvatar, user.userAvatar);
  }

  @Override
  public int hashCode() {
    int result = (int) (userId ^ (userId >>> 32));
    result = 31 * result + (userUsername != null ? userUsername.hashCode() : 0);
    result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
    result = 31 * result + (userPhone != null ? userPhone.hashCode() : 0);
    result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
    result = 31 * result + (userAvatar != null ? userAvatar.hashCode() : 0);
    result = 31 * result + (int) (userRole ^ (userRole >>> 32));
    return result;
  }

  @Override
  public String toString() {
    return "User{" +
            "userId=" + userId +
            ", userUsername='" + userUsername + '\'' +
            ", userPassword='" + userPassword + '\'' +
            ", userPhone='" + userPhone + '\'' +
            ", userEmail='" + userEmail + '\'' +
            ", userAvatar='" + userAvatar + '\'' +
            ", userRole=" + userRole +
            '}';
  }
}
