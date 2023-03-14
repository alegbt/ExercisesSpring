package co.develhope.swagger2.controllers;

import co.develhope.swagger2.entities.ArithmeticOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController{



    @GetMapping("")
    public String welcomeMathMsg(){
        return "welcome to /math";
    }

    @GetMapping("/division-info")
    public String divInfo(ArithmeticOperation arOp){
        return arOp.getName()+
                arOp.getMinNumberOfOperands()+
                arOp.getMinNumberOfOperands()+
                arOp.getDescription()+
                arOp.getProperties()+
                arOp.getClass();
    }


    /**
     * Get multiplication double.
     *
     * @param x the x
     * @param y the y
     * @return the double
     */
    @GetMapping("/multiplication")
    public double getMultiplication(double x, double y){
        return x*y;
    }


    @GetMapping("/square/{n}")
    public double getSquare(double n){
        return n*n;
    }



}