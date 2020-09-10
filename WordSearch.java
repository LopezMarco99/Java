import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordSearch {
    /*
     * This is how you declare constants in Java. You can now type
     * 'MIN_WORD_LENGTH' anywhere you want to refer to it.
     */
    private static final int MIN_WORD_LENGTH = 3;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(args[0]));
        List<String> Dictionary = new ArrayList<String>();
        while (scanner.hasNext()) {
            String DictionaryWord = scanner.nextLine();
            Dictionary.add(DictionaryWord.toLowerCase());
        }
        scanner.close(); // Dictionary has now been created
        Scanner GridScanner = new Scanner(new File(args[1]));
        Integer rows = Integer.valueOf(GridScanner.nextLine());
        Integer columns = Integer.valueOf(GridScanner.nextLine());
        String[][] Grid = new String[rows][columns];
        while (GridScanner.hasNext()) {
            for (int a = 0; a < rows; a++) {
                String[] RowOfChars = GridScanner.nextLine().toLowerCase()
                        .split(" ");
                for (int b = 0; b < columns; b++) {
                    Grid[a][b] = RowOfChars[b];
                }
            }
        }
        GridScanner.close();// Grid is now scanned in
        int x = 0;
        while (x < rows) {
            String PossibleWord = "";
            for(String characters : Grid[x]) {
                PossibleWord += characters;
            }
            for (int c = 0; c <= columns; c++) {
                for (int d = c + 3; d <= columns; d++) {
                    String WordSearch = PossibleWord.substring(c, d);
                    if (Dictionary.contains(WordSearch)) {
                        System.out.println(WordSearch);
                    }
                }
            }
            x++;
        } // left to right Done
        int y = 0;
        while (y < rows) {
            String PossibleWord = "";
            for (String characters : Grid[y]) {
                PossibleWord += characters;
            }
            char[] Temp0 = PossibleWord.toCharArray();
            String PossibleWordReversed = "";
            for (int e = Temp0.length - 1; e >= 0; e--) {
                PossibleWordReversed += Temp0[e];
            }
            for (int c = 0; c <= columns; c++) {
                for (int d = c + 3; d <= columns; d++) {
                    String WordSearch = PossibleWordReversed.substring(c, d);
                    if (Dictionary.contains(WordSearch)) {
                        System.out.println(WordSearch);
                    }
                }
            }
            y++;
        } // Right to left DONE
        for (int f = 0; f < columns; f++) {
            String PossibleWord = "";
            for (int g = 0; g < rows; g++) {
                PossibleWord += Grid[g][f];
            }
            for (int h = 0; h <= rows; h++) {
                for (int i = h + 3; i <= rows; i++) {
                    String WordSearch = PossibleWord.substring(h, i);
                    if (Dictionary.contains(WordSearch)) {
                        System.out.println(WordSearch);
                    }
                }
            }
        } // Top to Bottom Done
        for (int j = 0; j < columns; j++) {
            String PossibleWord = "";
            for (int k = 0; k < rows; k++) {
                PossibleWord += Grid[k][j];
            }
            char[] Temp0 = PossibleWord.toCharArray();
            String PossibleWordReversed = "";
            for (int e = Temp0.length - 1; e >= 0; e--) {
                PossibleWordReversed += Temp0[e];
            }
            for (int l = 0; l <= rows; l++) {
                for (int m = l + 3; m <= rows; m++) {
                    String WordSearch = PossibleWordReversed.substring(l, m);
                    if (Dictionary.contains(WordSearch)) {
                        System.out.println(WordSearch);
                    }
                }
            }
        }
    }
}