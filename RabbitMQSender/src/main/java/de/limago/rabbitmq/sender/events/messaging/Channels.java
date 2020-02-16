package de.limago.rabbitmq.sender.events.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Channels {
	
	@Output
	MessageChannel demoMessageOut();


}
