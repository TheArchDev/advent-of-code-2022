import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Solution {
	public static void main(String[] args) {
		int most_calories = 0;
		int second_most_calories = 0;
		int third_most_calories = 0;
		int current_elf_calories = 0;
		try (BufferedReader br = new BufferedReader(new FileReader("/Users/aarcher/Development/advent-of-code-2022/day1/input.txt"))) {
			String item_calories;
			while ((item_calories = br.readLine()) != null) {
				if (item_calories.isEmpty()){
					if (current_elf_calories >= most_calories) {
						third_most_calories = second_most_calories;
						second_most_calories = most_calories;
						most_calories = current_elf_calories;
          } else if (current_elf_calories >= second_most_calories) {
						third_most_calories = second_most_calories;
						second_most_calories = current_elf_calories;
          } else if (current_elf_calories >= third_most_calories) {
            third_most_calories = current_elf_calories;
          }
					current_elf_calories = 0;
        } else {
          current_elf_calories += Integer.parseInt(item_calories);
        }
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		if (current_elf_calories > most_calories) {
			most_calories = current_elf_calories;
		}
    System.out.println(most_calories+second_most_calories+third_most_calories);
	}
}