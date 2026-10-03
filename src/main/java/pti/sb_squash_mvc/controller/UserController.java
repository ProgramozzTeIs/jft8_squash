package pti.sb_squash_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pti.sb_squash_mvc.dto.GamePageDTO;
import pti.sb_squash_mvc.dto.SimpleResponseDTO;
import pti.sb_squash_mvc.dto.UserDTO;
import pti.sb_squash_mvc.service.UserService;

@Controller
public class UserController {
	private final UserService userService;
	
	@Autowired
    public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/")
    public String index() {
        return "login.html";
    }
    
    @PostMapping("/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model
    ) {
        SimpleResponseDTO response = userService.login(username, password);

        if(response.getResponse().equals("NOT OK")) {
            if (userService.loginFailed(username, password)) {
                return "login.html";
            }
        } else if(response.getResponse().equals("CHANGEPWD")) {
            UserDTO dto = new UserDTO(response.getUserId(), username);

            model.addAttribute("userDTO", dto);

            return "changepwd.html";
        } else if(response.getResponse().equals("")) {

            //TODO - Feri? - add attribute to equals, add dto to model, return required html

        } else if(response.getResponse().equals("")) {

            //TODO - Kálmán? - add attribute to equals

            GamePageDTO gamePageDTO = userService.getGamePageDTO(response.getUserId(), null, null); //TODO: Change userId to login user ID

            model.addAttribute("gamePageDTO", gamePageDTO);

            return "games.html";
        }

        return "login.html";
    }

    @PostMapping("/user/changepwd")
    public String changePassword(Model model, @RequestParam("uId") Integer userId, @RequestParam("newPwd") String password) {
        userService.changePassword(userId, password);

        GamePageDTO gamePageDTO = userService.getGamePageDTO(userId, null, null);

        model.addAttribute("gamePageDTO", gamePageDTO);

        return "games.html";
    }

    @GetMapping("/user/search/player")
    public String searchPlayer(Model model, @RequestParam("requestUserId") Integer userId, @RequestParam("searchedPlayerId") Integer playerId) {
        //TODO: user authentication

        GamePageDTO gamePageDTO = userService.getGamePageDTO(userId, playerId, null);

        model.addAttribute("gamePageDTO", gamePageDTO);

        return "games.html";
    }

    @GetMapping("/user/search/place")
    public String searchPlace(
            @RequestParam("uid") Integer uid,
            @RequestParam("placeid") Integer placeId,
            Model model
    ) {
        //TODO: user authentication

        GamePageDTO gamePageDTO = userService.getGamePageDTO(uid, null, placeId);

        model.addAttribute("gamePageDTO", gamePageDTO);

        return "games.html";
    }
}