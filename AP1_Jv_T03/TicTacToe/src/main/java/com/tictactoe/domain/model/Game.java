package com.tictactoe.domain.model;
import java.util.UUID;

public class Game {
    public UUID id;
    public int[][] board = new int[3][3];
    public String status = "a game is underway";
    public String currentPlayer = "X";

    public Game() { this.id = UUID.randomUUID(); }
}
