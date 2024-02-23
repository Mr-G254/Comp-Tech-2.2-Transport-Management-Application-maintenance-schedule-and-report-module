public class Report {
    String report_date;
    String data;

    public Report(String report_date,String data){
        this.report_date = report_date;
        this.data = data;
    }

    public void get_details(){
        System.out.println("  Report details  ");
        System.out.println("------------------");
        System.out.println("Report date : "+ report_date);
        System.out.println("Data        : "+ data);
        System.out.println("");
    }
}
