package pti.sb_squash_mvc.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pti.sb_squash_mvc.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT * FROM user WHERE name = :userName")
    User getUser(@Param("userName") String userName);
}