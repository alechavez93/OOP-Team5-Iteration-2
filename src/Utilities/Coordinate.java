package Utilities;
/*--------------------------------------------------------------------------------------
|	Coordinate Class: Created by Alejandro Chavez on 2/13/2017.
|---------------------------------------------------------------------------------------
|   Description: Coordinate encapsulates the row and column position of a position in
|   the Map. The setters prevent to allow any coordinates out of boundaries allowed by
|   the size of the Map.
---------------------------------------------------------------------------------------*/

public class Coordinate implements Cloneable{
    private int row, col;
    final int MAP_ROWS = 20, MAP_COLS = 20;

    public Coordinate(int row, int col) {
        if(row < 0 || row > MAP_ROWS - 1 || col < 0 || col > MAP_COLS - 1)
            throw new RuntimeException("Invalid row or col parameters, map boundaries excelled-> Row: "+row+"Col: "+col);
        this.row = row;
        this.col = col;
    }

    public Coordinate() {
        this.row = 0;
        this.col = 0;
    }

    //Getters
    public int getRow() { return row; }
    public int getCol() { return col; }


    //Setters
    public void setRow(int row) {
        if(row < 0 || row > MAP_ROWS - 1) {
            System.out.println("Error, setting row smaller or greater than the Map's allowed size: setRow("+row+")");
            return;
        }
        this.row = row;
    }

    public void setCol(int col) {
        if(col < 0 || col > MAP_COLS - 1) {
            System.out.println("Error, setting col smaller or greater than the Map's allowed size: setCol("+col+")");
            return;
        }
        this.col = col;
    }
}
