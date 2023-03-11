package managers;

import collections.*;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.TreeMap;
import managers.FileManager;

/**
 * Class for managing collection
 */
public class CollectionManager {

    private TreeMap<Integer, HumanBeing> humanBeingCollection;
    private final Console console;
    private final LocalDateTime creationTime;
    private final FileManager fileManager;
    /**
     * Comparator to sort TreeMap by value of HumanBeing impact speed
     */
    Comparator<HumanBeing> humanBeingComparator = new Comparator<HumanBeing>() {
        @Override
        public int compare(HumanBeing o1, HumanBeing o2) {
            return o1.compareTo(o2);
        }
    };

    public CollectionManager(Console console, FileManager fileManager) {
        this.console = console;
        this.fileManager = fileManager;
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
    public void insert(int id, HumanBeing obj) {
        this.humanBeingCollection.put(id, obj);
    }

    /**
     * returns last id in collection
     * @return last id
     */
    public int getLastId() {
        return humanBeingCollection.lastKey();
    }

    /**
     * saves collection to file
     */
    public void saveCollection() {
        fileManager.writeCollection(humanBeingCollection);
    }

    /**
     * loads collection from file
     */
    public void loadCollection() {
        this.humanBeingCollection = fileManager.readCollection();
    }

}
