package com.example.assignment1;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<String> inputList; // List to hold calculator input

    public Calculator() {
        inputList = new ArrayList<>();
    }

    public void push(String value) {
        inputList.add(value);
    }

    public int calculate() {
        if (inputList.isEmpty())
            return 0; // or throw an exception

        int result = Integer.parseInt(inputList.get(0)); // set the initial result

        for (int i = 1; i < inputList.size(); i += 2) {
            String operator = inputList.get(i);
            int operand = Integer.parseInt(inputList.get(i + 1));

            if (operator.equals("+")) {
                result += operand;
            } else if (operator.equals("-")) {
                result -= operand;
            } else if (operator.equals("*")) {
                result *= operand;
            } else if (operator.equals("/")) {
                if (operand != 0) {
                    result /= operand;
                } else {
                    // Handle division by zero
                    return 0; // or throw an exception
                }
            }
        }
        return result;
    }

    public void clear() {
        inputList.clear();
    }

    public String getDisplayOperation() {
        StringBuilder displayValue = new StringBuilder();
        for (String value : inputList) {
            displayValue.append(value).append(" ");
        }
        return displayValue.toString();
    }
}
