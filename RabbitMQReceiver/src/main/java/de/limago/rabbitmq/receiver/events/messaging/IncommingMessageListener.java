package de.limago.rabbitmq.receiver.events.messaging;

import java.util.List;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import de.limago.rabbitmq.receiver.events.DemoEvent;

@Component
public class IncommingMessageListener {

	private final List<DemoEvent> events;
	
	
	
	public IncommingMessageListener(List<DemoEvent> events) {
		
		this.events = events;
	}



	@StreamListener(Channels.DEMO_EVENT_IN)
	public void receiveCreditApplicationEnteredEvent(@Payload DemoEvent event) {
		events.add(event);
		System.out.println("Event received: " + event);
	}
	
}
