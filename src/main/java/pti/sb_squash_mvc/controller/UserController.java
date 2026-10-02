package pti.sb_squash_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pti.sb_squash_mvc.dto.GamePageDTO;
import pti.sb_squash_mvc.service.UserService;

@Controller
public class UserController {
	
	private final UserService userService;
	
	
	@Autowired
    public UserController(UserService userService) {
		super();
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
        //TODO: user authentication

        GamePageDTO gamePageDTO = userService.getAllGames();
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
        GamePageDTO gamePageDTO = userService.searchPlace(placeId);
        model.addAttribute("gamePageDTO", gamePageDTO);
        return "games.html";
    }
    
}