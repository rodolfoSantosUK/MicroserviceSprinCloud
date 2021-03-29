package br.com.hr.hrpayroll;

import br.com.hr.hrpayroll.entities.Payments;
import br.com.hr.hrpayroll.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping( value = "/{workerId}/days/{days}")
    public ResponseEntity<Payments> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
        Payments payments = paymentService.getPayment(workerId, days);
        return ResponseEntity.ok(payments);

    }


}
