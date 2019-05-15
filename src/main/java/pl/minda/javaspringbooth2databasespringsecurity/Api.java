package pl.minda.javaspringbooth2databasespringsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Api {

    @GetMapping("/t1")
    public String t1(){
        System.out.println("Witaj Adminie");
        return "t1";
    }
    @GetMapping("/t2")
    public String t2(){
        System.out.println("Witaj User");
        return "t2";
    }
    @GetMapping("/t3")
    public String t3(){
        System.out.println("Witaj");
        return "t3";
    }
}
