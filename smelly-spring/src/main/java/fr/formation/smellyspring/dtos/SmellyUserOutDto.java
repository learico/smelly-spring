package fr.formation.smellyspring.dtos;

public class SmellyUserOutDto {

	private Long id;

	private String username;

	public SmellyUserOutDto(Long id, String username) {
		id = this.id;
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public String toString() {
		return "{id=" + id + ", username=" + username + "}";
	}

}
