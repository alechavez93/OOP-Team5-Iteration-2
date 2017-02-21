package Utility;
/*--------------------------------------------------------------------------------------
|	Coordinate Class: Created by Alejandro Chavez on 2/13/2017.
|---------------------------------------------------------------------------------------
|   Description: Coordinate encapsulates the row and column position of a position in
|   the GameMap. The setters prevent to allow any coordinates out of boundaries allowed by
|   the size of the GameMap.
---------------------------------------------------------------------------------------*/

public class Coordinate implements Cloneable{
    private int row, col;
    final int MAP_ROWS = 100000, MAP_COLS = 100000; // In the future this will use the map dimensions

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

//    public Coordinate(Coordinate coor) {
//        this.col = coor.getCol(); // changing from x to col
//        this.row = coor.getRow(); // changing from y to row
//    }



    //Getters
    public int getRow() { return row; }
    public int getCol() { return col; }


    //Setters
    public void setRow(int row) {
        if(row < 0 || row > MAP_ROWS - 1) {
            System.out.println("Error, setting row smaller or greater than the GameMap's allowed size: setRow("+row+")");
            return;
        }
        this.row = row;
    }

    public void setCol(int col) {
        if(col < 0 || col > MAP_COLS - 1) {
            System.out.println("Error, setting col smaller or greater than the GameMap's allowed size: setCol("+col+")");
            return;
        }
        this.col = col;
    }
}
