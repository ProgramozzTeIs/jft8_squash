package pti.sb_squash_mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pti.sb_squash_mvc.dto.SimpleResponseDTO;
import pti.sb_squash_mvc.model.User;
import pti.sb_squash_mvc.repository.GameRepository;
import pti.sb_squash_mvc.repository.PlaceRepository;
import pti.sb_squash_mvc.repository.UserRepository;

import java.util.Random;

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
}