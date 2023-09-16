package template_method_pattern;

public class Database {

    public static Customer getCustomerWithId(int id) {
        Customer c = new Customer();
        c.setName("김명준");
        return c;
    }

}
