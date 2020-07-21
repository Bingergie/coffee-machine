package me.hebing.coffeemachine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);

    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;

    public static void main(String[] arg) {
        label:
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = scanner.next();
            switch (action) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    printMachineState();
                    break;
                case "exit":
                    break label;
                default:
                    break;
            }
        }
    }

    public static void printMachineState() {
        System.out.println("The coffee machine has: ");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
        System.out.println();
    }

    public static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String buyOption = scanner.next();
        if (buyOption.equals("1") || buyOption.equals("2") || buyOption.equals("3")) {
            if (!isOutOfResources(buyOption)) {
                System.out.println("I have enough resources, making you coffee!");
                switch (buyOption) {
                    case "1":
                        cups -= 1;
                        water -= 250;
                        beans -= 16;
                        money += 4;
                        break;
                    case "2":
                        cups -= 1;
                        water -= 350;
                        milk -= 75;
                        beans -= 20;
                        money += 7;
                        break;
                    case "3":
                        cups -= 1;
                        water -= 200;
                        milk -= 100;
                        beans -= 12;
                        money += 6;
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.println();
    }

    public static void fill() {
        System.out.println("Write how many ml of water do you want to add: ");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        cups += scanner.nextInt();
        System.out.println();
    }

    public static void take() {
        System.out.println("I gave you $" + money);
        money -= money;
        System.out.println();
    }

    public static boolean isOutOfResources(String option) {
        if (cups - 1 < 0) {
            System.out.println("Sorry, not enough disposable cups!");
            return true;
        } else {
            switch (option) {
                case "1":
                    if (water - 250 < 0) {
                        System.out.println("Sorry, not enough water!");
                        return true;
                    }
                    if (beans - 16 < 0) {
                        System.out.println("Sorry, not enough coffee beans!");
                        return true;
                    }
                    break;
                case "2":
                    if (water - 350 < 0) {
                        System.out.println("Sorry, not enough water!");
                        return true;
                    }
                    if (milk - 75 < 0) {
                        System.out.println("Sorry, not enough milk!");
                        return true;
                    }
                    if (beans - 20 < 0) {
                        System.out.println("Sorry, not enough coffee beans!");
                        return true;
                    }
                    break;
                case "3":
                    if (water - 200 < 0) {
                        System.out.println("Sorry, not enough water!");
                        return true;
                    }
                    if (milk - 100 < 0) {
                        System.out.println("Sorry, not enough milk!");
                        return true;
                    }
                    if (beans - 12 < 0) {
                        System.out.println("Sorry, not enough coffee beans!");
                        return true;
                    }
                    break;
                default:
                    break;
            }
        }
        return false;
    }
}