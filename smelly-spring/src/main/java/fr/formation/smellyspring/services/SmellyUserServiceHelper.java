package fr.formation.smellyspring.services;

import fr.formation.smellyspring.dtos.SmellyUserInDto;
import fr.formation.smellyspring.dtos.SmellyUserOutDto;
import fr.formation.smellyspring.entities.SmellyUser;

class SmellyUserServiceHelper {

    static SmellyUser convert(SmellyUserInDto dto) {
	SmellyUser entity = new SmellyUser();
	entity.setUsername(dto.getUsername());
	entity.setPassword(dto.getPassword());
	return entity;
    }

    static SmellyUserOutDto convert(SmellyUser entity) {
	return new SmellyUserOutDto(entity.getId(), entity.getUsername());
    }
}
