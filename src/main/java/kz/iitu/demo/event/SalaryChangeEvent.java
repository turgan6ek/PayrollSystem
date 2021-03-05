package kz.iitu.demo.event;

import kz.iitu.demo.entity.Employee;
import kz.iitu.demo.service.SalaryCalculatorService;
import kz.iitu.demo.service.SalaryCalculatorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class SalaryChangeEvent extends ApplicationEvent {

    Employee employee;
    public SalaryChangeEvent(Object source, Employee employee) {
        super(source);
        this.employee = employee;
    }

}
