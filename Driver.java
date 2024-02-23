public class Driver {
    String name;
    int age;
    String gender;
    int  experience;

    public Driver(String name,int age,String gender,int experience){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.experience = experience;

    }

    public void get_details(){
        System.out.println("  Driver details  ");
        System.out.println("------------------");
        System.out.println("Name       : "+ name);
        System.out.println("Age        : "+ age+"yrs");
        System.out.println("Gender     : "+ gender);
        System.out.println("Experience : "+ experience+"yrs");
        System.out.println("");
    }
}
