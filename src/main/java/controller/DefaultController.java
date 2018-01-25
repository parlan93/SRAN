package controller;

import domain.User;
import domain.UserRepository;
import helper.ViewList;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Bartłomiej Skibiński
 */
@Controller
public class DefaultController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = {"/", "/home"})
    public String home(Model model, @RequestParam(value = "success", required = false) String success) {
        model.addAttribute("currentPage", ViewList.HOME);
        if (success != null) {
            if (success.equals("registered")) {
                model.addAttribute("success", "success");
            }
        }
        return "home";
    }

    // TODO: Do usunięcia
    @RequestMapping(value = "/hello")
    public String hello(Model model) {
        return "hello";
    }

    @RequestMapping(value = "/login")
    public String login(Model model) {
        model.addAttribute("currentPage", ViewList.LOGIN);
        return "login";
    }

    @RequestMapping(value = "/register")
    public String register(Model model, @RequestParam(value = "failed", required = false) String failed) {
        model.addAttribute("currentPage", ViewList.REGISTER);
        if (failed != null) {
            switch(Integer.valueOf(failed)) {
                case 1: model.addAttribute("failed", "1"); break;
                case 2: model.addAttribute("failed", "2"); break;
                case 3: model.addAttribute("failed", "3"); break;
                case 4: model.addAttribute("failed", "4"); break;
                case 5: model.addAttribute("failed", "5"); break;
                case 6: model.addAttribute("failed", "6"); break;
                case 7: model.addAttribute("failed", "7"); break;
            }
        }
        return "register";
    }

    @RequestMapping(value = "/403")
    public String error403(Model model) {
        model.addAttribute("currentPage", ViewList.ERROR403);
        return "403";
    }

    @RequestMapping(value = "/register/add-account")
    public String registerAccount(
            @RequestParam(value = "title") String title,
            @RequestParam(value = "firstname") String firstname,
            @RequestParam(value = "lastname") String lastname,
            @RequestParam(value = "organization") String organization,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "login") String login,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "confirmPassword") String confirmPassword,
            Model model) {
        if (arePasswordsEqual(password, confirmPassword) && isEmailValid(email) && isLoginAvailable(login)) {
            userRepository.save(new User(login, password, email, firstname, lastname, title, organization));
            return "redirect:/home?success=registered";
        } else {
            if (!isLoginAvailable(login)) {
                if (!arePasswordsEqual(password, confirmPassword)) {
                    if (!isEmailValid(email)) {
                        return "redirect:/register?failed=7";
                    } else {
                        return "redirect:/register?failed=6";
                    }
                } else {
                    if (!isEmailValid(email)) {
                        return "redirect:/register?failed=5";
                    } else {
                        return "redirect:/register?failed=4";
                    }
                }
            } else {
                if (!arePasswordsEqual(password, confirmPassword)) {
                    if (!isEmailValid(email)) {
                        return "redirect:/register?failed=3";
                    } else {
                        return "redirect:/register?failed=2";
                    }
                } else {
                    if (!isEmailValid(email)) {
                        return "redirect:/register?failed=1";
                    }
                }
            }
        }
        return "/home";
    }

    private Boolean arePasswordsEqual(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    private Boolean isEmailValid(String email) {
        try {
            InternetAddress emailAddress = new InternetAddress(email);
            emailAddress.validate();
            if (!isEmailAvailable(email)) {
                return false;
            }
        } catch (AddressException ex) {
            return false;
        }
        return true;
    }

    private Boolean isEmailAvailable(String email) {
        for (User user : userRepository.findAll()) {
            if (user.getEmail().equals(email.trim())) {
                return false;
            }
        }
        return true;
    }

    private Boolean isLoginAvailable(String login) {
        for (User user : userRepository.findAll()) {
            if (user.getUserName().equals(login.trim())) {
                return false;
            }
        }
        return true;
    }

}
