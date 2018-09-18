package pocketgems.mud.commands;

import pocketgems.mud.Entity;
import pocketgems.mud.Game;
import pocketgems.mud.IInputProcessor;
import pocketgems.mud.World;
import pocketgems.mud.components.*;
import pocketgems.mud.exceptions.ComponentNotFoundException;
import pocketgems.mud.exceptions.EntityNotFoundException;

import java.util.ArrayList;

public abstract class BaseCommand implements ICommand {
    protected Game game;

    public BaseCommand(Game game) {
        this.game = game;
    }

    public abstract void execute(ArrayList<String> arguments) throws ComponentNotFoundException, EntityNotFoundException;

    public void execute() throws ComponentNotFoundException, EntityNotFoundException {
        execute(new ArrayList<>());
    }

    protected World getWorld() { return game.getWorld(); }

    protected Entity getPlayer() {
        return getWorld().GetPlayer();
    }

    protected Entity getPlayerRoom() throws ComponentNotFoundException, EntityNotFoundException {
        return getPlayer().getLocationComponent().room(getWorld());
    }

    protected Entity getWorldEntity(String id) throws EntityNotFoundException {
        return getWorld().GetEntity(id);
    }

    protected void addEntity(Entity entity) {
        getWorld().AddEntity(entity);
    }

    protected IInputProcessor getInputProcessor() { return game.getInputProcessor(); }

    protected void moveToRoom(Entity entity, String destinationRoomId)
            throws ComponentNotFoundException, EntityNotFoundException {
        IdentityComponent identityComponent = entity.getIdentityComponent();
        LocationComponent locationComponent = entity.getLocationComponent();

        Entity room = locationComponent.room(getWorld());
        if (room != null) {
            room.getRoomComponent().inhabitantIds.remove(identityComponent.id);
        }

        locationComponent.roomId = destinationRoomId;

        RoomComponent destinationRoomComponent = getWorld().GetEntity(destinationRoomId).getRoomComponent();
        destinationRoomComponent.inhabitantIds.add(identityComponent.id);
    }

    protected Entity entityInRoom(String keyword)
            throws ComponentNotFoundException, EntityNotFoundException {
        Entity room = getPlayerRoom();

        // Make sure the player is in a room
        for (String inhabitantId : room.getRoomComponent().inhabitantIds) {
            Entity inhabitant = getWorld().GetEntity(inhabitantId);
            DescriptionComponent descriptionComponent = inhabitant.getDescriptionComponent();
            if (descriptionComponent != null) {
                if (descriptionComponent.keywords.contains(keyword)) {
                    return inhabitant;
                }
            }
        }

        throw new EntityNotFoundException(keyword);
    }
}
