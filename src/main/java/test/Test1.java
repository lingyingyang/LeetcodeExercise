package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.util.Date;

public class Test1 {

  @Data
  public static class Model {
    private String name;
    private Date lastUpdateTime;
  }

  public static void main(String[] args) throws JsonProcessingException {
    Date date = new Date();
    System.out.println(date);

    ObjectMapper objectMapper = new ObjectMapper();
    String json = "{\"name\" : \"Philip\"}";
    Model model = objectMapper.readValue(json, Model.class);
    model.setLastUpdateTime(date);
    System.out.println(model);
  }
}
