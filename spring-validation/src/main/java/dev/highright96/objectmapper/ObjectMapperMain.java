package dev.highright96.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class ObjectMapperMain {
    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        //ObjectMapperBasic(objectMapper);
        ObjectMapperAdvanced(objectMapper);
    }

    private static void ObjectMapperBasic(ObjectMapper objectMapper) throws JsonProcessingException {

        // Object -> Text
        ObjectMapperUser user = new ObjectMapperUser("userA", 20);
        String text = objectMapper.writeValueAsString(user);
        System.out.println("text = " + text);

        // Text -> Object 는 default 생성자가 필수
        ObjectMapperUser textToUser = objectMapper.readValue(text, ObjectMapperUser.class);
        System.out.println("textToUser = " + textToUser.toString());
    }

    private static void ObjectMapperAdvanced(ObjectMapper objectMapper) throws JsonProcessingException {

        AdvancedCar bmw = AdvancedCar.builder()
                .name("bmw")
                .carNumber("1234")
                .build();

        AdvancedCar benz = AdvancedCar.builder()
                .name("benz")
                .carNumber("1232")
                .build();

        List<AdvancedCar> cars = Arrays.asList(bmw, benz);

        AdvancedUser au = AdvancedUser.builder()
                .name("userA")
                .age(20)
                .cars(cars)
                .build();

        System.out.println("au = " + au);

        //Object -> Json
        String json = objectMapper.writeValueAsString(au);
        System.out.println("json = " + json);

        JsonNode jsonNode = objectMapper.readTree(json);
        String _name = jsonNode.get("name").asText();
        int _age = jsonNode.get("age").asInt();

        System.out.println("_name = " + _name);
        System.out.println("_age = " + _age);

        /*
        ** Json -> Object **
        JsonNode jsonCars = jsonNode.get("cars");
        ArrayNode arrayNode = (ArrayNode) jsonCars;
        List<AdvancedCar> _advancedCars = objectMapper.convertValue(arrayNode, new TypeReference<List<AdvancedCar>>() {
        });
        System.out.println("_advancedCars = " + _advancedCars);

        ObjectNode objectNode = (ObjectNode) jsonNode;
        objectNode.put("name", "userB");
        objectNode.put("age", 30);
        System.out.println("objectNode = " + objectNode.toString());
         */
    }
}
