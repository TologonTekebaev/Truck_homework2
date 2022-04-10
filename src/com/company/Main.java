package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Truck[] trucks = {new Truck(1, "MAN", "", StateOfTrucks.BASE),
                new Truck(2, "BELAZ", "", StateOfTrucks.BASE),
                new Truck(3, "MAZ", "", StateOfTrucks.BASE)};

        Driver[] driversOfTruck = {new Driver(1, "Ulan", "driver-1"),
                new Driver(2, "Kuba", "driver-2"),
                new Driver(3, "Turat", "driver-3")};


        printTruck(trucks);
        printDriver(driversOfTruck);
        System.out.println("-----------------------------------------");
        while (true){
            System.out.println("Выберите один из грузовиков: ");
            int input = scanner.nextInt();
            scanner.nextLine();
            Driver.getInfo(trucks[input-1]);
            Service service = new Service();
            getInstruction();
            String action = scanner.nextLine();
            if (action.equals("1")) {
                service.changeDriver(trucks[input - 1], driversOfTruck[input - 1]);
            } else if (action.equals("2")) {
                service.startDriving(trucks[input - 1], driversOfTruck[input - 1]);
            } else if (action.equals("3")) {
                service.startRepair(trucks[input - 1], driversOfTruck[input - 1]);
            }
            printTruck(trucks);
            printDriver(driversOfTruck);

        }
    }
    public static void printTruck(Truck[] trucks){
        System.out.println("---------------------------TRUCK-------------------------------");
        System.out.println("      *       |       BUS       |     STATE     |     DRIVER   ");
        System.out.println("--------------|-----------------|---------------|--------------");
        for (int i = 0; i <trucks.length; i++) {
            System.out.println(trucks[i]);
        }
    }
    public static void printDriver(Driver[] drivers){
        System.out.println("----------------------DRIVER-----------------------");
        System.out.println("       *       |      DRIVER      |      BUS       ");
        System.out.println("---------------|------------------|-----------------");
        for (int d = 0; d < drivers.length; d++) {
            System.out.println(drivers[d]);
        }
    }
    public static void getInstruction() {
        System.out.println("Выберите -1- чтобы поменять водителя");
        System.out.println("Выберите -2- чтобы начать движение");
        System.out.println("Выберите -3- чтобы начать ремонтирование");
    }
}