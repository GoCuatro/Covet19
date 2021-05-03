package com.javeriana.web.four.covet19.Usuarios.User.Infrastructure;

import com.javeriana.web.four.covet19.Shared.Domain.User.UserId;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryUserRepository implements UserRepository {

    private User user = new User(new UserId("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432721"),  new UserName("Pinocho"), new UserLastName("Ni idea"),
            new UserNickName("PinochoMaderita"), new UserPassword("MaderiTa1*23"));
    private User user2 = new User(new UserId("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432735"),  new UserName("Lobo"), new UserLastName("Feroz"),
            new UserNickName("LoboFeroz"), new UserPassword("TengoHambre1*23"));

    private List<User> users = new ArrayList<>() {{
       add(user);
       add(user2);
    }};

    @Override
    public void save(User user) {
        this.users.add(user);
    }

    @Override
    public Optional<User> find(String userId) {
        return users.stream().filter(user -> user.equalsById(userId)).findFirst();
    }

    @Override
    public void update(String userId, User user) {

    }
}
