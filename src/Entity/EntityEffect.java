package Entity;

/*--------------------------------------------------------------------------------------
|    EntityEffect Interface: Created by Andrew on 3/5/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public interface EntityEffect extends Cloneable{
    void apply(Entity e);
    Object clone();
}
