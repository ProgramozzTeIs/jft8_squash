package pti.sb_squash_mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import pti.sb_squash_mvc.config.UserLoginStatuses;
import pti.sb_squash_mvc.dto.ExchangeRateDTO;
import pti.sb_squash_mvc.dto.GameDTO;
import pti.sb_squash_mvc.dto.GamePageDTO;
import pti.sb_squash_mvc.dto.GameResultDTO;
import pti.sb_squash_mvc.dto.PlaceDTO;
import pti.sb_squash_mvc.dto.SimpleResponseDTO;
import pti.sb_squash_mvc.dto.UserDTO;
import pti.sb_squash_mvc.model.FullGame;
import pti.sb_squash_mvc.model.Place;
import pti.sb_squash_mvc.model.User;
import pti.sb_squash_mvc.repository.GameRepository;
import pti.sb_squash_mvc.repository.PlaceRepository;
import pti.sb_squash_mvc.repository.UserRepository;

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



            return new SimpleResponseDTO(user.getId(), UserLoginStatuses.CHANGEPWD.toString());
        }

        return new SimpleResponseDTO(user.getId(), UserLoginStatuses.NOT_OK.toString());
    }

    public GamePageDTO getGamePageDTO(Integer userId, Integer searchedPlayerId, Integer searchedPlaceId) {
    	
		ExchangeRateDTO eRDTO = null;

		RestClient restClient = RestClient.create();
		eRDTO = restClient.get().uri("http://localhost:8081/exchange-rate").retrieve().body(ExchangeRateDTO.class);
		

		List<UserDTO> userDTOList = new ArrayList<>();
		for(User user : userRepo.findAll()) {
			UserDTO userDTO = this.convertUserToDTO(user);
			userDTOList.add(userDTO);
		}
		
		List<PlaceDTO> placeDTOList = new ArrayList<>();
		for(Place place : placeRepo.findAll()) {
			PlaceDTO placeDTO = this.convertPlaceToDTO(place, eRDTO.getRate());
			placeDTOList.add(placeDTO);
		}
		
		
        return new GamePageDTO(
                userId,
                getGameDTOList(searchedPlayerId, searchedPlaceId, eRDTO.getRate()),
                userDTOList, placeDTOList
//                StreamSupport.stream(userRepo.findAll().spliterator(), false).map(this::convertUserToDTO).toList(),
//                StreamSupport.stream(placeRepo.findAll().spliterator(), false).map(place -> this.convertPlaceToDTO(place, eRDTO.getRate())).toList()
        );
    }

    private List<GameDTO> getGameDTOList(Integer searchedPlayerId, Integer searchedPlaceId, Double eur) {
        if (searchedPlayerId != null) {
            return gameRepo.findGamesByPlayer(searchedPlayerId).stream().map(game -> this.convertFullGameToDTO(game, eur)).toList();
        }

        if (searchedPlaceId != null) {
            return gameRepo.findGamesByPlaceId(searchedPlaceId).stream().map(game -> this.convertFullGameToDTO(game, eur)).toList();
        }

        return gameRepo.findAllGames().stream().map(game -> this.convertFullGameToDTO(game, eur)).toList();
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



    private GameDTO convertFullGameToDTO(FullGame game, Double eur) {

		  return new GameDTO(
                new UserDTO(game.getUser1Id(), game.getUser1Name()),
                new UserDTO(game.getUser2Id(), game.getUser2Name()),
                new GameResultDTO(game.getUser1Score(), game.getUser2Score()),
                new PlaceDTO(game.getPlaceId(), game.getPlaceName(), game.getAddress(), game.getRentFee(), game.getRentFee() / eur
                		),
                game.getGameDate()
        );
    }

    private UserDTO convertUserToDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getName()
        );
    }

    private PlaceDTO convertPlaceToDTO(Place place, Double eur) {
        return new PlaceDTO(
                place.getId(),
                place.getName(),
                place.getAddress(),
                place.getRentFee(),
                place.getRentFee() / eur
        );
    }
}