package pti.sb_squash_mvc.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pti.sb_squash_mvc.dto.RegGameDTO;
import pti.sb_squash_mvc.dto.SimpleResponseDTO;
import pti.sb_squash_mvc.model.Game;

import pti.sb_squash_mvc.dto.RegPlaceDTO;
import pti.sb_squash_mvc.model.Place;

import pti.sb_squash_mvc.model.User;
import pti.sb_squash_mvc.repository.GameRepository;
import pti.sb_squash_mvc.repository.PlaceRepository;
import pti.sb_squash_mvc.repository.UserRepository;

@Service
public class AdminService {
    private final GameRepository gameRepo;
    private final PlaceRepository placeRepo;
    private final UserRepository userRepo;

    @Autowired
    public AdminService(GameRepository gameRepo, PlaceRepository placeRepo, UserRepository userRepo) {
        this.gameRepo = gameRepo;
        this.placeRepo = placeRepo;
        this.userRepo = userRepo;
    }

    public SimpleResponseDTO registerPlayer(Integer adminId, String userName) {
        String password = new Random().ints(48, 123)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(20)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        userRepo.save(new User(null, userName, password, "player", false, false));

        return new SimpleResponseDTO(adminId + "");
    }
    
    public SimpleResponseDTO registerGame(Integer adminId, RegGameDTO regGameDTO) {
        gameRepo.save(new Game(
                null,
                regGameDTO.getUser1Id(),
                regGameDTO.getUser2Id(),
                regGameDTO.getUser1Score(),
                regGameDTO.getUser2Score(),
                regGameDTO.getPlaceId(),
                regGameDTO.getDate()
        ));

        return new SimpleResponseDTO(adminId + "");
    }


	public SimpleResponseDTO placeRegister(Integer adminId, RegPlaceDTO regPlace) {
		SimpleResponseDTO simpleResponseDTO = null;
		
		Place place = new Place(
				null,
				regPlace.getName(),
				regPlace.getAddress(),
				regPlace.getRentalFee()
				);
		
		placeRepo.save(place);
		
		simpleResponseDTO = new SimpleResponseDTO(adminId + "");
		
		return simpleResponseDTO;
	}

}