package de.limago.rabbitmq.sender.events;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DemoEvent {
	
	@Builder.Default private String id = UUID.randomUUID().toString();
	@Builder.Default private LocalDateTime timestamp = LocalDateTime.now();
	private String vorname;
	private String nachname;

}
