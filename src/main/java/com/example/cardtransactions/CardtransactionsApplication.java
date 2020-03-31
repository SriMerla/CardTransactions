package com.example.cardtransactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.context.ApplicationContext;
import com.example.service.CardTransactionService;
import com.example.springjms.Producer;

@ComponentScan(basePackages = "com.example")
@SpringBootApplication(exclude = ActiveMQAutoConfiguration.class)
@EnableJms
public class CardtransactionsApplication {
	
	@Autowired
	CardTransactionService cardTransactionService;
	
	@Autowired
	Producer producer;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CardtransactionsApplication.class, args);
		
		System.out.println("From Main Method");
		CardTransactionService cardTransactionService = context.getBean(CardTransactionService.class);
      //  cardTransactionService.getTransactions();
		cardTransactionService.maxSno();
		
        
        

        
	}

}
