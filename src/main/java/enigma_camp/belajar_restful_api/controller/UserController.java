package enigma_camp.belajar_restful_api.controller;

import enigma_camp.belajar_restful_api.model.RegisterUserRequest;
import enigma_camp.belajar_restful_api.model.WebResponse;
import enigma_camp.belajar_restful_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping(value = "api/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    
    public WebResponse<String> register (@RequestBody RegisterUserRequest request) {
        userService.register(request);
        return WebResponse.<String>builder().data("OK").build();
    }
}
