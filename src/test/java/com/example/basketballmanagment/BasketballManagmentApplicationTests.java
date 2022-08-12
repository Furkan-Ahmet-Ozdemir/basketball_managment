package com.example.basketballmanagment;

import com.example.basketballmanagment.dto.PlayerDto;
import com.example.basketballmanagment.enums.Position;
import com.example.basketballmanagment.model.Player;
import com.example.basketballmanagment.repository.PlayerRepository;
import com.example.basketballmanagment.service.PlayerService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class BasketballManagmentApplicationTests {

    @InjectMocks
    private PlayerService playerService;
    @Mock
    private PlayerRepository playerRepository;
    @Mock
    private TestEntityManager entityManager;

    @Test
    @Order(0)
    public void testPlayerAdd() throws IOException {

        PlayerDto playerDto = new PlayerDto();
        playerDto.setName("Mehmet");
        playerDto.setSurname("C");
        playerDto.setPosition(Position.C);
        Player playerMo = mock(Player.class);

        when(playerMo.getId()).thenReturn(1L);
        when(playerRepository.save(ArgumentMatchers.any(Player.class))).thenReturn(playerMo);
        Player player = playerService.dtoToEntity(playerDto);

        assertEquals(player.getName(), playerDto.getName());
        assertEquals(player.getSurname(), playerDto.getSurname());
    }

    @Test
    @Order(1)
    public void testPlayerDelete() throws IOException {

        PlayerDto playerDto = new PlayerDto();
        playerDto.setName("Mehmet");
        playerDto.setSurname("C");
        playerDto.setPosition(Position.C);
        Player playerMo = mock(Player.class);

        when(playerMo.getId()).thenReturn(1L);
        when(playerRepository.save(ArgumentMatchers.any(Player.class))).thenReturn(playerMo);
        Player player = playerService.dtoToEntity(playerDto);
        Player existAnimal = entityManager.find(Player.class, player.getId());

        assertThat(existAnimal).isNull();
    }

    @Test
    @Order(2)
    public void testListPlayers() throws IOException {

        PlayerDto playerDto = new PlayerDto();
        playerDto.setName("Mehmet");
        playerDto.setSurname("C");
        playerDto.setPosition(Position.C);
        Player playerMo = mock(Player.class);

        when(playerMo.getId()).thenReturn(1L);
        when(playerRepository.save(ArgumentMatchers.any(Player.class))).thenReturn(playerMo);
        Player player = playerService.dtoToEntity(playerDto);

        when(playerRepository.findAll()).thenReturn(Collections.singletonList(player));
        List<Player> playerList = playerRepository.findAll();

        assertEquals(playerList.size(), 1);
    }


}
