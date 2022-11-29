package exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FrequencyOfWords {
    public HashMap words = new HashMap();
    //2. Keress egy hosszabb szöveget valahol (pl.: egy könyv) és írd ki file-ba "valami.txt".
    //   Írj programot, ami ezt a file-t beolvassa és kiírja a képernyőre
    //   az első 20 leggyakrabban előforduló szót és az előfordulásainak a számát.

    public static void main(String[] args) throws FileNotFoundException {
        FrequencyOfWords v = new FrequencyOfWords();
        v.readFile("C:\\Users\\laszlo.nagy\\Documents\\JAVA oktatás\\Németh-Buhin Octavio\\SpecialX\\MostUsedWords\\text.txt");
        System.out.println(v.words);

        ArrayList<String[]> top20 = v.top20Words("C:\\Users\\laszlo.nagy\\Documents\\JAVA oktatás\\Németh-Buhin Octavio\\SpecialX\\MostUsedWords\\text.txt");

        for (int i = 0; i < top20.size(); i++){
            System.out.println(top20.get(i)[0] + " :  " + top20.get(i)[1]);
        }
    }

    public void addWord(String s) {
        if (words.containsKey(s)) {
            Integer value = (Integer) words.get(s) + 1;
            words.put(s, value);
            return;
        }
        if (!words.containsKey(s)) {
            words.put(s, 1);
        }
    }
    public ArrayList createWordsList(){
        ArrayList<String[]> wordsList = new ArrayList<>();
        Iterator it = words.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            String[] keyAndValue = {pairs.getKey().toString(), pairs.getValue().toString()};
            wordsList.add(keyAndValue);
        }
        return wordsList;
    }

    public void readFile(String s) throws FileNotFoundException {
        File file = new File(s);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String[] wordsSub = scanner.nextLine().split(" ");
            for (int i = 0; i < wordsSub.length; i++) {
                addWord(wordsSub[i]);
            }
        }

    }

    public ArrayList top20Words(String fileName) throws FileNotFoundException {
        readFile(fileName);

        ArrayList<String[]> wordsList = createWordsList();
        int storeIndex = 0;
        //int value = Integer.parseInt(wordsList.get(0)[1]);
        ArrayList<String[]> top20 = new ArrayList();
        for (int n = 0; n < 20; n++) {
            for (int i = 1; i < wordsList.size() - 1; i++) {
                if (Integer.parseInt(wordsList.get(i - 1)[1]) < Integer.parseInt(wordsList.get(i)[1])) {
                    storeIndex = i;
                    //value = Integer.parseInt(wordsList.get(i)[i]);
                }
            }
            String[] add = wordsList.get(storeIndex);
            wordsList.remove(storeIndex);
            top20.add(n, add);
        }
        return  top20;
    }

}
