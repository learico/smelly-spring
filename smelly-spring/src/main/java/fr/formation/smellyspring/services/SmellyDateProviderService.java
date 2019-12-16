package fr.formation.smellyspring.services;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface SmellyDateProviderService {

    LocalDate getLocalDate();

    LocalDateTime getLocalDateTime();
}
