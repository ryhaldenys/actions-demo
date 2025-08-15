package ua.studying.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.studying.service.impl.UserServiceImpl;
import ua.studying.vo.User;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
  @InjectMocks private UserServiceImpl userService;

  @Test
  void getUsersTest() {
    var expectedUsers =
        List.of(
            new User(1, "Den", "Han"),
            new User(2, "Iva", "Joy"),
            new User(3, "Viki", "Pers"),
            new User(4, "Do", "Re"));

    var actualUsers = userService.getUsers();
    assertEquals(expectedUsers, actualUsers);
  }
}
