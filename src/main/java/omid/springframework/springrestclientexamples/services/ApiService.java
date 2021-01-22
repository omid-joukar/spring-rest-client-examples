package omid.springframework.springrestclientexamples.services;

import omid.springframework.api.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ApiService {
    List<User> getUsers(Integer limit);
    Flux<User> getUsers(Mono<Integer> limit);
}
