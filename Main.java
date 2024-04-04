
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
        new TransportManagementSystemGUI();
        
    }

}