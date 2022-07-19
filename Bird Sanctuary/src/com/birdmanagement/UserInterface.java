package com.birdmanagement;
import java.util.Scanner;
import java.util.Set;

public class UserInterface {
	//final int MAIN_EXIT = 7;
    private static UserInterface instance;
    final int MAIN_EXIT = 7;
    final int EDIT_EXIT = 4;
    Scanner sc = new Scanner(System.in);

    //Database Connection
    //BirdRepository birdRepository = new BirdRepository();
    private UserInterface(){}

//    void getBirds(Set list){
//        for (Object bird: list) {
//            System.out.println(bird);
    static synchronized UserInterface getInstance(){
        if (instance == null){
            instance = new UserInterface();
        }
        return instance;
    }

    void printFlyables(Set<Birds> list) {
        for (Birds bird : list) {
//            if (bird instanceof Flyables) {
//                ((Flyables) bird).fly();
            if (bird.canFly) {
                System.out.println(bird.name + " can fly.");
            }
        }
        System.out.println("\n");
    }

    void printSwimmables(Set<Birds> list) {
        for (Birds bird : list) {
//            if (bird instanceof Swimmables) {
//                ((Swimmables) bird).swim();
////                Swimmables swimmableBird = (Swimmables) bird;
////                swimmableBird.swim();
            if (bird.canSwim) {
                System.out.println(bird.name + " can swim.");
            }
        }
        System.out.println("\n");
    }

    int showMainMenu(){
        System.out.println("""

                1 -> Create New Bird.
                2 -> Remove a Bird.\s
                3 -> Edit an entry.\s
                4 -> Print Bird List.
                5 -> Print Birds that Fly
                6 -> Print Birds that Swim
                """+ MAIN_EXIT + 2 + """
                 -> Exit Program.
                """);
        System.out.print("Choice: ");
        return sc.nextInt();
    }

//    void addBirdObjects(){
//        //Create Bird using User Input.
//        Penguin pengu = new Penguin("PG01");
////      Penguin pengu2 = new Penguin("PG01");
//        Duck donald = new Duck("D01");
//        Parrot mitthu = new Parrot("P01");
//        Ostrich oscar = new Ostrich("O01");
//        Hen henry = new Hen("H01");
//        birdRepository.addBird(pengu);
////      birdRepository.addBird(pengu2);
//        birdRepository.addBird(donald);
//        birdRepository.addBird(mitthu);
//        birdRepository.addBird(oscar);
//        birdRepository.addBird(henry);
    int showEditMenu(){
        System.out.println("""
                What do you want to edit:
                1 -> ID.
                2 -> Name
                3 -> Color.
                """+ EDIT_EXIT + """
                 -> Exit Edit menu.
                """);
        System.out.print("Choice: ");
        return sc.nextInt();
    }

//    public void navigator(int choice) {
//        switch (choice){
//            case 1 -> {
//                addBirdObjects();
//            }
//            case 2 -> {
//                System.out.print("Enter the ID of the Bird: ");
//                String id = sc.next();
//                Birds match = birdRepository.getBird(id);
//                System.out.println("\n" + match.toString() + "\n");
//            }
//            case 3 -> {
////                editBird(name);
//            }
//            case 4 -> {
////                delBird(name);
//            }
////            case MAIN_EXIT -> System.out.println("Closed the program.");
//            default -> System.out.println("Enter correct choice.");
//        }
//    }
    int showColorMenu(){
        System.out.println("""
                Color Choices:
                0 -> RED
                1 -> GREEN
                2 -> BLUE
                3 -> WHITE
                4 -> YELLOW
                5 -> BROWN
                6 -> BLACK_WHITE
                7 -> BLACK
                """);
        System.out.print("Choice: ");
        return sc.nextInt();
    }

    void getBirds(Set<Birds> list){
        for (Object bird: list) {
            System.out.println(bird);
        }
    }
}