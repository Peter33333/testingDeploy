package com.example.mysqldemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller  // This means that this class is a Controller
@RequestMapping(path="/mysqlDemo") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/demo")
    public @ResponseBody Iterable<User> addNewUser(@RequestParam String message) {
    //@RequestMapping(value = "/demo",method=RequestMethod.POST)
    //public @ResponseBody Iterable<User>  addNewUser(User user) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        User user = new User();
        user.setMessage(message);
        userRepository.save(user);
        //return "redirect:/mysqlDemo/all";
        return userRepository.findAll();
    }

    @GetMapping(path="/all")
    //@RequestMapping(value = "/all",method=RequestMethod.POST)
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @GetMapping(path="/sayHi")
    //@RequestMapping(value = "/all",method=RequestMethod.POST)
    public @ResponseBody String sayHi() {
        // This returns a JSON or XML with the users
        return "Hi there";
    }
}
