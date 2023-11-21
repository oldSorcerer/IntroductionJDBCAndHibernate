package service;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceTest {

    String testName = "Ivan";
    String testLastName = "Ivanov";
    byte testAge = 25;

}
