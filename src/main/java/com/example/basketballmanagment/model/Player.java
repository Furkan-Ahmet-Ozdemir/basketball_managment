package com.example.basketballmanagment.model;

import com.example.basketballmanagment.enums.Position;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "player")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(length = 60, name = "name")
    private String name;

	@Column(length = 60, name = "surname")
    private String surname;

	@Enumerated(EnumType.STRING)
	@Column(name = "position")
	private Position position;
}