package Entity.Unit;

import Entity.Entity;
import Entity.EntityEffect;

/**
 * Created by Customer-PC on 3/14/2017.
 */
public class HealEffect implements EntityEffect {
    private int heal;

    public void apply(Entity e) {
        e.setCurrentHealth(e.getCurrentHealth() + heal);
    }

    public HealEffect(int heal) {
        this.heal = heal;
    }

    private HealEffect(HealEffect d) {
        this.heal = d.heal;
    }

    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch(Exception e) { }
        return o;
    }

}
