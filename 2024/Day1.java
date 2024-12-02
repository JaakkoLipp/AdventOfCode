import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        ArrayList<Integer> L = new ArrayList<Integer>();
        ArrayList<Integer> R = new ArrayList<Integer>();
        
        System.out.println("Hello, World!");
        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] parts = data.split("\\s+");
                L.add(Integer.parseInt(parts[0]));
                R.add(Integer.parseInt(parts[1]));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }
        sum(L, R);
        similarity(L, R);
    }
    private static void sum(ArrayList<Integer> L, ArrayList<Integer> R) {
        int sum = 0;
        Collections.sort(L);
        Collections.sort(R);
        for (int i = 0; i < L.size(); i++) {
            sum += Math.abs(L.get(i) - R.get(i));
        }
        System.out.println(sum);
    }
    private static void similarity(ArrayList<Integer> L, ArrayList<Integer> R){
        HashMap<Integer, Integer> Lmap = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> Rmap = new HashMap<Integer, Integer>();
        for (int i = 0; i < L.size(); i++) {
            if (Lmap.containsKey(L.get(i))) {
                Lmap.put(L.get(i), Lmap.get(L.get(i)) + 1);
            } else {
                Lmap.put(L.get(i), 1);
            }
            if (Rmap.containsKey(R.get(i))) {
                Rmap.put(R.get(i), Rmap.get(R.get(i)) + 1);
            } else {
                Rmap.put(R.get(i), 1);
            }
        }
        int similarityScore = 0;
        for (Integer key : Lmap.keySet()) {
            if (Rmap.containsKey(key)) {
                similarityScore += key * Rmap.get(key);
            }
        }
        System.out.println(similarityScore);
        
    }
}