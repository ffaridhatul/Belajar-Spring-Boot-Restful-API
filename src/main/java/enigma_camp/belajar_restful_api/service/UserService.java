package enigma_camp.belajar_restful_api.service;

import enigma_camp.belajar_restful_api.entity.User;
import enigma_camp.belajar_restful_api.model.RegisterUserRequest;
import enigma_camp.belajar_restful_api.repository.UserRepository;
import enigma_camp.belajar_restful_api.security.BCrypt;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Validator validator;

    @Transactional
    public void register(RegisterUserRequest request) {
        Set<ConstraintViolation<RegisterUserRequest>> constraintViolation = validator.validate(request);
        if (constraintViolation.size() != 0) {
            //error
            throw new ConstraintViolationException(constraintViolation);
        }
        if (userRepository.existsById(request.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exists"); //error
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        user.setName(request.getName());

        userRepository.save(user); //save ke database
    }

}
