package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    private List<Customer> customers;

    public Controller() {
        this.customers = initCustomer();

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
        return this.customers.get(customerId);
    }

    @GetMapping("/api/customers")
    public List<Customer> getCustomers(@RequestParam(required = false) String customerName){

        List<Customer> filteredCustomers = new ArrayList<>();
        for (Customer customer : customers){
            if (customer.getLastName().equals(customerName)){
                filteredCustomers.add(customer);
            }
        }
        System.out.println(customerName);
        if(customerName==null){
            return this.customers;
        }
        return filteredCustomers;

    }

    @PostMapping("/api/customers")
    public Integer createCustomer(@RequestBody Customer customer){
        this.customers.add(customer);
        this.customers.get(customers.size()-1).setId(Long.valueOf(customers.size()-1));
        return this.customers.size()-1;
    }

    @DeleteMapping("/api/customers/{customerId}")
    public void deleteCustomer(@PathVariable Integer customerId){
        this.customers.remove(this.customers.get(customerId));
    }

    @PutMapping("/api/customers/{customerId}")
    public void updateCustomer(@PathVariable Integer customerId, @RequestBody Customer customer){
        this.customers.get(customerId).setId(Long.valueOf(customerId));
        this.customers.get(customerId).setFirstName(customer.getFirstName());
        this.customers.get(customerId).setLastName(customer.getLastName());
        this.customers.get(customerId).setEmail(customer.getEmail());
    }

}
