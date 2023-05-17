package org.sample;
import java.util.logging.*;
import java.util.Random;
import java.util.stream.IntStream;



public class Sample2048 {

    private static final Logger logger = Logger.getLogger(Sample2048.class.getName());
   


  
    
    //-------------------Initialize zero to all--------------------------------
    public Sample2048()
    {
        for(int i=0;i<4;i++)
            for(int j=0;j<4;j++)
                a[i][j]=0; 
    }
    
    int[][] a=new int[4][4];
    int score=0;
    int best=0;
    
   
    //----------------------For showing----------------------------------------
    public void show() {
    for (int i = 0; i < 4; i++) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 4; j++) {
            sb.append(a[i][j]).append("\t");
        }
        logger.log(Level.INFO, "{}", sb);
    }
}
    
    
    
    
    
    
    //--------------For Slideing-----------------------------------------------
    public void slide(String dir) {
    IntStream.range(0, 4).parallel().forEach(i ->
        IntStream.range(0, 4).parallel().forEach(j -> {
            int k = 0;
            switch (dir) {
                case "up":
                    k = i - 1;
                    while (k >= 0 && a[k][j] == 0) {
                        k--;
                    }
                    if (k >= 0 && a[k][j] == a[i][j]) {
                        a[k][j] *= 2;
                        a[i][j] = 0;
                    } else if (k < i - 1) {
                        a[k + 1][j] = a[i][j];
                        a[i][j] = 0;
                    }
                    break;
                case "down":
                    k = i + 1;
                    while (k < 4 && a[k][j] == 0) {
                        k++;
                    }
                    if (k < 4 && a[k][j] == a[i][j]) {
                        a[k][j] *= 2;
                        a[i][j] = 0;
                    } else if (k > i + 1) {
                        a[k - 1][j] = a[i][j];
                        a[i][j] = 0;
                    }
                    break;
                case "left":
                    k = j - 1;
                    while (k >= 0 && a[i][k] == 0) {
                        k--;
                    }
                    if (k >= 0 && a[i][k] == a[i][j]) {
                        a[i][k] *= 2;
                        a[i][j] = 0;
                    } else if (k < j - 1) {
                        a[i][k + 1] = a[i][j];
                        a[i][j] = 0;
                    }
                    break;
                case "right":
                    k = j + 1;
                    while (k < 4 && a[i][k] == 0) {
                        k++;
                    }
                    if (k < 4 && a[i][k] == a[i][j]) {
                        a[i][k] *= 2;
                        a[i][j] = 0;
                    } else if (k > j + 1) {
                        a[i][k - 1] = a[i][j];
                        a[i][j] = 0;
                    }
                    break;
                default:
                    break;
            }
        })
    );
}



    //-------------------------------------------------------------------------




    //-----------------For adding----------------------------------------------
    public void adding(String dir) {
    int[][] aCopy = new int[4][4];
    boolean moveMade = false;

    switch(dir) {
        case "down":
            for(int j = 0; j < 4; j++) {
                for(int i = 3; i > 0; i--) {
                    if(a[i][j] == a[i - 1][j] && a[i][j] != 0) {
                        a[i][j] *= 2;
                        score += a[i][j];
                        a[i - 1][j] = 0;
                        if(a[i][j] > best) {
                            best = a[i][j];
                        }
                        moveMade = true;
                    }
                }
            }
            break;

        case "up":
            for(int j = 0; j < 4; j++) {
                for(int i = 0; i < 3; i++) {
                    if(a[i][j] == a[i + 1][j] && a[i][j] != 0) {
                        a[i][j] *= 2;
                        score += a[i][j];
                        a[i + 1][j] = 0;
                        if(a[i][j] > best) {
                            best = a[i][j];
                        }
                        moveMade = true;
                    }
                }
            }
            break;

        case "left":
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 3; j++) {
                    if(a[i][j] == a[i][j + 1] && a[i][j] != 0) {
                        a[i][j] *= 2;
                        score += a[i][j];
                        a[i][j + 1] = 0;
                        if(a[i][j] > best) {
                            best = a[i][j];
                        }
                        moveMade = true;
                    }
                }
            }
            break;

        case "right":
            for(int i = 0; i < 4; i++) {
                for(int j = 3; j > 0; j--) {
                    if(a[i][j] == a[i][j - 1] && a[i][j] != 0) {
                        a[i][j] *= 2;
                        score += a[i][j];
                        a[i][j - 1] = 0;
                        if(a[i][j] > best) {
                            best = a[i][j];
                        }
                        moveMade = true;
                    }
                }
            }
            break;

        default:
            break;
    }

    if(moveMade) {
        // Copy the modified values back to the original array
        for(int i = 0; i < 4; i++) {
            System.arraycopy(a[i], 0, aCopy[i], 0, 4);
        }
        a = aCopy;
    }
}


    


    
    //-------------------Generating at random position-------------------------
  

private static final Random rand = new Random();

public boolean random() {
    int emptyCellsCount = 0;
        
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            if (a[i][j] == 0) {
                emptyCellsCount++;
            }
        }
    }
    
    if (emptyCellsCount > 0) {
        int randomIndex = rand.nextInt(emptyCellsCount);
        int cellCount = -1;
            
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (a[i][j] == 0) {
                    cellCount++;
                        
                    if (cellCount == randomIndex) {
                        boolean isTwo = rand.nextBoolean();
                        a[i][j] = isTwo ? 2 : 4;
                        return true;
                    }
                }
            }
        }
    }
        
    return false;
}







    public static void main(String[] args) {
        
        new Sample2048GUI().setVisible(true);
    }
}
