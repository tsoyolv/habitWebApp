package com.habit.mvc.controller.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * OLTS on 08.01.2017.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public String adminPage(ModelMap modelMap) {
        modelMap.addAttribute("title", "Spring Security Admin Page");
        modelMap.addAttribute("message", "This is protected page!");
        return "/securityexamples/admin";
    }

    @RequestMapping(value="/admin/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        //You can redirect wherever you want, but generally it's a good practice to show login screen again.
        return "redirect:/login?logout";
    }
}
