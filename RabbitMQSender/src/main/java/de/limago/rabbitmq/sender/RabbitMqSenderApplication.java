package de.limago.rabbitmq.sender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

import de.limago.rabbitmq.sender.events.messaging.Channels;

@SpringBootApplication
@EnableBinding(Channels.class)
public class RabbitMqSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqSenderApplication.class, args);
	}

}
