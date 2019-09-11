package at.nodify.demo;

import at.nodify.demo.model.Customer;
import at.nodify.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public Iterable<Customer> customers() {
        return this.customerService.customers();
    }


    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public Customer saveCustomer(Customer customer) {
        this.customerService.saveCustomer(customer);
        return customer;
    }
}