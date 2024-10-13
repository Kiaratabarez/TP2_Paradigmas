package people;

public class EmployeeFactory {
    public static Employee createEmployee(String name, String dni, String phone, String email, String rol){
        switch (rol) {
            case "Designer":
                return createDesigner(name, dni, phone, email);
            case "Developer":
                return createDeveloper(name, dni, phone, email);
            case "Tester":
                return createTester(name, dni, phone, email);
            default:
                return null;
        }
    }
    
    private static Employee createDesigner(String name, String dni, String phone, String email){
        return new Designer(name, dni, phone, email);
    }

    private static Employee createDeveloper(String name, String dni, String phone, String email){
        return new Developer(name, dni, phone, email);
    }


    private static Employee createTester(String name, String dni, String phone, String email){
        return new Tester(name, dni, phone, email);
    }
}
