package com.ms.hrpayroll.services;

import com.ms.hrpayroll.entities.Payment;
import com.ms.hrpayroll.entities.Worker;
import com.ms.hrpayroll.feignclients.WorkerFeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    @CircuitBreaker(name = "payment", fallbackMethod = "getPaymentAlternative")
    public Payment getPayment(Long workerId, Integer days){
        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

    public Payment getPaymentAlternative(Long workerId, Integer days,  Throwable e){
        return new Payment("Brann", 400.0, days);
    }
}
