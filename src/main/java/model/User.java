package model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {

    private Long id;
    private String name;
    private String lastName;
    private Byte age;

    public User() {
    }

}
