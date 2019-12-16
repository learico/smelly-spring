package fr.formation.smellyspring.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.smellyspring.services.SmellyDateProviderService;

/**
 * Do not change anything in this file/class.
 */
@RestController
@RequestMapping("/smellyDate")
public class SmellyDateProviderController {

    private static final Logger LOGGER = LoggerFactory.getLogger("MY_LOGGER");
    private final SmellyDateProviderService service;

    protected SmellyDateProviderController(
	    @Qualifier("smellyDateTimeProviderServiceImpl") SmellyDateProviderService service) {
	this.service = service;
    }

    @GetMapping("/localDate")
    public LocalDate getLocalDate() {
	LOGGER.trace("Reached \"GET /localDate\"");
	LocalDate result = null;
	try {
	    result = service.getLocalDate();
	    LOGGER.trace("Returned from service.getLocalDate()");
	} catch (UnsupportedOperationException e) {
	    LOGGER.error("Could not get a local date");
	}
	LOGGER.trace("Returning local date=" + result);
	return result;
    }

    @GetMapping("/localDateTime")
    public LocalDateTime getLocalDateTime() {
	LOGGER.trace("Reached \"GET /localDateTime\"");
	LocalDateTime result = service.getLocalDateTime();
	LOGGER.trace("Returned from service.getLocalDateTime()");
	LOGGER.trace("Returning local date time=" + result);
	return result;
    }
}
