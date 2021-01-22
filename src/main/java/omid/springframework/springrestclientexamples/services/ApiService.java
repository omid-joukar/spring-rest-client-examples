package omid.springframework.springrestclientexamples.services;

import omid.springframework.api.domain.User;

import java.util.List;

public interface ApiService {
    List<User> getUsers(Integer limit);
}
