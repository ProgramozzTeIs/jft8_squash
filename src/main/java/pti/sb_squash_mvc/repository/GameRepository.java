package pti.sb_squash_mvc.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pti.sb_squash_mvc.model.FullGame;
import pti.sb_squash_mvc.model.Game;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Integer> {
    @Query("SELECT user1_id, (SELECT name FROM user WHERE id = game.user1_id) AS user1_name, user2_id, (SELECT name FROM user WHERE id = game.user2_id) AS user2_name, user1_score, user2_score, place.id AS place_id, place.name AS place_name, place.address, place.rent_fee, game_date FROM game JOIN place ON place.id = game.place_id ORDER BY game_date DESC")
    List<FullGame> findAllGames();

    @Query("SELECT user1_id, (SELECT name FROM user WHERE id = game.user1_id) AS user1_name, user2_id, (SELECT name FROM user WHERE id = game.user2_id) AS user2_name, user1_score, user2_score, place.id AS place_id, place.name AS place_name, place.address, place.rent_fee, game_date FROM game JOIN place ON place.id = game.place_id WHERE user1_id = :userId OR user2_id = :userId ORDER BY game_date DESC")
    List<FullGame> findGamesByPlayer(@Param("userId") Integer userId);
}