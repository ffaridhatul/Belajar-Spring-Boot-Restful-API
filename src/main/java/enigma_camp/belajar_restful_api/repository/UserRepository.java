package enigma_camp.belajar_restful_api.repository;

import enigma_camp.belajar_restful_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
