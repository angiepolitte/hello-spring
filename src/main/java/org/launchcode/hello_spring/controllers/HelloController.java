package org.launchcode.hello_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    @GetMapping("goodbye") //now lives at /hello/goodbye
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language) {
        String properGreeting = HelloController.createMessage(name, language);
        return "<h3 style=color:purple;>" + properGreeting + "</h3>";
    }

    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + // this submits the request to /hello
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                "<option value='English'>English</option>" +
                "<option value='Italian'>Italian</option>" +
                "<option value='French'>French</option>" +
                "<option value='German'>German</option>" +
                "<option value='Spanish'>Spanish</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    public static String createMessage(String name, String language) {

        if (language.equals("English")) {
            return "Hello " + name;
        } else if (language.equals("Italian")) {
            return "Buongiorno " + name;
        } else if (language.equals("French")) {
            return "Bonjour " + name;
        } else if (language.equals("German")) {
            return "Guter Tag " + name;
        } else if (language.equals("Spanish")) {
            return "Hola " + name;
        } else {
            return "Hello";
        }
    }
}




