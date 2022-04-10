package com.company;

import java.util.Random;

public class Service implements TruckService{
    @Override
    public void changeDriver(Truck truck, Driver driver) {
        if(truck.getState().equals(StateOfTrucks.BASE)){
            truck.setDriver(driver.getDriver());
            driver.setTruck(truck.getName());
        }else if(truck.getState().equals(StateOfTrucks.ROUTE)){
            System.out.println("Водитель уже в пути");
        }else {
            System.out.println("Вы не можете поменять водителя");
        }
    }


    @Override
    public void startDriving(Truck truck, Driver driver) {
        if(truck.getState().equals(StateOfTrucks.BASE)){
            if (!truck.getDriver().equals("")){
                truck.setState(StateOfTrucks.BASE);
                System.out.println("Водитель успешно начал свой путь");
             }else{
                System.out.println("Здесь нет водителя");
            }
        }else if(truck.getState().equals(StateOfTrucks.ROUTE)){
            System.out.println("Водитель уже в пути!");
        }else{
            Random random = new Random();
            int road = random.nextInt();
            if ( road == 0){
                truck.setState(StateOfTrucks.ROUTE);
                System.out.println("Грузовик уже в пути");
            }else {
                truck.setState(StateOfTrucks.BASE);
                System.out.println("Грузовик на базе");
            }
        }
    }
    @Override
    public void startRepair(Truck truck, Driver driver) {
        if (truck.getState().equals(StateOfTrucks.BASE)){
            truck.setState(StateOfTrucks.REPAIR);
            System.out.println("Грузовик находится в СТО");
        }else if (truck.getState().equals(StateOfTrucks.ROUTE)){
        truck.setState(StateOfTrucks.REPAIR);
    }else {
            System.out.println("Грузовик в ремонте");
        }
    }
}

