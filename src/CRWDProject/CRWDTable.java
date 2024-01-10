package CRWDProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//import java.util.Random;

/**
 *
 * @author laszlo.nagy
 */
class CRWDTable {

    char[][] tbl = null;
    int width = 0;
    int height = 0;
    static final char space = '˪'; //betűkkel feltöltendő
    static final char black = '*'; //fekete négyzet

    public CRWDTable() {
        this(10, 10);
    }

    public CRWDTable(int x, int y) {
        tbl = new char[x][y];
        this.width = x;
        this.height = y;
    }

    public void InitTable() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                tbl[i][j] = space;
            }
        }
        
        Random rand = new Random();
        /*
        for (int i = 0; i < 15; i++) {
            tbl[rand.nextInt(width)][rand.nextInt(height)] = black;
        }
        */
        for (int i = 0; i < this.height; i++) {
            tbl[rand.nextInt(width)][i] = black;
            //tbl[rand.nextInt(width)][i] = black;
        }
        
        
        /*
        tbl[1][1] = black;
        tbl[3][1] = black;
        tbl[1][3] = black;
        tbl[3][3] = black;
        tbl[0][4] = black;
        */
        
    }

    
    public void Showtable() {
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                System.out.print(tbl[i][j]+" ");
            }
            System.out.println();
        }
    }

    public List<CWord> getWords(int minLength) {
        List<CWord> result = new ArrayList<>();
        //Horizontal
        for (int j = 0; j < height; j++) {
            int sx = 0;
            int l = 0;
            for (int i = 0; i < width; i++) {
                if (tbl[i][j] == space) {
                    l++;
                } else {
                    if (l >= minLength) {
                        result.add(new CWord(CWOrientation.HORIZONTAL, sx, j, l));
                    }
                    sx = i + 1;
                    l = 0;
                }
            }
            if (sx < width && l >= minLength) {
                result.add(new CWord(CWOrientation.HORIZONTAL, sx, j, l));
            }
        }
        //Vertical
        for (int i = 0; i < width; i++) {
            int sy = 0;
            int l = 0;
            for (int j = 0; j < height; j++) {
                if (tbl[i][j] == space) {
                    l++;
                } else {
                    if (l >= minLength) {
                        result.add(new CWord(CWOrientation.VERTICAL, i, sy, l));
                    }
                    sy = j + 1;
                    l = 0;
                }
            }
            if (sy < height && l >= minLength) {
                result.add(new CWord(CWOrientation.VERTICAL, i, sy, l));
            }
        }
        return result;
    }
    
    public String getPattern(CWord cw) {
        String p = "";
        if (cw.orientation == CWOrientation.HORIZONTAL) {
            for (int i = cw.startX; i < cw.startX+cw.length; i++) {
                p = p + tbl[i][cw.startY];
            }
        } else { //CWOrientation.VERTICAL
            for (int i = cw.startY; i < cw.startY+cw.length; i++) {
                p = p + tbl[cw.startX][i];
            }
        }
        
        return p;
    }
    
    public void setWord(CWord cw, String word) {
        if (cw.orientation == CWOrientation.HORIZONTAL) {
            for (int i = 0; i < cw.length; i++) {
                tbl[i+cw.startX][cw.startY] = word.charAt(i);
            }
        } else { //CWOrientation.VERTICAL
            for (int i = 0; i < cw.length; i++) {
                tbl[cw.startX][i+cw.startY] = word.charAt(i);
            }
        }
    }
    
}
