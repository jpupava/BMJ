package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService{
    private List<Customer> customers;

    public CustomerService(){
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

    public List<Customer> getCustomers(String customerName){
        if(customerName==null){
            return this.customers;
        }
        List<Customer> filteredCustomers = new ArrayList<>();
        for (Customer customer : customers){
            if (customer.getLastName().equals(customerName)){
                filteredCustomers.add(customer);
            }
        }
        return filteredCustomers;
    }

    public void deleteCustomer(int customerId){
        this.customers.remove(this.customers.get(customerId));
    }

    public void updateCustomer(int customerId, Customer customer){
        this.customers.get(customerId).setId(customer.getId());
        this.customers.get(customerId).setFirstName(customer.getFirstName());
        this.customers.get(customerId).setLastName(customer.getLastName());
        this.customers.get(customerId).setEmail(customer.getEmail());
    }

    public Customer getCustomer(int customerId){
        return this.customers.get(customerId);
    }

    public Integer createCustomer(Customer customer){
        this.customers.add(customer);
        this.customers.get(customers.size()-1).setId((long) (customers.size() - 1));
        return this.customers.size()-1;
    }





}