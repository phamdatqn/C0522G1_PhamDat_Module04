package customer_management.controller;

import customer_management.dto.CustomerDto;
import customer_management.model.Customer;
import customer_management.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerControllerRestfull {

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("")
    public ResponseEntity<List<Customer>> home() {
        List<Customer> customerList = iCustomerService.findAll();
        if (customerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity createCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        iCustomerService.save(customer);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable int id) {
        Customer customer = iCustomerService.findById(id).get();
        if (customer == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            iCustomerService.delete(id);
            return new ResponseEntity(customer, HttpStatus.OK);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCustomer(@PathVariable int id, @RequestBody CustomerDto customerDto) {
        Customer findCustomer = iCustomerService.findById(id).get();
        if (findCustomer == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            findCustomer.setName(customerDto.getName());
            findCustomer.setIdCard(customerDto.getIdCard());
            findCustomer.setAddress(customerDto.getAddress());
            iCustomerService.save(findCustomer);
            return new ResponseEntity(findCustomer, HttpStatus.OK);
        }
    }
}
