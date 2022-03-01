package com.epam.jwd.jsonserializer.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ObjectMapperAdapter {
    public static final char START_BRACE = '{';
    public static final char COMMA = ',';
    public static final char DOUBLE_QUOTE = '\"';
    public static final char COLON = ':';
    public static final char FINISH_BRACE = '}';
    private final ObjectMapper mapper;
    private final Class<? extends Annotation> annotationClass;

    public ObjectMapperAdapter(ObjectMapper mapper, Class<? extends Annotation> annotationClass) {
        this.mapper = mapper;
        this.annotationClass = annotationClass;
    }

    public String writeValueAsString(Object object) throws IllegalAccessException, JsonProcessingException {
        Class<?> aClass = object.getClass();
        Field[] fields = aClass.getDeclaredFields();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(START_BRACE);

        for (Field field : fields) {
            if (field.isAnnotationPresent(annotationClass)) {
                field.setAccessible(true);
                stringBuilder.append(DOUBLE_QUOTE)
                                .append(field.getName())
                                .append(DOUBLE_QUOTE)
                                .append(COLON)
                                .append(mapper.writeValueAsString(field.get(object)))
                                .append(COMMA);
            }
        }
        if (stringBuilder.length() > 1) {
            stringBuilder.setCharAt(stringBuilder.length() - 1, FINISH_BRACE);
        } else {
            stringBuilder.append(FINISH_BRACE);
        }

        return stringBuilder.toString();
    }
}
