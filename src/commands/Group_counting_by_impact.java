package commands;


import collections.HumanBeing;
import managers.CollectionManager;
import managers.Console;

import java.util.HashMap;
import java.util.Map;

/**
 * group counting by impact speed
 */
public class Group_counting_by_impact extends AbstractCommand {
    private final CollectionManager collectionManager;
    private final Console console;

    public Group_counting_by_impact(Console console, CollectionManager collectionManager) {
        super("group_counting_by_impact", "group counting by impact speed");
        this.collectionManager = collectionManager;
        this.console = console;
    }


    @Override
    public boolean execute(String[] args) {
        try {
            if (args.length != 0) {
                console.println("Wrong amount of arguments.");
                return false;
            }
            HumanBeing[] elements = collectionManager.getArray();
            int[] impactSpeed = new int[elements.length];
            for (int i = 0; i < elements.length; i++) {
                impactSpeed[i] = elements[i].getImpactSpeed().intValue();
            }
            Map<Integer, Integer> counter = new HashMap<>();

            for (int i = 0; i < impactSpeed.length; i++) {
                if (counter.containsKey(impactSpeed[i])) {
                    counter.put(impactSpeed[i], counter.get(impactSpeed[i]) + 1);
                } else {
                    counter.put(impactSpeed[i], 1);
                }
            }
            for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
                console.println("Impact speed: " + entry.getKey() + " - " + entry.getValue() + " elements");
            }
            return true;
        } catch (NumberFormatException e) {
            console.println("Wrong type of arguments.");
            return false;
        }

    }

}
