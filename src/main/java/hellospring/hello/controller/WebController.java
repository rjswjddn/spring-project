package hellospring.hello.controller;

import hellospring.hello.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import hellospring.hello.service.UserService;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class WebController {

    private final UserService userService;

    @GetMapping(value = {"/", "/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/buttons")
    public String buttons(){
        return "buttons";
    }

    @GetMapping("/404")
    public String error(){
        return "404";
    }

    @GetMapping("/blank")
    public String blank(){
        return "blank";
    }

    @GetMapping("/cards")
    public String cards(){
        return "cards";
    }

    @GetMapping("/charts")
    public String charts(){
        return "charts";
    }

    @GetMapping("/forgot-password")
    public String forgotpassword(){
        return "forgot-password";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    /* 정보 입력받고 리다이렉트로 tables로 이동 */
    @PostMapping("/register")
    public String registerdo(@ModelAttribute("user") User user){
        userService.registerUser(user);
        return "redirect:/tables";
    }

    @GetMapping("/tables")
    public String tables(Model model){
        model.addAttribute("user", userService.getUsers());
        return "tables";
    }

    @GetMapping("/tables/update/{id}")
    public String updateUserView (@PathVariable("id") Long id, Model model){

        log.info("id: {}", id);

        User user = userService.getUser(id);

        log.info("user: {}", user);
        model.addAttribute("user", user);
        return "/user-update";
    }


    @PutMapping("/tables/update/{id}")
    public String updateUser(@PathVariable("id") Long id, User user){

        log.info("user: {}", user);

        User update_user = userService.getUser(id);


        update_user.setUser_id(user.getUser_id());
        update_user.setUser_name(user.getUser_name());
        update_user.setMemo(user.getMemo());

        userService.updateUser(update_user);
        return "redirect:/tables";
    }

    @DeleteMapping("/tables/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "redirect:/tables";
    }

    @GetMapping("/utilities-animation")
    public String utillitiesanimation(){
        return "utilities-animation";
    }

    @GetMapping("/utilities-border")
    public String utilitiesborder(){
        return "utilities-border";
    }

    @GetMapping("/utilities-color")
    public String utilitiescolor(){
        return "utilities-color";
    }

    @GetMapping("/utilities-other")
    public String utilitiesother(){
        return "utilities-other";
    }


}
