package me.zakaria.commonapi.events;

public class SpeedPassedEvent extends BaseEvent<String> {

    private double speed;

    public SpeedPassedEvent(String id, double speed) {
        super(id);
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }
}
