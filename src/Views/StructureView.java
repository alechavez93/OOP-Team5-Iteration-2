package Views;
/*--------------------------------------------------------------------------------------
|	StructureView Class: Created by Alejandro Chavez on 3/8/2017.
|---------------------------------------------------------------------------------------
|   Description: 
|
---------------------------------------------------------------------------------------*/

import Game.CyclingState;

public class StructureView extends View{

    CyclingState state;

    public StructureView(String name, CyclingState state){
        super(name);
        this.state = state;
    }
}
