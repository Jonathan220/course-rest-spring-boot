package br.com.jonathan.course_rest_with_spring.controllers;

import br.com.jonathan.course_rest_with_spring.Utils.MathUtils;
import br.com.jonathan.course_rest_with_spring.exception.UnsupportedMathOperationException;
import br.com.jonathan.course_rest_with_spring.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @Autowired
    MathService mathService;

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if(!MathUtils.isNumeric(numberOne) || !MathUtils.isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return mathService.sum(MathUtils.convertToDouble(numberOne), MathUtils.convertToDouble(numberTwo));
    }

    @RequestMapping("/subtration/{numberOne}/{numberTwo}")
    public Double subtration(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if(!MathUtils.isNumeric(numberOne) || !MathUtils.isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return mathService.subtraction(MathUtils.convertToDouble(numberOne), MathUtils.convertToDouble(numberTwo));
    }

    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if(!MathUtils.isNumeric(numberOne) || !MathUtils.isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return mathService.multiplication(MathUtils.convertToDouble(numberOne), MathUtils.convertToDouble(numberTwo));
    }

    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if(!MathUtils.isNumeric(numberOne) || !MathUtils.isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please ser a numeric value!");
        return mathService.mean(MathUtils.convertToDouble(numberOne), MathUtils.convertToDouble(numberTwo));
    }

    @RequestMapping("/squareroot/{number}")
    public Double squareRoot(@PathVariable("number") String number){
        if(!MathUtils.isNumeric(number)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return mathService.squareRoot(MathUtils.convertToDouble(number));
    }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo){
        if(!MathUtils.isNumeric(numberOne) || !MathUtils.isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        if(MathUtils.isZero(numberTwo)) throw new UnsupportedMathOperationException("Division by zero is not possible");
        return mathService.division(MathUtils.convertToDouble(numberOne), MathUtils.convertToDouble(numberTwo));
    }

}
