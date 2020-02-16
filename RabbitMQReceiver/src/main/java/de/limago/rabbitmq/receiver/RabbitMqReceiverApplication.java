package de.limago.rabbitmq.receiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

import de.limago.rabbitmq.receiver.events.messaging.Channels;

@SpringBootApplication
@EnableBinding(Channels.class)
public class RabbitMqReceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqReceiverApplication.class, args);
	}

}
