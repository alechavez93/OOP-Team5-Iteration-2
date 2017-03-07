package UtilitiesTests;
/*--------------------------------------------------------------------------------------
|	TestMapLoader Class: Created by Alejandro Chavez on 3/7/2017.
|---------------------------------------------------------------------------------------
|   Description: Tests the functionality of MapLoader class.
---------------------------------------------------------------------------------------*/

import Utility.MapLoader;
import org.junit.Test;

public class TestMapLoader {

    @Test
    public void testGetCharMap(){
        char[][] charMap = MapLoader.getCharMap("././res/sample");
        for(int i=0; i<charMap.length; i++){
            for (int j =0; j<charMap[0].length; j++){
                System.out.print(Character.toString(charMap[i][j])+" ");
            }
            System.out.println();
        }
    }
}
