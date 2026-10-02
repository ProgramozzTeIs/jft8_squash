package pti.sb_squash_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pti.sb_squash_mvc.service.AdminService;

@Controller
public class AdminController {

    private final AdminService adminService;

    
    @Autowired
	public AdminController(AdminService adminService) {
		super();
		// Test Comment for Merge Conflict
		System.out.println("abcd");
		this.adminService = adminService;
		/**
		 * TEST
		 */
		System.out.println("Hello Admin Controller!!");
	}

    

    
    
    


}
