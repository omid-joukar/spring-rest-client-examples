package omid.springframework.springrestclientexamples.controllers;

import lombok.extern.slf4j.Slf4j;
import omid.springframework.springrestclientexamples.services.ApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;

@Slf4j
@Controller
public class UserController {

    private final ApiService apiService;

    public UserController(ApiService apiService) {
        this.apiService = apiService;
    }
    @GetMapping({"" , "/" , "index"})
    public String index(){
        return "index";
    }
    @PostMapping("/users")
    public String formPost(Model model, ServerWebExchange serverWebExchange){
        MultiValueMap<String, String> map = serverWebExchange.getFormData().block();
        Integer limit = new Integer(map.get("limit").get(0));
        log.debug("Reactived Limit Value: " + limit);
        if (limit == null || limit == 0){
            log.debug("Setting limit to default of 10");
            limit = 10;
        }
        model.addAttribute("users" , apiService.getUsers(limit));
        return "userlist";
    }
}
