package fr.formation.smellyspring.services;

import javax.validation.Valid;

import fr.formation.smellyspring.dtos.SmellyUserInDto;
import fr.formation.smellyspring.dtos.SmellyUserOutDto;

public interface SmellyUserService {

    SmellyUserOutDto getSmellyUserOutDto();

    SmellyUserOutDto create(@Valid SmellyUserInDto dto);
}
