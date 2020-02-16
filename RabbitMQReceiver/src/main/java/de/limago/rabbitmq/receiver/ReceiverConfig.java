package de.limago.rabbitmq.receiver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.limago.rabbitmq.receiver.events.DemoEvent;

@Configuration
public class ReceiverConfig {
	
	
	@Bean
	public List<DemoEvent> createEventList() {
		return new ArrayList<>();
	}

}
