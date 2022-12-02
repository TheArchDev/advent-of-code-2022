import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

class Solution {
  public static void main(String[] args) {
    int total_score = 0;
    try (BufferedReader br = new BufferedReader(new FileReader("/Users/aarcher/Development/advent-of-code-2022/day2/test_input.txt"))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] match = line.split(" ");
        String opponent_play = match[0];
        String your_play = match[1];
        if (Objects.equals(your_play, "X")) {
          total_score += 1;
          if (Objects.equals(opponent_play, "A")){
            total_score += 3;
          } else if (Objects.equals(opponent_play, "C")){
            total_score += 6;
          }
        } else if (Objects.equals(your_play, "Y")) {
          total_score += 2;
          if (Objects.equals(opponent_play, "A")){
            total_score += 6;
          } else if (Objects.equals(opponent_play, "B")) {
            total_score += 3;
          }
        } else if (Objects.equals(your_play, "Z")) {
          total_score += 3;
          if (Objects.equals(opponent_play, "B")) {
            total_score += 6;
          } else if (Objects.equals(opponent_play, "C")){
            total_score += 3;
          }
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    System.out.println(total_score);
  }
}