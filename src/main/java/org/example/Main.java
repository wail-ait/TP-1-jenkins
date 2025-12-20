package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        int sum = calculator.add(10, 5);
        int difference = calculator.subtract(10, 5);

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);

        //TIP To <b>Debug</b> code, press <shortcut actionId="Debug"/> or
        // click the <icon src="AllIcons.Actions.StartDebugger"/> icon in the gutter.

    }
}