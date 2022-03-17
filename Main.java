package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        printMessage();

        while (true) {
            int answer = Integer.parseInt(scanner.nextLine());
            if (answer != 0) {
                if (answer < 0 || answer > 25) {
                    System.out.println("Такого этажа нет в доме");

                }
                queue.offer(answer);
            } else {
                int waitDoorsInSeconds = 10;
                int waitMoveInSeconds = 5;
                int totalSeconds = 0;
                int previousFloor = -1;


                System.out.println("Лифт проследовал по следующим этажам: ");
                while (!queue.isEmpty()) {
                    System.out.print(" этаж - " + queue.poll() + " ->");
                    if(previousFloor != -1) {
                        totalSeconds += Math.abs(queue.poll() - previousFloor) * waitMoveInSeconds;
                        totalSeconds += waitDoorsInSeconds;

                    }
                    if (queue.isEmpty()) {
                        System.out.println(" этаж - 0");
                    }
                } System.out.println("Время затраченное лифтом на маршрут =: " + totalSeconds + " с.");

                break;
            }
        }
    }

    public static void printMessage() {
        System.out.println("Ожидаю ввода этажа: (для завершения введите 0)");
    }
}
