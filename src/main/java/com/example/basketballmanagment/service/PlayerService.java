package com.example.basketballmanagment.service;

import com.example.basketballmanagment.dto.PlayerDto;
import com.example.basketballmanagment.exception.MaximumPlayerException;
import com.example.basketballmanagment.exception.PlayerNotFoundException;
import com.example.basketballmanagment.model.Player;
import com.example.basketballmanagment.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	private final int MAX_PLAYER_NUMBER = 12;

	public Player savePlayer(PlayerDto playerDto) {
		
		if (findAllPlayers().size()< MAX_PLAYER_NUMBER) {
			return playerRepository.save(dtoToEntity(playerDto));
		}else {
			throw new MaximumPlayerException("You have reached the maximum number of players");
		}
	}

	public List<Player> findAllPlayers(){

		return playerRepository.findAll();
	}

	public Player deletePlayer(Long id) {

		Player player = playerRepository.findById(id)
								.orElseThrow(() -> new PlayerNotFoundException("Player not found"));
		playerRepository.delete(player);
		return player;
	}

	public Player dtoToEntity(PlayerDto playerDto) {

		Player player = new Player();
		player.setName(playerDto.getName());
		player.setSurname(playerDto.getSurname());
		player.setPosition(playerDto.getPosition());
		return player;
	}

	
}
