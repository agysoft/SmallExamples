package CRWDProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



enum CWOrientation {HORIZONTAL, VERTICAL};

class CWord {
    CWOrientation orientation = CWOrientation.HORIZONTAL;
    int startX = 0;
    int startY = 0;
    int length = 0;
    
    
    public CWord(CWOrientation o, int sx, int sy,int l) {
        this.orientation = o;
        this.startX = sx;
        this.startY = sy;
        this.length = l;
    }
    
    @Override
    public String toString() {
        if (this.orientation == CWOrientation.HORIZONTAL) {
            return "Horizontal X:"+(startX+1)+", Y:"+(startY+1)+", Length:"+length;
        }
        return "Vertical, X:"+(startX+1)+", Y:"+(startY+1)+", Length:"+length;
    }
}

            class CWordComparator implements Comparator<CWord> {
                @Override
                public int compare(CWord cw1, CWord cw2)
                {
                        if (cw1.length == cw2.length) {
                            //if (cw1.orientation == cw2.orientation)
                                return 0;
                        }

                        else if (cw1.length > cw2.length)
                                return -1;
                        else
                                return 1;
                }
            }


public class CRWDStructures {
    static int solution = 0;
    static int max_dept = 0;
    
    public static void generateCRWD(CRWDTable ct, List<CWord> list, CRWDWordSet ws, List<CWord>[] intersectionList, int dept) {
        if (dept > CRWDStructures.max_dept) {
            System.out.println("Elértem a "+CRWDStructures.max_dept +". mélységet! ");
            CRWDStructures.max_dept = dept;
        }
        if (dept >= list.size()) {
            System.out.println("Elkészült a "+CRWDStructures.solution++ +". megoldás is! ");
            ct.Showtable();
        } else {
            CWord cw = list.get(dept);
            String pattern = ct.getPattern(cw);
            int patternLength = pattern.length();      
            int num = 0;
            boolean existSolution;
            while ((num = ws.getNumNextSuitable(pattern, num))>=0) {
                String suitableWord = ws.getWord(patternLength, num++);
                ct.setWord(cw, suitableWord);
                //System.out.println("NextSuitable -> "+suitableWord);
                //Itt vizgáljuk, hogy a most beírt megoldásra keresztbe vannak-e további megoldások..
                existSolution = true;
                for (CWord cwk :intersectionList[dept]) {
                    if (!ws.existsSuitable(ct.getPattern(cwk))) {
                        existSolution = false;
                        break;
                    }
                }
                if (existSolution) { //megnézzük a most beírt szó után keresztbe avnnak-e még lehetőségek..
                    generateCRWD(ct, list, ws, intersectionList, dept+1);
                }
            }
            ct.setWord(cw, pattern);
        }
    }
    
    public static boolean existsIntersection(CWord cw1, CWord cw2) {
        //Létezik közös négyzet a két keresztrejtvény sor között
        if (cw1.orientation == cw2.orientation) return false;
        if (cw1.orientation == CWOrientation.HORIZONTAL) {
            return cw2.startY <= cw1.startY && cw1.startY <= cw2.startY+cw2.length
                && cw1.startX <= cw2.startX && cw2.startX <= cw1.startX+cw1.length;
        } else {
            return cw1.startY <= cw2.startY && cw2.startY <= cw1.startY+cw1.length
                && cw2.startX <= cw1.startX && cw1.startX <= cw2.startX+cw2.length;
        }
    }
    
    
    
    public static void main(String[] args) {
            System.out.println("CrossWord Structures Initial!");
            
            CRWDWordSet ws = new CRWDWordSet();
            //ws.Init("1 Trónok harca - HU.txt");
            //ws.Init("thinking_in_java.txt");
            //ws.Init("szavak.txt");
            //ws.Init("szavak_1-15_cca300k.txt");
            ws.Init("szavak_300k.txt");
            
            
            System.out.println("CrossWordSet Initialized!");
            ws.showWordNums();
            
            //System.out.println("CRWDWordSet.getWord(2,2) -> "+ws.getWord(3,3));
            
            
        //Véletlen tábla generálása
            CRWDTable ct = new CRWDTable(9,9);
            ct.InitTable();
        //Első típusú tábla generálása
        /*    
            CRWDTable ct = new CRWDTable(10,10);
            ct.InitTable_2();
            
            ws.setWord(1,"ELSŐKERESZ");
            ws.setWord(2,"ZTREJTVÉNY");
            ws.setWord(1,"GENERÁLÓ");
            ws.setWord(2,"ÓPROGRAM");
        */
            ct.Showtable();
            List<CWord> list = ct.getWords(3);
            Collections.sort(list,(cw1,cw2) -> cw2.length-cw1.length);
            //Collections.sort(list, new CWordComparator());
            
           //Set<String>[] arr = new Set<String>[5];
           //arr[0].add("aaa");
           //System.out.println(arr[0].size());
           
            class ArrayListCWord extends ArrayList<CWord> {}
            List<CWord>[] intersectionList = new ArrayListCWord[list.size()];
            
            for (int i = 0; i<list.size(); i++) {
                CWord cw = list.get(i);
                System.out.println(cw);
                intersectionList[i] = new ArrayListCWord();
                for (CWord cwk :list) {
                    if (existsIntersection(cwk, cw)) {
                        intersectionList[i].add(cwk);
                    }
                }
            } 
            
            //System.out.println("intersectionList[2]: "+intersectionList[2]);
            /* existsIntersection tesztelése
            for (CWord cw1:list) {
                for (CWord cw2:list) {
                    System.out.println(cw1+"<=>"+cw2+": "+existsIntersection(cw1,cw2));
                }
            } 
           */
            //System.out.println("ct.getPattern(list.get(3)); -> "+ct.getPattern(list.get(3)));
            //ct.setWord(list.get(0), "ALMÁK");
            //ct.setWord(list.get(1), "ALKOT");
            //System.out.println("ct.getPattern(list.get(3)); -> "+ct.getPattern(list.get(3)));
            //ct.Showtable();
            
            //System.out.println("getSuitable -> "+ws.getSuitable(ct.getPattern(list.get(3))));
            CRWDStructures.solution = 0;
            CRWDStructures.max_dept = 0;
            generateCRWD(ct, list, ws, intersectionList,  0);
            
            System.out.println("Vége nincs több megoldás!!!");
    }
    
}
