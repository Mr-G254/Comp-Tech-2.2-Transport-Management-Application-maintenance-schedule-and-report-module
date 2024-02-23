public class Vehicle {
    String model;
    String registration_number;
    String manufacture_date;
    Driver driver;
    Maintenance maintenance;
    Report report;

    public Vehicle(String model,String reg,String manufacture_date,Driver driver,Maintenance maintenance,Report report){
        this.model = model;
        this.registration_number = reg;
        this.manufacture_date = manufacture_date;
        this.driver = driver;
        this.maintenance = maintenance;
        this.report = report;
    }

    public void get_details(){
        System.out.println("  Vehicle details  ");
        System.out.println("-------------------");
        System.out.println("Model               : "+ model);
        System.out.println("Registration number : "+ registration_number);
        System.out.println("Manufacture date    : "+ manufacture_date);
        System.out.println("");
        driver.get_details();
        maintenance.get_details();
        report.get_details();
    }
}
