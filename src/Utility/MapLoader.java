package Utility;
/*--------------------------------------------------------------------------------------
|	MapLoader Class: Created by Alejandro Chavez on 3/6/2017.
|---------------------------------------------------------------------------------------
|   Description: Takes care of loading a predefined map based on a text file. Every row
|   in the text file should be finished with a '\n' character, including the last one.
---------------------------------------------------------------------------------------*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MapLoader {

    public static String loadFileText(String fileName){
        String result = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            br.close();
            result = sb.toString();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return result;
    }

    public static char[][] getCharMap(String mapName){
        String result = loadFileText(mapName+".txt");
        String[] content = result.split("\n");
        int rows = content.length;
        int cols = (result.length()-rows)/rows-1;
        System.out.println(content);
        char[][] map = new char[rows][cols];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                map[i][j] = content[i].charAt(j);
            }
        }
        return map;
    }

    private static int countChar(String str, char ch){
        int counter = 0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == ch) {
                counter++;
            }
        }
        return counter;
    }
}
