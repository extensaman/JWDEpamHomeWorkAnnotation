package com.epam.jwd.jsonserializer;

import com.epam.jwd.jsonserializer.entity.POJO;
import com.epam.jwd.jsonserializer.logic.ObjectMapperAdapter;
import com.epam.jwd.jsonserializer.service.annotation.Public;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The method accepts an object with the @Public annotation over some of its fields.
 * This method should return json, ignoring fields that are not annotated
 *
 * @author Aliaksandr Yusikau
 * @since 1.0
 */

public class Runner {

    private static final Logger logger = Logger.getLogger("JsonSerializer");
    public static final String SERIALIZE_OBJECT_USING_ORIGINAL_JACKSON_API =
                                    "Serialize object to JSON using original Jackson API\n";
    public static final String SERIALIZE_OBJECT_USING_ADAPTED_JACKSON_API =
                                    "Serialize object to JSON using adapted Jackson API\n";

    public static void main(String[] args) {

        POJO pojo = new POJO(10,
                "Hello",
                new int[]{1,2,3,4},
                3.1415926,
                Map.of(1, "Hi", 2, "Bye"),
                new Date());

        ObjectMapper originalMapper = new ObjectMapper();
        String originalResult = null;
        try {
            originalResult = originalMapper.writeValueAsString(pojo);
        } catch (JsonProcessingException e) {
            logger.log(Level.SEVERE, e::getMessage);
            return;
        }
        System.out.println(SERIALIZE_OBJECT_USING_ORIGINAL_JACKSON_API + originalResult);

        ObjectMapperAdapter adaptedMapper = new ObjectMapperAdapter(new ObjectMapper(), Public.class);
        String result = null;
        try {
            result = adaptedMapper.writeValueAsString(pojo);
        } catch (IllegalAccessException | JsonProcessingException e) {
            logger.log(Level.SEVERE, e::getMessage);
            return;
        }
        System.out.println(SERIALIZE_OBJECT_USING_ADAPTED_JACKSON_API + result);
    }
}
