package pti.sb_squash_mvc.repository;

import org.springframework.data.repository.CrudRepository;
import pti.sb_squash_mvc.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}