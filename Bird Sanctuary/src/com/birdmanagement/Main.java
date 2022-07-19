package com.birdmanagement;
import java.util.Scanner;

public class Main {
	final int MAIN_EXIT = 7;
	final int EDIT_EXIT = 4;
	UserInterface ui = UserInterface.getInstance();

	//public static void main(String[] args) {
	public void handleUserChoice(int choice) {
		Scanner scanner = new Scanner(System.in);
		BirdRepository birdRepository = BirdRepository.getInstance();
		switch (choice) {
		case 1 -> {
			System.out.println("===============");
			addCustomBird();
			System.out.println("Added new entry!");
		}
		case 2 -> {
			System.out.println("===============");
			System.out.print("Enter the ID of the Bird: ");
			String id = scanner.next();
			Birds match = birdRepository.getBird(id);
			birdRepository.delete(match);
			System.out.println("Deleted entry.");
		}
		case 3 -> {
			System.out.println("===============");
			System.out.print("Enter the ID of the Bird to be edited: ");
			String id = scanner.next();
			Birds match = birdRepository.getBird(id);
			if(match != null){
				int state;
				do{
					state = ui.showEditMenu();
					handleEditChoice(state, match);
				}while (state != EDIT_EXIT);
			}
		}
		case 4 -> {
			System.out.println("===============");
			ui.getBirds(birdRepository.getBirdList());
		}
		case 5 -> {
			System.out.println("===============");
			ui.printFlyables(birdRepository.getBirdList());
		}
		case 6 -> {
			System.out.println("===============");
			ui.printSwimmables(birdRepository.getBirdList());
		}
		case MAIN_EXIT -> {
			System.out.println("===============");
			System.out.println("Closed the program.");
		}
		default -> {
			System.out.println("===============");
			System.out.println("Enter correct choice.");
		}
		}
	}

	void handleEditChoice(int state, Birds match) { //Operation for edit states
		Scanner scanner = new Scanner(System.in);
		switch (state) {
		case 1 -> { //Edit ID of the match;
			System.out.println("Enter the new ID: ");
			String newID = scanner.next().toUpperCase();
			match.setId(newID);
			System.out.println("Updated ID!");
		}
		case 2 -> { //Edit Name of the match
			System.out.println("Enter the new Name: ");
			String newName = scanner.next();
			match.setName(newName);
			System.out.println("Updated Name!");
		}
		case 3 -> { //Edit Color of the match;
			setColor(match);
			System.out.println("Updated Color!");
		}
		case EDIT_EXIT -> System.out.println("Closed the edit window.");
		default -> System.out.println("Enter correct choice.");
		}
	}

	//System.out.println(" Welcome to Bird Sanctuary!\n");
	void setColor(Birds match) {
		int index = ui.showColorMenu();
		match.setColor(Birds.Color.values()[index]);
	}

	// UserInterface ui = new UserInterface();
	void addCustomBird (){
		Scanner scanner = new Scanner(System.in);
		BirdRepository birdRepository = BirdRepository.getInstance();
		Birds newBird = new Birds();
		System.out.println("Enter the ID for new bird: ");
		newBird.id = scanner.next();
		System.out.println("What is this Bird called? ");
		newBird.name = scanner.next();
		setColor(newBird);
		System.out.println("Does this Bird Fly? (true/false): ");
		newBird.canFly = scanner.nextBoolean();
		System.out.println("Does this Bird Swim? (true/false): ");
		newBird.canSwim = scanner.nextBoolean();
		birdRepository.add(newBird);
	}

	public static void main(String[] args) {
		System.out.println("==========Welcome to Bird Sanctuary!==========\n");
		Main controller = new Main();
		int choice;
		do {
			choice = controller.ui.showMainMenu();
			controller.handleUserChoice(choice);
		} 
		while (choice != controller.ui.MAIN_EXIT);
	}
}