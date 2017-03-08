package GameMap;

import Entity.EntityEffect;

import java.util.ArrayList;
import java.util.List;


/*--------------------------------------------------------------------------------------

|    AreaEffect Class: Created by CustomerPC on 3/5/2017.

|---------------------------------------------------------------------------------------

|   Description:

|

---------------------------------------------------------------------------------------*/

public class AreaEffect {
    private int sizeRadius;
    private MapCoordinate center;
    private List<EffectLocation> effects;
    private boolean isValid = true;

    private class EffectLocation {
        public MapCoordinate loc;
        public EntityEffect effect;

        public EffectLocation(MapCoordinate loc, EntityEffect effect) {
            this.loc = loc;
            this.effect = effect;
        }
    }

    public AreaEffect(MapCoordinate center, int radius, EntityEffect effect) {
        this.sizeRadius = radius;
        this.center = center;
        int total = 0;
        if(radius > 0) {
            List<Tile> t = GameMap.getInstance().getAllNeighbors(center.getVector(), radius);
            effects = new ArrayList<EffectLocation>(t.size() + 1);
            for(Tile tt : t) {
                addEffect(effect, tt);
            }
        } else {
            effects = new ArrayList<EffectLocation>(1);
        }
        addEffect(effect, GameMap.getInstance().getTile(center));
    }

    private void addEffect(EntityEffect e, Tile t) {
        effects.add(new EffectLocation(t.getPos(), (EntityEffect)e.clone()));
        t.addEffect(e);
    }

    public void deconstruct() {
        GameMap map = GameMap.getInstance();
        for(EffectLocation e : effects )
            map.getTile(e.loc).removeEffect(e.effect);
        isValid = false;
    }

    public boolean isValid() {return isValid;}
}
