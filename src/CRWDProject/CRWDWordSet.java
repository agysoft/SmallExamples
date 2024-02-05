package CRWDProject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author laszlo.nagy
 */
public class CRWDWordSet {
    final static int MAX_LENGTH = 16;
    final static int MAX_WORD_NUM = 50000;
    
    public String[][] words;
    public int[] wordNums = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; //egyes hosszú szavak száma
    
    HashSet<String> _existsSuitable;
    HashSet<String> _notExistsSuitable;
    

    public CRWDWordSet(){
        this._existsSuitable = new HashSet<>();
        this._notExistsSuitable = new HashSet<>();
        
        this.words = new String[MAX_LENGTH][MAX_WORD_NUM];
    }
    
    public void Init(String filename){
        try {
            Path path = Paths.get(filename);
            List<String> lines = Files.readAllLines(path);
            List<String> words = splitToWords(lines);
            System.out.println("Number of words: "+words.size());
            
            for (String word : words) {
                addWord(word);
            }
	} catch (Exception e) {
            e.printStackTrace();
	}
    }
    
    public void exportToFile(String filename){
        try {
            FileWriter myWriter = new FileWriter(filename);
            for (int length = 2; length < MAX_LENGTH; length++) {
                for (int i = 0; i < wordNums[length]; i++) {
                    myWriter.write(this.words[length][i]+",");
                    if (i%10 == 9) {
                        myWriter.write("\r\n");
                    }
                }
                myWriter.write("\r\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public void showWordNums() {
        int i = 0;
        for (int num:wordNums) {
            System.out.println(i++ +" hossúságú szóból van: " + num + " darab.");
        }
    }
    
    public void addWord(String word) {
        try {
            int length = word.length();
            if (length < MAX_LENGTH && wordNums[length] < MAX_WORD_NUM){
                words[length][wordNums[length]++] = word;
            }
        }
        catch(Exception e) {
        }
    }
    
    public void setWord(int num, String word) {
        try {
            int length = word.length();
            if (length < MAX_LENGTH && num < MAX_WORD_NUM){
                words[length][num] = word;
            }
        }
        catch(Exception e) {
        }
    }
    
    public String getWord(int len, int num) {
        try {
            if (len < MAX_LENGTH && num < MAX_WORD_NUM){
                return words[len][num];
            } else return null;
        }
        catch(Exception e) {
            return null;
        }
    }
    
    public boolean existsSuitable(String pattern) {
        if (_existsSuitable.contains(pattern)) {
            return true;
        }
        if (_notExistsSuitable.contains(pattern)) {
            return false;
        }
        
        int plength = pattern.length();
        for (int i = 0; i < wordNums[plength]; i++) {
            if (suitable(pattern, words[plength][i])) {
                _existsSuitable.add(pattern);
                return true;
            }
        }
        _notExistsSuitable.add(pattern);
        return false;
    }
    
    public String getSuitable(String pattern) {
        int plength = pattern.length();
        //for (String word : words[plength]) {
        for (int i = 0; i < wordNums[plength]; i++) {
            if (suitable(pattern, words[plength][i])) {
                return words[plength][i];
            }
        }
        return null;
    }
    
    public int getNumNextSuitable(String pattern, int num) {
        int plength = pattern.length();
        for (int i = num; i < wordNums[plength]; i++) {
            if (suitable(pattern, words[plength][i])) {
                return i;
            }
        }
        return -1;
    }
    
    public static boolean suitable(String pattern, String word) {

        if (pattern.length() != word.length()) {
            return false;
        }
        
        int i = 0;
        for (char c: pattern.toCharArray()) {
            if (CRWDTable.space != c  && c != word.charAt(i)) {
                return false;
            }
            i++;
        }

        return true;
    }
    
    
    
    public static void main(String[] args) {
            System.out.println("CrossWord WordSet Test!");
            
            CRWDWordSet ws = new CRWDWordSet();
            ws.Init("szavak_1-15_cca300k.txt");
            
            ws.exportToFile("szavak_300k.txt");
            /*
            System.out.println("CRWDWordSet.getWord(3,2) -> "+ws.getWord(3,2));
            
            if (CRWDWordSet.suitable("a˪c","acc")) {
                System.out.println("CRWDWordSet.suitable(\"abc\",\"abc\") -> TRUE");
            } else {
                System.out.println("CRWDWordSet.suitable(\"abc\",\"abc\") -> FALSE");
            }
            
            System.out.println("CRWDWordSet.existsSuitable(\"L˪N\") -> "+ws.existsSuitable("L˪N")+" > "+ws.getNumNextSuitable("L˪N",0));
            
            String pattern = "L˪N";
            int patternLength = pattern.length();      
            int num = 0;
            while ((num = ws.getNumNextSuitable(pattern, num))>=0) {
                String suitableWord = ws.getWord(patternLength, num++);
                System.out.println(suitableWord);
            }
            */
            
            
            
            
    }
    
    
    public static List<String> splitToWords(List<String> lines) {

		List<String> resultWords = new ArrayList<>();
		//StringBuilder stringBuilder = new StringBuilder();

		for (String line : lines) {
                    line = line.replaceAll("\\.", "").
                            replaceAll("\\?", "").
                            replaceAll("!", "").
                            replaceAll(":", "").
                            replaceAll("\\(", "").
                            replaceAll("\\)", "").
                            replaceAll(",", " ").
                            replaceAll("„", "").
                            replaceAll("\"", "").
                            replaceAll("0", "").
                            replaceAll("1", "").
                            replaceAll("2", "").
                            replaceAll("3", "").
                            replaceAll("4", "").
                            replaceAll("5", "").
                            replaceAll("6", "").
                            replaceAll("7", "").
                            replaceAll("8", "").
                            replaceAll("9", "").
                            replaceAll("-", " ").toUpperCase();
                    String[] words = line.split(" ");
                    for (String word: words) {
                        if (word.length()>1 && !resultWords.contains(word)) {
                            /* Innen van a szó....
                            if (word.equals("LYA")) {
                                System.out.println(line);
                            }
                            */
                            resultWords.add(word);
                        }
                       
                    }
                }
		
		return resultWords;
	}
}

