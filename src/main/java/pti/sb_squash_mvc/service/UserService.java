package pti.sb_squash_mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pti.sb_squash_mvc.repository.GameRepository;
import pti.sb_squash_mvc.repository.PlaceRepository;
import pti.sb_squash_mvc.repository.UserRepository;

@Service
public class UserService {
	
	private GameRepository gameRepo;
	private PlaceRepository placeRepo;
	private UserRepository userRepo;
	
	@Autowired
	public UserService(GameRepository gameRepo, PlaceRepository placeRepo, UserRepository userRepo) {
		super();
		this.gameRepo = gameRepo;
		this.placeRepo = placeRepo;
		this.userRepo = userRepo;
	}
	
	

}
