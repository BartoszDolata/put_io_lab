package pl.put.cb.api.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.cb.dao.CustomersDAO;
import pl.put.cb.model.Customer;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/customer_cards")
public class CustomerCardsController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerCardsController.class);
    private List<Customer> customers = CustomersDAO.getInstance().getCustomers();


    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Integer> get(@RequestParam(value="threshold", defaultValue="1.0") Double threshold) {
        List<Integer> customerIds = new ArrayList<Integer>();
        Double avr = averageSpendings();
        for (Customer customer : customers){
            if (avr > 0.0 &&
                    customer.getSpendings() / avr >= threshold){
                customerIds.add(customer.getId());
                logger.debug(customer.getId()+"");
            }
        }
        return customerIds;
    }

    private Double averageSpendings() {
        Double result = 0.0;
        if (CustomersDAO.getInstance().getCustomers().isEmpty()) return result;

        for (Customer customer : customers){
            result += customer.getSpendings();
        }

        return result / CustomersDAO.getInstance().getCustomers().size();
    }


}


