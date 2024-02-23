public class Maintenance {
    String previous_maintenance_date;
    String maintenance_type;
    String scheduled_maintenance_date;

    public Maintenance(String prev_date,String maint_type,String scheduled_date){
        this.previous_maintenance_date = prev_date;
        this.maintenance_type = maint_type;
        this.scheduled_maintenance_date = scheduled_date;
    }

    public void get_details(){
        System.out.println("    Maintenance details    ");
        System.out.println("---------------------------");
        System.out.println("Previous maintenance date  : "+ previous_maintenance_date);
        System.out.println("Maintenance type           : "+ maintenance_type);
        System.out.println("Scheduled maintenance date : "+ scheduled_maintenance_date);
        System.out.println("");
    }

    public void schedule_maintenance_date(String date){
        this.scheduled_maintenance_date = date;
    }

    public void change_maintenance_type(String maintenance_type){
        this.maintenance_type = maintenance_type;
    }

    public void carry_out_scheduled_maintenance(){
        if(this.scheduled_maintenance_date != "None" || this.scheduled_maintenance_date != null){
            this.previous_maintenance_date = this.scheduled_maintenance_date;
            this.scheduled_maintenance_date = "None";
        }else{
            System.out.println("There is no scheduled maintenance");
        }
        
    }
}
