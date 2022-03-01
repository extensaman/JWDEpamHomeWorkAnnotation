package com.epam.jwd.jsonserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Field;
import java.util.Map;

public class Runner {
    public static void main(String[] args) throws JsonProcessingException, IllegalAccessException {
        ObjectMapper mapper = new ObjectMapper();
        POJO pojo = new POJO(10,"Hello", new int[]{1,2,3,4}, 3.1415926, Map.of(1, "Hi", 2, "Bye"));

        Class<? extends POJO> aClass = pojo.getClass();
        Field[] fields = aClass.getDeclaredFields();

        for (Field field : fields) {

            if (field.isAnnotationPresent(Public.class)) {
                field.setAccessible(true);

                System.out.println("\"" + field.getName() + "\":" + mapper.writeValueAsString(field.get(pojo)));
            }


        }
        String result = mapper.writeValueAsString(pojo);
        System.out.println(result);
    }
}
