package com.kandogo.kandogo_api.api.ExceptionHandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpHeaders;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Problem extends HttpHeaders {

    private Integer status;
    private OffsetDateTime dateTime;
    private String title;
    private List<Field> fields;

    @Override
    public void addIfAbsent(String key, String value) {
        super.addIfAbsent(key, value);
    }


    @Getter
    @Setter
    @AllArgsConstructor
    public static class Field{
        private String name;
        private String message;
    }

}
