package org.launchcode.hello_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {
    // Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }
    @GetMapping("goodbye") //now lives at /hello/goodbye
        public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles request of the form /hello?name=LaunchCode
//    @GetMapping("hello")
//    @PostMapping("hello")


    //handles the request of the form instead of getmapping and postmapping, this does both
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")

    //now lives at /hello/hello
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
        public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // Handles requests of the form /hello/LaunchCode

    @GetMapping("{name}")
        public String helloWithPathParam(@PathVariable String name) {
         return "Hello, " + name + "!";
    }

// now lives at /hello/form
    @GetMapping("form")
        public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + // this submits the request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
