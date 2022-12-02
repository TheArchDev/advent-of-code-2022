import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

class Solution {
  public static void main(String[] args) {
    final int LOSE_SCORE = 0;
    final int DRAW_SCORE = 3;
    final int WIN_SCORE = 6;

    final int ROCK_SCORE = 1;
    final int PAPER_SCORE = 2;
    final int SCISSORS_SCORE = 3;

    final String LOSE_SIGN = "X";
    final String DRAW_SIGN = "Y";
    final String WIN_SIGN = "Z";

    final String OPPONENT_ROCK = "A";
    final String OPPONENT_PAPER = "B";
    final String OPPONENT_SCISSORS = "C";
    int total_score = 0;
    try (BufferedReader br = new BufferedReader(new FileReader("/Users/aarcher/Development/advent-of-code-2022/day2/input.txt"))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] match = line.split(" ");
        String opponent_play = match[0];
        String result = match[1];
        if (Objects.equals(result, LOSE_SIGN)) {
          total_score += LOSE_SCORE;
          if (Objects.equals(opponent_play, OPPONENT_ROCK)) {
            total_score += SCISSORS_SCORE;
          } else if (Objects.equals(opponent_play, OPPONENT_PAPER)) {
            total_score += ROCK_SCORE;
          } if (Objects.equals(opponent_play, OPPONENT_SCISSORS)) {
            total_score += PAPER_SCORE;
          }
        } else if (Objects.equals(result, DRAW_SIGN)) {
          total_score += DRAW_SCORE;
          if (Objects.equals(opponent_play, OPPONENT_ROCK)) {
            total_score += ROCK_SCORE;
          } else if (Objects.equals(opponent_play, OPPONENT_PAPER)) {
            total_score += PAPER_SCORE;
          } if (Objects.equals(opponent_play, OPPONENT_SCISSORS)) {
            total_score += SCISSORS_SCORE;
          }
        } else if (Objects.equals(result, WIN_SIGN)) {
          total_score += WIN_SCORE;
          if (Objects.equals(opponent_play, OPPONENT_ROCK)) {
            total_score += PAPER_SCORE;
          } else if (Objects.equals(opponent_play, OPPONENT_PAPER)) {
            total_score += SCISSORS_SCORE;
          } if (Objects.equals(opponent_play, OPPONENT_SCISSORS)) {
            total_score += ROCK_SCORE;
          }
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    System.out.println(total_score);
  }
}