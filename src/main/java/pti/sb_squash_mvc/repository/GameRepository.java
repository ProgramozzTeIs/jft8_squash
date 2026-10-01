package pti.sb_squash_mvc.repository;

import org.springframework.data.repository.CrudRepository;
import pti.sb_squash_mvc.model.Game;

public interface GameRepository extends CrudRepository<Game, Integer> {

}