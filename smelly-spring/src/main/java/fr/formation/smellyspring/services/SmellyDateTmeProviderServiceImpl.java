package fr.formation.smellyspring.services;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class SmellyDateTmeProviderServiceImpl implements SmellyDateProviderService {
	
	@Override
	public LocalDate getLocalDate() {
		throw new IllegalArgumentException("well, not supported!");
	}

	@Override
	public LocalDateTime getLocalDateTime() {
		return LocalDateTime.now();
	}

}
