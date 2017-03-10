package Entity;

/**
 * Created by CustomerPC on 3/5/2017.
 */

/*--------------------------------------------------------------------------------------

|    DamageEffect Class: Created by CustomerPC on 3/5/2017.

|---------------------------------------------------------------------------------------

|   Description:

|

---------------------------------------------------------------------------------------*/

public class DamageEffect implements EntityEffect {

    private int damage;

    public void apply(Entity e) {
        //e.takeDamage(); - Figure out better way
    }

    public DamageEffect(int damage) {
        this.damage = damage;
    }

    private DamageEffect(DamageEffect d) {
        this.damage = d.damage;
    }

    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch(Exception e) { }
        return o;
    }

}
