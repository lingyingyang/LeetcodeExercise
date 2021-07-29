package api.messaging;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonIncludeProperties({
    "id",
    "firstName",
    "lastName",
    "age",
    "sex",
    "email",
    "birthday",
    "birthplace",
    "residence",
    "phoneNumber",
})

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Person {
  @JsonProperty("id")
  private String id;

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("age")
  private int age;

  @JsonProperty("sex")
  private Sex sex;

  @JsonProperty("email")
  private String email;

  @JsonProperty("birthday")
  private Date birthday;

  @JsonProperty("birthplace")
  private Address birthplace;

  @JsonProperty("residence")
  private Address residence;

  @JsonProperty("phoneNumber")
  private String phoneNumber;

  private String hobbits;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Sex getSex() {
    return sex;
  }

  public void setSex(Sex sex) {
    this.sex = sex;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public Address getBirthplace() {
    return birthplace;
  }

  public void setBirthplace(Address birthplace) {
    this.birthplace = birthplace;
  }

  public Address getResidence() {
    return residence;
  }

  public void setResidence(Address residence) {
    this.residence = residence;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getHobbits() {
    return hobbits;
  }

  public void setHobbits(String hobbits) {
    this.hobbits = hobbits;
  }

  enum Sex {
    MALE, FEMALE
  }
}
