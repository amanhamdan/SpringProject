package com.example.SpringProject.registration;

import com.example.SpringProject.event.RegistrationCompleteEvent;
import com.example.SpringProject.user.IUserService;
import com.example.SpringProject.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {
private final IUserService userService;
private final ApplicationEventPublisher publisher;
@GetMapping("/registration-form")
public String showRegistrationForm(Model model){
    model.addAttribute("user", new RegistrationRequest());
    return "registration";
}
@PostMapping("/register")
public String registerUser(@ModelAttribute("user") RegistrationRequest registration){
    User user = userService.registerUser(registration);
    //publish the verification email event here
    publisher.publishEvent(new RegistrationCompleteEvent(user,""));
    return "redirect:/registration/registration-form?success";
}


}
