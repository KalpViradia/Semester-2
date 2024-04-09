import java.io.*;

public class Lab102 {
    public static void main(String[] args) {
        String inputFile = "Lab102f1.txt";
        String outputFile = "Lab102f2.txt";
        String wordToReplace = "word1";
        String replacementWord = "word2";

        try {
            int replacements = replaceWords(inputFile, outputFile, wordToReplace, replacementWord);
            System.out.println("Number of replacements: " + replacements);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int replaceWords(String inputFile, String outputFile, String wordToReplace, String replacementWord) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            int replacements = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll(wordToReplace, replacementWord);
                writer.write(line + "\n");
                replacements += countOccurrences(line, replacementWord);
            }
            return replacements;
        }
    }

    private static int countOccurrences(String line, String word) {
        int count = 0;
        int index = 0;
        while ((index = line.indexOf(word, index)) != -1) {
            count++;
            index += word.length();
        }
        return count;
    }
}