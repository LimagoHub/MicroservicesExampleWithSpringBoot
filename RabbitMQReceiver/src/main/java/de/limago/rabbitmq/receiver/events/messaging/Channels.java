package de.limago.rabbitmq.receiver.events.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Channels {
	
		String DEMO_EVENT_IN = "demoMessageIn";
		

	
		@Input
		SubscribableChannel demoMessageIn();
	


}
