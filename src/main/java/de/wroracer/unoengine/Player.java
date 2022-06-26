package de.wroracer.unoengine;

import java.util.UUID;

public class Player {
    private UUID uuid;
    private int id;
    public Player(){
        this.uuid = UUID.randomUUID();
    }

    protected Player(int id){
        this();
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return "Player{" +
                "uuid=" + uuid +
                ", id=" + id +
                '}';
    }
}
