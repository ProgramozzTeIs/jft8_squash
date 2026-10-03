package pti.sb_squash_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pti.sb_squash_mvc.dto.RegPlaceDTO;
import pti.sb_squash_mvc.dto.SimpleResponseDTO;
import pti.sb_squash_mvc.service.AdminService;

@Controller
public class AdminController {
    private final AdminService adminService;

    @Autowired
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}

	@PostMapping("/admin/reg/player")
	public String registerPlayer(Model model, @RequestParam("adminId") Integer adminId, @RequestParam("userName") String userName) {
		SimpleResponseDTO dto = adminService.registerPlayer(adminId, userName);

		model.addAttribute("simpleResponseDTO", dto);

		return "admin.html";
	}
	
	@PostMapping("/admin/reg/place")
	public String placeRegister(
			Model model,
			@RequestParam("adminId") Integer adminId,
			RegPlaceDTO regPlace
			) {
		
		SimpleResponseDTO dto = adminService.placeRegister(adminId, regPlace);
		
		model.addAttribute("simpleResponseDTO", dto);
		
		return "admin.html";
	}
}