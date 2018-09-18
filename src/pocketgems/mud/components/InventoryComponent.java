package pocketgems.mud.components;

import pocketgems.mud.Entity;
import pocketgems.mud.exceptions.ComponentNotFoundException;

import java.util.HashSet;


/*
 * InventoryComponent
 * =============
 * Inventory is a component that stores items.
 */
public class InventoryComponent extends Component {
    private HashSet<Entity> items = new HashSet<>();

    public void add(Entity entity) { items.add(entity); }

    public void remove(Entity entity) { items.remove(entity); }

    public Entity getOrNull(String keyWord) throws ComponentNotFoundException {
        for (Entity entity : getItems()) {
            if(entity.getDescriptionComponent().keywords.contains(keyWord)) {
                return entity;
            }
        }

        return null;
    }

    public Iterable<Entity> getItems() { return items; }
}
