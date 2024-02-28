package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        String test = "hello it's test data";
        model.addAttribute("data", test);
        return "hello";
    }

    @GetMapping("hello-spring")
    public String helloMvc(@RequestParam(value = "name", required = false) String inputName, Model model) {
        model.addAttribute("inputName", inputName);
        return "hello-spring";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("string") String inputString) {
        return "hello " + inputString;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
