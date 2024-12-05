import java.io.*;
import java.util.*;

public class Day4 {
    // Define the word to search
    private static final String WORD = "XMAS";
    private static final int[][] DIRECTIONS = {
        {0, 1}, {0, -1}, // Horizontal
        {1, 0}, {-1, 0}, // Vertical
        {1, 1}, {1, -1}, // Diagonal
        {-1, 1}, {-1, -1}
    };

    public static void main(String[] args) throws IOException {
        // Read the input grid
        List<String> input = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                input.add(line);
            }
        }

        // Convert the input into a character grid
        char[][] grid = new char[input.size()][];
        for (int i = 0; i < input.size(); i++) {
            grid[i] = input.get(i).toCharArray();
        }

        // Count occurrences of "XMAS"
        int count = countOccurrences(grid);
        System.out.println("Total occurrences of 'XMAS': " + count);
    }

    private static int countOccurrences(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int wordLength = WORD.length();
        int count = 0;

        // Iterate through each cell in the grid
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // Check all 8 directions
                for (int[] dir : DIRECTIONS) {
                    if (checkWord(grid, row, col, dir[0], dir[1])) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static boolean checkWord(char[][] grid, int startX, int startY, int dx, int dy) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Check each character of the word
        for (int i = 0; i < WORD.length(); i++) {
            int x = startX + i * dx;
            int y = startY + i * dy;

            // Check if we're out of bounds or the character doesn't match
            if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] != WORD.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
