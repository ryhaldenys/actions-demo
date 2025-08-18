package ua.studying.service;

import java.util.List;
import ua.studying.vo.User;

public interface UserService {
  List<User> getUsers();

  List<User> getUsersByName(String name);

  User getUserById(Integer id);
}
