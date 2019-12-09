package fr.formation.smellyspring.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SmellyUserInDto {

	@Size(min = 6, max = 255)
	private String usernames;

	@NotBlank
	@Size(min = 8, max = 12)
	private String password;

	public SmellyUserInDto(String username, String password) {
		this.usernames = username;
		this.password = password;
	}

	public String getUsername() {
		return usernames;
	}

	public void setUsername(String username) {
		this.usernames = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
