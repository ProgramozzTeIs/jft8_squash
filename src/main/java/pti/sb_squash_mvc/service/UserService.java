package pti.sb_squash_mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        User user = userRepo.getUser(userName);

        if (user == null || (!user.getPassword().equals(password))) {
            return new SimpleResponseDTO(user.getId(), "NOT OK");
        }

        if (user.getRole().equals("admin")) {

            //TODO - Feri? - add response message, save login in repo
            user.setLoggedIn(true);
            userRepo.save(user);

            return new SimpleResponseDTO(user.getId(), "OK_ADMIN_LOGGED_IN");
        }

        if (user.getRole().equals("player")) {

            if (user.getFirstLoginDone()) {

                //TODO - Kálmán? - add response message, save login in repo
                user.setLoggedIn(true);
                userRepo.save(user);

                return new SimpleResponseDTO(user.getId(), "OK_USER_LOGGED_IN");
            }

            user.setFirstLoginDone(false);
            userRepo.save(user);

            return new SimpleResponseDTO(user.getId(), "CHANGEPWD");
        }

        return new SimpleResponseDTO(user.getId(), "NOT OK");
    }

    public GamePageDTO getGamePageDTO(Integer userId, Integer searchedPlayerId, Integer searchedPlaceId) {
        return new GamePageDTO(
                userId,
                getGameDTOList(searchedPlayerId, searchedPlaceId),
                StreamSupport.stream(userRepo.findAll().spliterator(), false).map(this::convertToDTO).toList(),
                StreamSupport.stream(placeRepo.findAll().spliterator(), false).map(this::convertToDTO).toList()
        );
    }

    private List<GameDTO> getGameDTOList(Integer searchedPlayerId, Integer searchedPlaceId) {
        if (searchedPlayerId != null) {
            return gameRepo.findGamesByPlayer(searchedPlayerId).stream().map(this::convertToDTO).toList();
        }

        if (searchedPlaceId != null) {
            //TODO: Kalman, filter by placeId
            return gameRepo.findGamesByPlaceId(searchedPlaceId).stream().map(this::convertToDTO).toList();
        }

        return gameRepo.findAllGames().stream().map(this::convertToDTO).toList();
    }

    public void changePassword(Integer userId, String password) {
        userRepo.findById(userId).ifPresent(user -> {
            user.setPassword(password);
            user.setLoggedIn(true);
            user.setFirstLoginDone(true);
            userRepo.save(user);
        });
    }

    public boolean loginFailed(String username, String password) {
        for (User user : userRepo.findAll()) {
            if (user.getName().equals(username) && user.getPassword().equals(password)) {
                return false;
            }
        }
        return true;
    }

    private GameDTO convertToDTO(FullGame game) {
        return new GameDTO(
                new UserDTO(game.getUser1Id(), game.getUser1Name()),
                new UserDTO(game.getUser2Id(), game.getUser2Name()),
                new GameResultDTO(game.getUser1Score(), game.getUser2Score()),
                new PlaceDTO(game.getPlaceId(), game.getPlaceName(), game.getAddress(), game.getRentFee()),
                game.getGameDate()
        );
    }

    private UserDTO convertToDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getName()
        );
    }

    private PlaceDTO convertToDTO(Place place) {
        return new PlaceDTO(
                place.getId(),
                place.getName(),
                place.getAddress(),
                place.getRentFee()
        );
    }
}