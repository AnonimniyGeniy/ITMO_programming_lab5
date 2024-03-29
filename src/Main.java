import managers.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var console = new UserConsole();
        String path = null;
        try {
            path = System.getenv("FILENAME");
        } catch (Exception e) {
            System.out.println("Environment variable FILENAME is not set");
            System.exit(1);
        }
        if (path == null) {
            System.out.println("Environment variable FILENAME is not set");
            System.exit(1);
        }
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