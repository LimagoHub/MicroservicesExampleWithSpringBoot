package de.limago.rabbitmq.receiver.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.limago.rabbitmq.receiver.events.DemoEvent;

@RestController
@RequestMapping("/demo")
public class DemoRestController {

	
	private final List<DemoEvent> events;

	public DemoRestController(List<DemoEvent> events) {
		this.events = events;
	}
	
	@GetMapping(path = "/events", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DemoEvent> getEvents() {
		return events;
	}
	
}
