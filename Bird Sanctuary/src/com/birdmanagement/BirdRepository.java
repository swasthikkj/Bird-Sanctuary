package com.birdmanagement;

import java.util.HashSet;
import java.util.Set;

public class BirdRepository {
	private static BirdRepository instance;
	private Set<Birds> birdList = new HashSet<>();

	//	    private List<Object> birdList = new ArrayList<>();
	//private Set<Birds> birdList = new HashSet<>();
	private BirdRepository(){} //Private constructor

	//Set getBirdList(){
	static synchronized BirdRepository getInstance(){ //method call to get instance. Singleton design.
		if (instance == null){
			instance = new BirdRepository();
		}
		return instance;
	}

	Set<Birds> getBirdList(){
		return this.birdList;
	}

	Birds getBird(String id){
		for (Birds match : birdList) {
			if (match.id.equals(id)) {
				//System.out.println("Match Found!");
				System.out.println("=====Match Found!===== \n");
				return match;
			}
		}
		//System.out.println("ID not found.");
		System.out.println("=====ID not found===== \n");
		return null;
	}

	//void addBird(Birds bird){
	void add(Birds bird){
		birdList.add(bird);
	}

	//void delBird(Birds bird){
	void delete(Birds bird){
		birdList.remove(bird);
	}
}


