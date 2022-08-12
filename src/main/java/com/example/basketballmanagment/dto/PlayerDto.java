package com.example.basketballmanagment.dto;

import com.example.basketballmanagment.enums.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlayerDto {

	@NotBlank
	private String name;
	@NotBlank
	private String surname;
	@NotBlank
	private Position position;
}
