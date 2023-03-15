import managers.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var console = new UserConsole();
        String path = System.getenv("FILENAME");

        FileManager fileManager = new FileManager(path, console);
        CollectionManager collectionManager = new CollectionManager(console, fileManager);

        CommandParser.setScanner(new Scanner(System.in));

        try {
            collectionManager.loadCollection();
            Executor executor = new Executor(collectionManager, console);
            executor.consoleMode();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}