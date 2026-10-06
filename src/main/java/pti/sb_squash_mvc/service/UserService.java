package pti.sb_squash_mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pti.sb_squash_mvc.config.UserLoginStatuses;
import pti.sb_squash_mvc.dto.*;
import pti.sb_squash_mvc.model.FullGame;
import pti.sb_squash_mvc.model.Place;
import pti.sb_squash_mvc.model.User;
import pti.sb_squash_mvc.repository.GameRepository;
import pti.sb_squash_mvc.repository.PlaceRepository;
import pti.sb_squash_mvc.repository.UserRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class UserService {
    private final GameRepository gameRepo;
    private final PlaceRepository placeRepo;
    private final UserRepository userRepo;

    @Autowired
    public UserService(GameRepository gameRepo, PlaceRepository placeRepo, UserRepository userRepo) {
        this.gameRepo = gameRepo;
        this.placeRepo = placeRepo;
        this.userRepo = userRepo;
    }

    public SimpleResponseDTO login(String userName, String password) {

        User user = userRepo.getUserByUserNameAndPassword(userName, password);

        if (user == null) {
            return new SimpleResponseDTO(-1, UserLoginStatuses.NOT_OK.toString());
        }

        if (user.getRole().equals("admin")) {

            user.setLoggedIn(true);
            userRepo.save(user);

            return new SimpleResponseDTO(user.getId(), UserLoginStatuses.OK_ADMIN_LOGGED_IN.toString());
        }

        if (user.getRole().equals("player")) {

            if (user.getFirstLoginDone()) {

                user.setLoggedIn(true);
                userRepo.save(user);

                return new SimpleResponseDTO(user.getId(), UserLoginStatuses.OK_USER_LOGGED_IN.toString());
            }

//            user.setFirstLoginDone(false);
//            userRepo.save(user);

            return new SimpleResponseDTO(user.getId(), UserLoginStatuses.CHANGEPWD.toString());
        }

        return new SimpleResponseDTO(user.getId(), UserLoginStatuses.NOT_OK.toString());
    }

    public GamePageDTO getGamePageDTO(Integer userId, Integer searchedPlayerId, Integer searchedPlaceId) {
        return new GamePageDTO(
                userId,
                getGameDTOList(searchedPlayerId, searchedPlaceId),
                StreamSupport.stream(userRepo.findAll().spliterator(), false).map(this::convertUserToDTO).toList(),
                StreamSupport.stream(placeRepo.findAll().spliterator(), false).map(this::convertPlaceToDTO).toList()
        );
    }

    private List<GameDTO> getGameDTOList(Integer searchedPlayerId, Integer searchedPlaceId) {
        if (searchedPlayerId != null) {
            return gameRepo.findGamesByPlayer(searchedPlayerId).stream().map(this::convertFullGameToDTO).toList();
        }

        if (searchedPlaceId != null) {
            return gameRepo.findGamesByPlaceId(searchedPlaceId).stream().map(this::convertFullGameToDTO).toList();
        }

        return gameRepo.findAllGames().stream().map(this::convertFullGameToDTO).toList();
    }

    public void changePassword(Integer userId, String password) {
    	// TODO: User not found by ID
    	
    	userRepo.findById(userId).ifPresent(user -> {
            user.setPassword(password);
            user.setLoggedIn(true);
            user.setFirstLoginDone(true);
            userRepo.save(user);
        });
    }

//    public boolean loginFailed(String username, String password) {
//        for (User user : userRepo.findAll()) {
//            if (user.getName().equals(username) && user.getPassword().equals(password)) {
//                return false;
//            }
//        }
//        return true;
//    }

    private GameDTO convertFullGameToDTO(FullGame game) {
        return new GameDTO(
                new UserDTO(game.getUser1Id(), game.getUser1Name()),
                new UserDTO(game.getUser2Id(), game.getUser2Name()),
                new GameResultDTO(game.getUser1Score(), game.getUser2Score()),
                new PlaceDTO(game.getPlaceId(), game.getPlaceName(), game.getAddress(), game.getRentFee()),
                game.getGameDate()
        );
    }

    private UserDTO convertUserToDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getName()
        );
    }

    private PlaceDTO convertPlaceToDTO(Place place) {
        return new PlaceDTO(
                place.getId(),
                place.getName(),
                place.getAddress(),
                place.getRentFee()
        );
    }
}