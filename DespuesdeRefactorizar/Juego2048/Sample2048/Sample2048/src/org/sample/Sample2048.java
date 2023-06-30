package org.sample;

import java.util.logging.*;
import java.util.Random;
import java.util.stream.IntStream;

public class Sample2048 {

    private static final Logger logger = Logger.getLogger(Sample2048.class.getName());

    //-------------------Initialize zero to all--------------------------------
    public Sample2048() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                a[i][j] = 0;
            }
        }
    }

    int[][] a = new int[4][4];
    int score = 0;
    int best = 0;

    //----------------------For showing----------------------------------------
    public void show() {
        for (int i = 0; i < 4; i++) {
            String tabularString = buildTabularString(i);
            logger.log(Level.INFO, "{}", tabularString);
        }
    }

    private String buildTabularString(int rowIndex) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 4; j++) {
            sb.append(a[rowIndex][j]).append("\t");
        }
        return sb.toString();
    }
//-----------Tecnica de refactorizacion: "Extract Method"
/*
En esta versión refactorizada, el código responsable de construir la cadena tabular 
se ha extraído en un método separado llamado buildTabularString(). Este método 
toma el índice de fila como parámetro y construye la cadena tabular para esa fila 
en particular. El método show() ahora llama a este método extraído en un bucle para 
cada fila y registra la cadena tabular resultante. 
*/
    private static final int SIZE = 4;
    private static final int EMPTY_CELL = 0;

    public void slide(String dir) {
        IntStream.range(0, SIZE).parallel().forEach(i
                -> IntStream.range(0, SIZE).parallel().forEach(j -> {
                    int k = 0;
                    switch (dir) {
                        case "up":
                            k = i - 1;
                            while (k >= 0 && a[k][j] == EMPTY_CELL) {
                                k--;
                            }
                            if (k >= 0 && a[k][j] == a[i][j]) {
                                a[k][j] *= 2;
                                a[i][j] = EMPTY_CELL;
                            } else if (k < i - 1) {
                                a[k + 1][j] = a[i][j];
                                a[i][j] = EMPTY_CELL;
                            }
                            break;
                        case "down":
                            k = i + 1;
                            while (k < SIZE && a[k][j] == EMPTY_CELL) {
                                k++;
                            }
                            if (k < SIZE && a[k][j] == a[i][j]) {
                                a[k][j] *= 2;
                                a[i][j] = EMPTY_CELL;
                            } else if (k > i + 1) {
                                a[k - 1][j] = a[i][j];
                                a[i][j] = EMPTY_CELL;
                            }
                            break;
                        case "left":
                            k = j - 1;
                            while (k >= 0 && a[i][k] == EMPTY_CELL) {
                                k--;
                            }
                            if (k >= 0 && a[i][k] == a[i][j]) {
                                a[i][k] *= 2;
                                a[i][j] = EMPTY_CELL;
                            } else if (k < j - 1) {
                                a[i][k + 1] = a[i][j];
                                a[i][j] = EMPTY_CELL;
                            }
                            break;
                        case "right":
                            k = j + 1;
                            while (k < SIZE && a[i][k] == EMPTY_CELL) {
                                k++;
                            }
                            if (k < SIZE && a[i][k] == a[i][j]) {
                                a[i][k] *= 2;
                                a[i][j] = EMPTY_CELL;
                            } else if (k > j + 1) {
                                a[i][k - 1] = a[i][j];
                                a[i][j] = EMPTY_CELL;
                            }
                            break;
                        default:
                            break;
                    }
                })
        );
    }

    /*
En el código se puede aplicar la técnica de refactorización conocida como 
"Replace Magic Number with Named Constant" (Reemplazar número mágico con constante con nombre).
La razón para aplicar esta técnica es que el código contiene valores numéricos específicos (0, 4) 
que tienen un significado particular en el contexto del algoritmo de deslizamiento. Al reemplazar 
estos números con constantes con nombre, el código se vuelve más legible, mantenible y menos 
propenso a errores.
     */

    //-------------------------------------------------------------------------
    //-----------------For adding----------------------------------------------
    public void adding(String dir) {
        int[][] aCopy = new int[4][4];
        boolean moveMade = false;

        switch (dir) {
            case "down":
                for (int j = 0; j < 4; j++) {
                    for (int i = 3; i > 0; i--) {
                        int currentValue = a[i][j];
                        int adjacentValue = a[i - 1][j];
                        if (currentValue == adjacentValue && currentValue != 0) {
                            a[i][j] = currentValue * 2;
                            score += a[i][j];
                            a[i - 1][j] = 0;
                            if (a[i][j] > best) {
                                best = a[i][j];
                            }
                            moveMade = true;
                        }
                    }
                }
                break;

            case "up":
                for (int j = 0; j < 4; j++) {
                    for (int i = 0; i < 3; i++) {
                        int currentValue = a[i][j];
                        int adjacentValue = a[i + 1][j];
                        if (currentValue == adjacentValue && currentValue != 0) {
                            a[i][j] = currentValue * 2;
                            score += a[i][j];
                            a[i + 1][j] = 0;
                            if (a[i][j] > best) {
                                best = a[i][j];
                            }
                            moveMade = true;
                        }
                    }
                }
                break;

            case "left":
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 3; j++) {
                        int currentValue = a[i][j];
                        int adjacentValue = a[i][j + 1];
                        if (currentValue == adjacentValue && currentValue != 0) {
                            a[i][j] = currentValue * 2;
                            score += a[i][j];
                            a[i][j + 1] = 0;
                            if (a[i][j] > best) {
                                best = a[i][j];
                            }
                            moveMade = true;
                        }
                    }
                }
                break;

            case "right":
                for (int i = 0; i < 4; i++) {
                    for (int j = 3; j > 0; j--) {
                        int currentValue = a[i][j];
                        int adjacentValue = a[i][j - 1];
                        if (currentValue == adjacentValue && currentValue != 0) {
                            a[i][j] = currentValue * 2;
                            score += a[i][j];
                            a[i][j - 1] = 0;
                            if (a[i][j] > best) {
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

        if (moveMade) {
            for (int i = 0; i < 4; i++) {
                System.arraycopy(a[i], 0, aCopy[i], 0, 4);
            }
            a = aCopy;
        }
    }
    /*
En el código se puede aplicar la técnica de refactorización conocida como "Extract Variable" (Extraer Variable).
La razón para aplicar esta técnica es que el código contiene expresiones repetitivas,
como a[i][j], a[i][j] *= 2, score += a[i][j], a[i][j] > best, entre otras. Al extraer estas
expresiones repetitivas en variables con nombres significativos, el código se vuelve más legible,
mantenible y menos propenso a errores.    
     */
    private static final Random rand = new Random();

    public boolean random() {
        int emptyCellsCount = countEmptyCells();

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

    private int countEmptyCells() {
        int emptyCellsCount = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (a[i][j] == 0) {
                    emptyCellsCount++;
                }
            }
        }

        return emptyCellsCount;
    }
    
    /*
    Se puede aplicar la técnica de refactorización conocida como "Extract Method" (Extraer Método).
    La razón para aplicar esta técnica es que hay una sección de código que se repite en dos ocasiones, 
    lo cual puede generar duplicación de código y dificultar su mantenimiento. Al extraer esta sección 
    de código repetitiva en un método separado, se mejora la legibilidad, se evita la duplicación y se 
    promueve la reutilización del código
    */

    public static void main(String[] args) {

        new Sample2048GUI().setVisible(true);
    }
}
