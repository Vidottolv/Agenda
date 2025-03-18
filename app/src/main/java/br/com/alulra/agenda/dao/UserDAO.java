package br.com.alulra.agenda.dao;

import java.util.ArrayList;
import java.util.List;
import br.com.alulra.agenda.model.User;
public class UserDAO {
    private final static List<User> users = new ArrayList<>();
    public void save(User user) { users.add(user); }
    public List<User> all() { return new ArrayList<>(users); }
}
