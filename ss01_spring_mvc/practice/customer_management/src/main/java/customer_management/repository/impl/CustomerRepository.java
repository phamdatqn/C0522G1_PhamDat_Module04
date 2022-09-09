package customer_management.repository.impl;

import customer_management.model.Customer;
import customer_management.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {
    private static List<Customer> customerList=new ArrayList<>();
    static {
        customerList.add(new Customer(0,"T","T@gmaiil.com","Đà nẵng"));
        customerList.add(new Customer(1,"Trần T","TT@gmaiil.com","Đà nẵng"));
        customerList.add(new Customer(2,"Nguyễn Văn A","NA@gmaiil.com","Hồ chí mình"));
        customerList.add(new Customer(3,"Nguyễn Văn B","NB@gmaiil.com","Đà nẵng"));
        customerList.add(new Customer(4,"Trần C","C@gmaiil.com","Quảng Nam"));
    }
    @Override
    public List<Customer> displayAll() {
        return customerList;
    }
}
