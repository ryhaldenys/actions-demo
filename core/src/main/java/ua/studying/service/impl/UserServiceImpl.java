package ua.studying.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import ua.studying.service.UserService;
import ua.studying.vo.User;

@Service
public class UserServiceImpl implements UserService {
  @Override
  public List<User> getUsers() {
    return users();
  }

  @Override
  public List<User> getUsersByName(String name) {
    return users().stream().filter(u -> u.firstName().equals(name)).collect(Collectors.toList());
  }

  private static List<User> users() {
    return List.of(
        new User(1, "Den", "Han"),
        new User(2, "Iva", "Joy"),
        new User(3, "Viki", "Pers"),
        new User(4, "Do", "Re"));
  }
}
