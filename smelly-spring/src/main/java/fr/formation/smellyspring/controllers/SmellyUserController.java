package fr.formation.smellyspring.controllers;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.smellyspring.dtos.SmellyUserInDto;
import fr.formation.smellyspring.dtos.SmellyUserOutDto;
import fr.formation.smellyspring.services.SmellyUserService;

/**
 * Do not change anything in this file/class.
 */
@RestController
@RequestMapping("/smellyUser")
public class SmellyUserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SmellyUserController.class);
    private final SmellyUserService service;

    protected SmellyUserController(SmellyUserService service) {
	this.service = service;
    }

    @GetMapping("/string")
    public String string() {
	LOGGER.debug("Reached \"GET /string\"");
	LOGGER.debug("Returning String=Hello smelly user!");
	return "Hello smelly user!";
    }

    @GetMapping("/dto")
    public SmellyUserOutDto dto() {
	LOGGER.debug("Reached \"GET /dto\"");
	SmellyUserOutDto result = new SmellyUserOutDto(null, "Hello smelly user!");
	LOGGER.debug("Returning dto=" + result);
	return result;
    }

    @GetMapping("/service")
    public SmellyUserOutDto service() {
	LOGGER.debug("Reached \"GET /service\"");
	SmellyUserOutDto result = service.getSmellyUserOutDto();
	LOGGER.debug("Returned from service.getSmellyUserOutDto()");
	LOGGER.debug("Returning dto=" + result);
	return result;
    }

    @PostMapping
    public void create(@Valid @RequestBody SmellyUserInDto dto) {
	LOGGER.debug("Reached \"POST /\"");
	LOGGER.debug("Verifying something with obscur code...");
	something(dto);
	LOGGER.debug("Something verified!");
	SmellyUserOutDto result = service.create(dto);
	LOGGER.debug("Returned from service.create(SmellyUserInDto)");
	LOGGER.debug("Created smelly user with id 1L? Result=" + (result.getId().equals(1L)));
	LOGGER.debug("Returning... void :)");
    }

    private static void something(SmellyUserInDto dto) {
	try {
	    if (!dto.getClass().getDeclaredField("username").isAnnotationPresent(NotBlank.class)) {
		throw new IllegalArgumentException("Stranger Things");
	    }
	} catch (NoSuchFieldException | SecurityException e) {
	    throw new IllegalArgumentException("Stranger Things", e);
	}
    }
}
