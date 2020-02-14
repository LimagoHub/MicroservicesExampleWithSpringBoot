package de.limago.atom.services.models;

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
public class TryModel {
	
	@Builder.Default private String id = UUID.randomUUID().toString();
	@Builder.Default private String vorname = UUID.randomUUID().toString();
	@Builder.Default private String nachname = UUID.randomUUID().toString();
	@Builder.Default private LocalDateTime timestamp = LocalDateTime.now();

}
