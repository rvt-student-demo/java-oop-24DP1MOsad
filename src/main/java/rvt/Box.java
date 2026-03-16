package rvt;

import java.util.ArrayList;

public class Box implements Packable{
    ArrayList<Packable> packables;
    int maxWeight;

    public Box(int maxWeight) {
        this.maxWeight = maxWeight;
        this.packables = new ArrayList<>();
    }

    public double weight() {
        double weight = 0;
        for (Packable packable: packables) {
            weight += packable.weight();
        }
        return weight;
    }

    public void add(Packable thing) {
        double thingWeight = thing.weight();
        if (weight() + thingWeight <= maxWeight) {
            packables.add(thing);
        } else {
            System.out.println("kaste nevar izturet so smagumu.");
        }
    }

    @Override
    public String toString(){
        return "Box: " + packables.size() + " items, total weight " + weight() + " kg";
    }
}
