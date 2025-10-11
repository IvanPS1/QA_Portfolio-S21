/*package com.tictactoe.domain.model;
import java.util.UUID;

public class Game {
    public UUID id;
    public int[][] board = new int[3][3];
    public String status = "a game is underway";
    public String currentPlayer = "X";

    public Game() { this.id = UUID.randomUUID(); }
}*/

package com.tictactoe.domain.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(length = 20)
    private String board;

    @Enumerated(EnumType.STRING)
    private GameStatus status;

    @ManyToOne
    @JoinColumn(name = "player1_id")
    private User player1;

    @ManyToOne
    @JoinColumn(name = "player2_id")
    private User player2;

    @ManyToOne
    @JoinColumn(name = "current_player_id")
    private User currentPlayer;

    public Game() {
        this.board = "000000000";
        this.status = GameStatus.WAITING_FOR_PLAYERS;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getBoard() { return board; }
    public void setBoard(String board) { this.board = board; }

    public GameStatus getStatus() { return status; }
    public void setStatus(GameStatus status) { this.status = status; }

    public User getPlayer1() { return player1; }
    public void setPlayer1(User player1) { this.player1 = player1; }

    public User getPlayer2() { return player2; }
    public void setPlayer2(User player2) { this.player2 = player2; }

    public User getCurrentPlayer() { return currentPlayer; }
    public void setCurrentPlayer(User currentPlayer) { this.currentPlayer = currentPlayer; }

    public enum GameStatus {
        WAITING_FOR_PLAYERS,
        PLAYER1_TURN,
        PLAYER2_TURN,
        DRAW,
        PLAYER1_WON,
        PLAYER2_WON
    }

    public int[][] getBoardAsMatrix() {
        int[][] matrix = new int[3][3];
        for (int i = 0; i < 9; i++) {
            matrix[i / 3][i % 3] = Character.getNumericValue(board.charAt(i));
        }
        return matrix;
    }

    public void setBoardFromMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(matrix[i][j]);
            }
        }
        this.board = sb.toString();
    }
}
