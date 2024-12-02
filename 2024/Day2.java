import java.io.*;

public class Day2 {
    public static void main(String[] args) {
        int safeCount = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("input2.txt"));

            String line;
            while ((line = br.readLine()) != null) {
                String[] levelStr = line.split(" ");
                int[] level = new int[levelStr.length];

                for (int i = 0; i < levelStr.length; i++) {
                    level[i] = Integer.parseInt(levelStr[i]);
                }
                if (isSafe(level)|| canBeMadeSafe(level)) {
                    safeCount++;
                }
            }
            br.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(safeCount);
    }

    private static boolean isSafe(int[] level) {
        Boolean isIncreasing = null;

        for (int i = 0; i < level.length - 1; i++) {
            int diff = level[i + 1] - level[i];
            
            if (diff > 3 || diff < -3) {
                return false;
            }

            if (diff == 0) {
                return false;
            }

            if (isIncreasing == null) {
                isIncreasing = diff > 0; 
            } else {

                if ((isIncreasing && diff < 0) || (!isIncreasing && diff > 0)) {
                    return false; 
                }
            }
        }
        return true;
    }

    private static boolean canBeMadeSafe(int[] level) {
        // Try removing each level one by one and check if it becomes safe
        for (int i = 0; i < level.length; i++) {
            int[] newLevel = new int[level.length - 1];
            // Copy the array without the current element
            System.arraycopy(level, 0, newLevel, 0, i);
            System.arraycopy(level, i + 1, newLevel, i, level.length - i - 1);

            // Check if the new sequence without one level is safe
            if (isSafe(newLevel)) {
                return true;
            }
        }

        return false; // If no single removal makes it safe, return false
    }
}
