package Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class BikeStore implements Clock, BikeProvider {

    private BikeProvider provider;
    private Clock clock;
    private long expireTime;
    private static int borrowedCount = 0;
    private static final List<Bike> bikeList = new ArrayList<>();


    public BikeStore(long expireTime) {
        this.expireTime = expireTime;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }


    public Bike borrow() {
        borrowedCount++;
        Bike bikeFalseRepair = null;
        Bike bikeExpireTime = null;
        for (Bike bike1 : bikeList) {
            if (!bike1.isNeedsRepair())
                bikeFalseRepair = bike1;
            else
                repair(bike1);
            if (bike1.getExpireTime() == getCurrentTime())
                bikeExpireTime = bike1;
        }
        if (bikeFalseRepair != null)
            return bikeFalseRepair;
        if (bikeExpireTime != null)
            return bikeExpireTime;
        return provide();
    }

    public static void addBikeToList(Bike bike) {
        bikeList.add(bike);
    }

    public static List<Bike> getBikeList() {
        return bikeList;
    }

    public int borrowedCount() {
        return Math.max(borrowedCount, 0);
    }

    @Override
    public Bike provide() {
        String[] names = {"Viva", "Max", "Damavand"};
        String[] models = {"MX", "AS", "FX", "LA"};
        Random random = new Random();
        String finalName = names[random.nextInt(3)] +
                models[random.nextInt(4)] + random.nextInt();
        return new Bike(UUID.randomUUID().toString(), finalName, expireTime);
    }

    public void restore(Bike bike, boolean needsRepair) {
        boolean exist = false;
        for (Bike bike1 : bikeList) {
            if (bike.equals(bike1)) {
                bike.setNeedsRepair(needsRepair);
                exist = true;
                break;
            }
        }
        if (!exist)
            System.out.println("This Bike Does Not Belong To Our Store ...");
    }

    @Override
    public void repair(Bike bike) {
        bike.setNeedsRepair(false);
    }

    @Override
    public long getCurrentTime() {
        Random random = new Random();
        return random.nextInt(11);
    }
}
