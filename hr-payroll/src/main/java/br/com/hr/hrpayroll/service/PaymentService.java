package br.com.hr.hrpayroll.service;

import br.com.hr.hrpayroll.entities.Payments;
import br.com.hr.hrpayroll.entities.Worker;
import br.com.hr.hrpayroll.feignClients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payments getPayment (long workerId, int days) {

        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payments(worker.getName(), worker.getDailyIncome(), days);
    }

}
