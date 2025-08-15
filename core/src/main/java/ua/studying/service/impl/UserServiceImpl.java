package ua.studying.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import ua.studying.service.UserService;
import ua.studying.vo.User;

@Service
public class UserServiceImpl implements UserService {
  @Override
  public List<User> getUsers() {
    return users();
  }

  private static List<User> users() {
    return List.of(
        new User(1, "Den", "Han"),
        new User(2, "Iva", "Joy"),
        new User(3, "Viki", "Pers"),
        new User(4, "Do", "Re"));
  }
}
