package com.tiy;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by RdDvls on 9/22/16.
 */
@RestController
public class MakeChocolateJsonController {
    @RequestMapping(path = "/chocolate.json", method = RequestMethod.GET)
    public ChocolateSolution makeChocolate(Integer numSmall, Integer numBig, Integer goal){
        ChocolateSolver solver = new ChocolateSolver();
        ChocolateSolution solution = new ChocolateSolution();
        solution = solver.makeChocolate(numSmall,numBig,goal);
        return solution;
    }
}
