package com.company;

import controller.ControllerImpl;

import java.util.Scanner;

public class App {

    public void run() {
        ControllerImpl controller = new ControllerImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать!");
        System.out.println("0 - создание записи\n1 - добавление номера к текущей записи" +
                            "\n2 - следующая запись\n3 - предыдущая запись\n4 - сохранить как:\n");
        controller.load();
        controller.showAll();
        while (true) {
            System.out.println("--------------");
            switch (Integer.parseInt(scanner.nextLine())) {
                case 0: {
                    controller.createElement();
                    break;
                }
                case 1: {
                    controller.addNumber();
                    break;
                }
                case 2: {
                    controller.nextElement();
                    break;
                }
                case 3: {
                    controller.previousElement();
                    break;
                }
                case 4: {
                    controller.saveAs();
                    break;
                }
                default:
                    controller.save();
                    System.out.println("Завершение работы...");
                    return;
            }
            controller.showAll();
        }
    }
}
