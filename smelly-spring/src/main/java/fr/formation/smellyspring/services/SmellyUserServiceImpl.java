package fr.formation.smellyspring.services;

import javax.validation.Valid;

import fr.formation.smellyspring.dtos.SmellyUserInDto;
import fr.formation.smellyspring.dtos.SmellyUserOutDto;
import fr.formation.smellyspring.entities.SmellyUser;
import fr.formation.smellyspring.repositories.SmellyUserRepository;

public class SmellyUserServiceImpl implements SmellyUserService {

	private SmellyUserRepository repo;

	@Override
	public SmellyUserOutDto getSmellyUserOutDto() {
		return new SmellyUserOutDto(null, "Hello smelly user!");
	}

	@Override
	public SmellyUserOutDto create(@Valid SmellyUserInDto dto) {
		SmellyUser entity = SmellyUserServiceHelper.convert(dto);
		repo.save(entity);
		return SmellyUserServiceHelper.convert(entity);
	}
}
