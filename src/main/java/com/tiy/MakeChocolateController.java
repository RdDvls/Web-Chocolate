package com.tiy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by RdDvls on 9/22/16.
 */
@Controller
public class MakeChocolateController {
    @RequestMapping(path = "/chocolate", method = RequestMethod.GET)
    public String home(Model model, HttpSession session){
        return "chocolate";
    }
}
