package at.nodify.demo.service;

import at.nodify.demo.model.Customer;
import at.nodify.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional(readOnly = true)
    public Iterable<Customer> customers() {
        return customerRepository.findAll();
    }

    @Transactional
    public void saveCustomer(Customer customer) {
        this.customerRepository.save(customer);
    }

    public boolean isCustomerValid(Customer customer) {
        if (customer.getEmail().isEmpty() || customer.getName().isEmpty()) {
            return false;
        }
        return true;
    }
}
