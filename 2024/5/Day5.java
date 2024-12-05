import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Day5 {
    public static void main(String[] args) {
        try {
            String input = Files.readString(Path.of("input.txt"));
            int res = solve(input);
            System.out.println("Result: " + result);
        } catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
        }
        
    }

    private static int solve(String input) {
        String[] parts = input.split("\n\n");
        Map<Integer, List<Integer>> rules = parseRules(parts[0]);
        List<List<Integer>> updates = parseUpdates(parts[1]);
        int middleSum = 0;
        return middleSum;
    }

    private static Map<Integer, List<Integer>> parseRules(String rulespart) {
        return rules;
    }

    private static List<List<Integer>> parseUpdates(String input) {
        return updates;
    }
}
