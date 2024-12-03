import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// part 2 based on part 1
public class Day3 {
    public static void main(String[] args) {
        int sum = 0;
        boolean enabled = true;
        Pattern p = Pattern.compile("(do|don't)\\(\\)|mul\\((\\d+),(\\d+)\\)");
        
        try {
            File file = new File("input.txt");
            Scanner sc = new Scanner(file);
            
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Matcher m = p.matcher(line);

                while (m.find()) {
                    if (m.group(1) != null) {

                        String instruction = m.group(1);
                        if (instruction.equals("do")) {
                            enabled = true;
                        } else if (instruction.equals("don't")) {
                            enabled = false;
                        }
                    }
                    if (m.group(2)!= null){

                    
                    if (enabled) {
                    int x = Integer.parseInt(m.group(2));
                    int y = Integer.parseInt(m.group(3));
                    System.out.println(m.group(0) + " = " + (x * y));
                    sum += (x * y);
                    }
                }
            }
        }
            sc.close();
            System.out.println("total: " + sum);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}