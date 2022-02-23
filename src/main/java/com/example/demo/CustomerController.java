package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
    /*CUSTOMER*/
    private List<Customer> customers;

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    private List<Customer> initCustomer() {
        List<Customer> customers = new ArrayList<>();
        Customer customer1 = new Customer();
        customer1.setId(0L);
        customer1.setFirstName("Janko");
        customer1.setLastName("Hraško");
        customer1.setEmail("jankohrasko@gmail.com");
        customers.add(customer1);

        Customer customer2 = new Customer();
        customer2.setId(1L);
        customer2.setFirstName("Jožko");
        customer2.setLastName("Mrkvička");
        customer2.setEmail("jozkomrkvicka@gmail.com");
        customers.add(customer2);

        return customers;
    }

    @GetMapping("/api/customers/{customerId}")
    public Customer getCustomer(@PathVariable Integer customerId){
        return customerService.getCustomer(customerId);
    }

    @GetMapping("/api/customers")
    public List<Customer> getCustomers(@RequestParam(required = false) String customerName){
        return customerService.getCustomers(customerName);
    }

    @PostMapping("/api/customers")
    public Integer createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @DeleteMapping("/api/customers/{customerId}")
    public void deleteCustomer(@PathVariable Integer customerId){
        customerService.deleteCustomer(customerId);
    }

    @PutMapping("/api/customers/{customerId}")
    public void updateCustomer(@PathVariable int customerId, @RequestBody Customer customer){
        customerService.updateCustomer(customerId, customer);
    }
}
