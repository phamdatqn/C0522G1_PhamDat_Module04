package calculator_management.service.impl;

import calculator_management.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    @Override
    public String calculator(String inputNumber1, String inputNumber2, String calculation) {

        try {
            double inputFirst = Double.parseDouble(inputNumber1);
            double inputSecond = Double.parseDouble(inputNumber2);
            double result = 0;

            switch (calculation) {
                case "addition":
                    result = inputFirst + inputSecond;
                    break;
                case "subtraction":
                    result = inputFirst - inputSecond;
                    break;
                case "multiplication":
                    result = inputFirst * inputSecond;
                    break;
                case "division":
                    if (inputSecond == 0) {
                        return "Không thể chia cho 0 !";
                    } else {
                        result = inputFirst / inputSecond;
                        break;
                    }
                default:
                    return "ERR";
            }
            return String.valueOf(result);
        } catch (NumberFormatException e) {
            return "Không được để trống !";
        }
    }
}
