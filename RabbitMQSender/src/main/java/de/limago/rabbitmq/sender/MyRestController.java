package de.limago.rabbitmq.sender;

import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.limago.rabbitmq.sender.events.DemoEvent;
import de.limago.rabbitmq.sender.events.messaging.Channels;

@RestController
@RequestMapping("/demo")
public class MyRestController {
	
	private final Channels channels;
	
	

	public MyRestController(final Channels channels) {
		this.channels = channels;
	}



	@PostMapping("/fireEvent")
	public void fireEvent() {
		DemoEvent event = DemoEvent.builder().vorname("John").nachname("Doe").build();
		channels.demoMessageOut().send(MessageBuilder.withPayload(event).build());
		System.out.println("Demoevent fired: " + event);
	}
	

	@GetMapping("/version")
	public String getVersion() {
		return "1.0.0";
	}

}
