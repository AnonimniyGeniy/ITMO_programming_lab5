package managers;

import collections.*;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.TreeMap;

public class CollectionManager {

    private TreeMap<Integer, HumanBeing> humanBeingCollection;

    private final LocalDateTime creationTime;
    /**
     * Comparator to sort TreeMap by value of HumanBeing impact speed
     */
    Comparator<HumanBeing> humanBeingComparator = new Comparator<HumanBeing>() {
        @Override
        public int compare(HumanBeing o1, HumanBeing o2) {
            return o1.compareTo(o2);
        }
    };

    public CollectionManager() {
        humanBeingCollection = new TreeMap(humanBeingComparator);
        creationTime = LocalDateTime.now();
    }

    /**
     * @return current HumanBeing collection
     */
    public TreeMap<Integer, HumanBeing> getHumanBeingCollection() {
        return humanBeingCollection;
    }

    /**
     * Setter for controlled collection
     *
     * @param humanBeingCollection
     */
    public void setHumanBeingCollection(TreeMap<Integer, HumanBeing> humanBeingCollection) {
        this.humanBeingCollection = humanBeingCollection;
    }

    /**
     * getter for creation time of collection
     *
     * @return creation Time
     */
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    /**
     * @param obj
     */
    public void insert(HumanBeing obj) {
        humanBeingCollection.put(obj.getId(), obj);
    }

}
