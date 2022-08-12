package com.example.basketballmanagment.resolver;

import com.example.basketballmanagment.dto.PlayerDto;
import com.example.basketballmanagment.model.Player;
import com.example.basketballmanagment.service.PlayerService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver{

	@Autowired
	private PlayerService playerService;
	
	public Player addPlayer(PlayerDto playerDto) {
		
		return playerService.savePlayer(playerDto);
	}
	
	public Player deletePlayer(Long id) {
		
		return playerService.deletePlayer(id);
	}
}
