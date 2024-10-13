import classes.Company;

public class app{
    public static void main(String[] args){
        Company.getInstance().setName("Ecim");
        System.out.println(Company.getInstance().getName());
    }
}