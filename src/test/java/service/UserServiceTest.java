package service;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceTest {

    private final String testName = "Ivan";
    private final String testLastName = "Ivanov";
    private final byte testAge = 25;

}
