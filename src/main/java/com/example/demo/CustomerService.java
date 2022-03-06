package com.example.demo;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    /*
    private List<CustomerDto> customerDtos;
    */

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    private static CustomerDto mapToCustomerDto(CustomerEntity customerEntity){
        CustomerDto customerDto = new CustomerDto();

        customerDto.setFirstName(customerEntity.getFirstName());
        customerDto.setLastName(customerEntity.getLastName());
        customerDto.setEmail(customerEntity.getEmail());

        return customerDto;
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
    @Transactional
    public List<CustomerDto> getCustomers(String customerName){
        List<CustomerDto> ret = new LinkedList<>();
        for (CustomerEntity c1 : customerRepository.findAll()){
            CustomerDto c2 = mapToCustomerDto(c1);
            ret.add(c2);
        }
        return ret;
        /*
        if(customerName==null){
            return this.customerDtos;
        }
        List<CustomerDto> filteredCustomerDtos = new ArrayList<>();
        for (CustomerDto customerDto : customerDtos){
            if (customerDto.getLastName().equals(customerName)){
                filteredCustomerDtos.add(customerDto);
            }
        }
        return filteredCustomerDtos;
        */
    }
    @Transactional
    public void deleteCustomer(int customerId){
        Optional<CustomerEntity> byId =customerRepository.findById((long)customerId);
        if(byId.isPresent()){
            customerRepository.delete(byId.get());
        }

        /*
        this.customerDtos.remove(this.customerDtos.get(customerId));

         */
    }

    @Transactional
    public void updateCustomer(int customerId, CustomerDto customerDto){
        Optional<CustomerEntity> byId = customerRepository.findById((long)customerId);
        if(byId.isPresent()){
            byId.get().setFirstName(customerDto.getFirstName());
            byId.get().setLastName(customerDto.getLastName());
            byId.get().setEmail(customerDto.getEmail());
        }

        /*
        this.customerDtos.get(customerId).setId(customerDto.getId());
        this.customerDtos.get(customerId).setFirstName(customerDto.getFirstName());
        this.customerDtos.get(customerId).setLastName(customerDto.getLastName());
        this.customerDtos.get(customerId).setEmail(customerDto.getEmail());

         */
    }

    @Transactional
    public CustomerDto getCustomer(int customerId){
        Optional<CustomerEntity> byId = customerRepository.findById((long) customerId);
        if (byId.isPresent()){
            return mapToCustomerDto(byId.get());
        }
        return null;
        /*
        return this.customerDtos.get(customerId);

         */
    }

    @Transactional
    public Long createCustomer(CustomerDto customerDto){
        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setFirstName(customerDto.getFirstName());
        customerEntity.setLastName(customerDto.getLastName());
        customerEntity.setEmail(customerDto.getEmail());

        this.customerRepository.save(customerEntity);
        return customerEntity.getId();

        /*
        this.customerDtos.add(customerDto);
        this.customerDtos.get(customerDtos.size()-1).setId((long) (customerDtos.size() - 1));
        return this.customerDtos.size()-1;

         */
    }





}