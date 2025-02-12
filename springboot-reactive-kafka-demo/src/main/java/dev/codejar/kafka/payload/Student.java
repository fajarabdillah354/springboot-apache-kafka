package dev.codejar.kafka.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.kafka.common.protocol.types.Field;

@Getter
@Setter
@ToString
public class Student {

    private Integer id;

    private String firstname;

    private String lastname;

}
