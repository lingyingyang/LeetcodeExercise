package api.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class PersonTest {

  @Test
  void whenEmptyField_thenExcludeInSerialization() throws JsonProcessingException {
    Person person = new Person();
    person.setId("id");
    person.setFirstName("philip");
    person.setLastName("yang");
    person.setAge(30);

    ObjectMapper objectMapper = new ObjectMapper();
    String out = objectMapper.writeValueAsString(person);
    assertFalse(out.contains("email"));
    System.out.println(out);
  }
}