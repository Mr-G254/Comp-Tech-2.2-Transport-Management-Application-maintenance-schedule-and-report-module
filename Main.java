
public class Main {

    public static int add_vehicle(Vehicle[] vehicle_list,int count,String vehicle_model,String vehicle_reg,String vehicle_manufacture_date,Driver driver,Maintenance maintenance,Report report){
        Vehicle vehicle = new Vehicle(vehicle_model,vehicle_reg,vehicle_manufacture_date,driver,maintenance,report);
        vehicle_list[count] = vehicle;
        return ++count;
    }

    public static void get_vehicle_maintenance_record(Vehicle vehicle){
        Maintenance vehicle_Maintenance = vehicle.maintenance;
        vehicle_Maintenance.get_details();
    }

    public static void get_vehicle_report_record(Vehicle vehicle){
        Report vehicle_Report = vehicle.report;
        vehicle_Report.get_details();
    }

    public static void get_all_vehicles_and_their_details(Vehicle[] vehicles){
        int num = 1;
        for(int i = 0;i < vehicles.length;i++){
            if(vehicles[i] != null){
                System.out.println("------------- Vehicle "+num+" -------------");
                
                System.out.println("---------------------------------------");

                vehicles[i].get_details();
                System.out.println("");
                System.out.println("");
                num++;
            }else{
                break;
            }
        }
    }


    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[50];
        int count = 0;

        Driver driver = new Driver("Victor Wanyama", 32, "Male", 5);
        Maintenance maintenance = new Maintenance("01/01/2022", "Oil change", "10/01/2023");
        Report report = new Report("01/01/2022", "The vehicle is well maintained and has been driven for 32000KM");

        count = add_vehicle(vehicles,count,"ISUZU","KDA","01/01/2017",driver,maintenance,report);


        Driver driver2 = new Driver("Brian Wamalwa", 28, "Male", 2);
        Maintenance maintenance2 = new Maintenance("01/07/2022", "Tyre change", "10/07/2023");
        Report report2 = new Report("01/07/2022", "The vehicle is well maintained and has been driven for 2000KM");
        count = add_vehicle(vehicles,count,"Scania","KDE","01/07/2020",driver2,maintenance2,report2);
        get_all_vehicles_and_their_details(vehicles);
        
    }

}