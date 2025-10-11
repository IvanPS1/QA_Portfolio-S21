package com.tictactoe.datasource.repository;

import com.tictactoe.domain.model.Game;
import com.tictactoe.domain.model.Game.GameStatus;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.UUID;

public interface GameRepository extends CrudRepository<Game, UUID> {
    List<Game> findByStatus(GameStatus status);
    List<Game> findByPlayer1IdOrPlayer2Id(UUID player1Id, UUID player2Id);
    List<Game> findByStatusNot(GameStatus status);
}
