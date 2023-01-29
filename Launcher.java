import java.io.File;
import java.util.Scanner;
import java.lang.reflect.InvocationTargetException;


class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Welcome to AlgoSuite!");
            System.out.println("1. Show available modules");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    showModules();
                    break;
                case 2:
                    System.exit(0); // Exit the program
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showModules() {
        File modulesFolder = new File("modules");
        File[] moduleFiles = modulesFolder.listFiles();
    
        for (File moduleFile : moduleFiles) {
            if (moduleFile.getName().endsWith(".class")) {
                try {
                    String className = moduleFile.getName().substring(0, moduleFile.getName().length() - 6);
                    Class<?> moduleClass = Class.forName("modules." + className);
    
                    if (moduleClass.getMethod("getModuleInfos") != null) {
                        Object infos = moduleClass.getMethod("getModuleInfos").invoke(null);
                        Class<?> infosClass = infos.getClass();
    
                        System.out.println("Module name: " + infosClass.getMethod("getName").invoke(infos));
                        System.out.println("Module version: " + infosClass.getMethod("getVersion").invoke(infos));
                        System.out.println("Module description: " + infosClass.getMethod("getDescription").invoke(infos));
                        System.out.println("Module developer: " + infosClass.getMethod("getDeveloper").invoke(infos));
                        System.out.println("------------------------------");
                    }
                } catch (ClassNotFoundException e) {
                    System.out.println("Error loading module class: " + e.getMessage());
                } catch (NoSuchMethodException e) {
                    System.out.println("Error getting module infos: The module does not have the required method");
                } catch (InvocationTargetException e) {
                    System.out.println("Error getting module infos: " + e.getCause().getMessage());
                } catch (IllegalAccessException e) {
                    System.out.println("Error getting module infos: " + e.getMessage());
                }
            }
        }
    }
}
    