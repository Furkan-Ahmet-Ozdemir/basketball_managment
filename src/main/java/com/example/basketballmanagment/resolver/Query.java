package com.example.basketballmanagment.resolver;

import com.example.basketballmanagment.model.Player;
import com.example.basketballmanagment.service.PlayerService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class Query implements GraphQLQueryResolver{

	@Autowired
	private PlayerService playerService;
	
	public List<Player> getAllPlayers(){

		return playerService.findAllPlayers();
	}
}
