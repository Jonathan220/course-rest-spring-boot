package br.com.jonathan.course_rest_with_spring.service;

import br.com.jonathan.course_rest_with_spring.exception.UnsupportedMathOperationException;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    public Double sum(Double numberOne, Double numberTwo){
        return numberOne + numberTwo;
    }

    public Double subtraction(Double numberOne, Double numberTwo){
        return numberOne - numberTwo;
    }

    public Double multiplication(Double numberOne, Double numberTwo){
        return numberOne * numberTwo;
    }

    public Double division(Double numberOne, Double numberTwo){
        return numberOne / numberTwo;
    }

    public Double mean(Double numberOne, Double numberTwo){
        return (numberOne + numberTwo) / 2;
    }

    public Double squareRoot(Double number){
        return Math.sqrt(number);
    }
}
