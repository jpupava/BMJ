package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
    /*
    private List<CustomerDto> customerDtos;

     */

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    /*
    private List<CustomerDto> initCustomer() {
        List<CustomerDto> customerDtos = new ArrayList<>();
        CustomerDto customerDto1 = new CustomerDto();
        customerDto1.setId(0L);
        customerDto1.setFirstName("Janko");
        customerDto1.setLastName("Hraško");
        customerDto1.setEmail("jankohrasko@gmail.com");
        customerDtos.add(customerDto1);

        CustomerDto customerDto2 = new CustomerDto();
        customerDto2.setId(1L);
        customerDto2.setFirstName("Jožko");
        customerDto2.setLastName("Mrkvička");
        customerDto2.setEmail("jozkomrkvicka@gmail.com");
        customerDtos.add(customerDto2);

        return customerDtos;
    }

     */

    @GetMapping("/api/customers/{customerId}")
    public CustomerDto getCustomer(@PathVariable Integer customerId){
        return customerService.getCustomer(customerId);
    }

    @GetMapping("/api/customers")
    public List<CustomerDto> getCustomers(@RequestParam(required = false) String customerName){
        return customerService.getCustomers(customerName);
    }

    @PostMapping("/api/customers")
    public Long createCustomer(@RequestBody CustomerDto customerDto){
        return customerService.createCustomer(customerDto);
    }

    @DeleteMapping("/api/customers/{customerId}")
    public void deleteCustomer(@PathVariable Integer customerId){
        customerService.deleteCustomer(customerId);
    }

    @PutMapping("/api/customers/{customerId}")
    public void updateCustomer(@PathVariable int customerId, @RequestBody CustomerDto customerDto){
        customerService.updateCustomer(customerId, customerDto);
    }
}