package com.tictactoe.datasource.repository;
import com.tictactoe.domain.model.Game;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class GameRepository {
    private Map<UUID, Game> games = new HashMap<>();

    public Game save(Game game) {
        games.put(game.id, game);
        return game;
    }

    public Optional<Game> findById(UUID id) {
        return Optional.ofNullable(games.get(id));
    }
}
