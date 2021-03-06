package model;

import java.util.ArrayList;

public class Player {
	private int score;
	private String name;
	private ArrayList<RSPEnum> moves;

	Player(String name){
		this.name=name;
		score=0;
		moves=new ArrayList<RSPEnum>();
	}
	public RSPEnum getNextMove(int i){
		return moves.get(i);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void setMoves(ArrayList<RSPEnum> moves) {
		this.moves = moves;
	}

	public void setUpClass(){
		RSPEnum current=RSPEnum.ROCK;
		for(int i=0;i<10;i++){
			int choice=(int) (Math.floor(Math.random() * 3) + 1);
			switch(choice){
			case 1:
				current=RSPEnum.ROCK;
				break;
			case 2:
				current=RSPEnum.PAPER;
				break;
			case 3:
				current=RSPEnum.SCISSORS;
				break;
			}
			moves.add(current);
		}

	}

	public void setUpClass(boolean truth){
		if(truth){
			moves.add(RSPEnum.ROCK);
			moves.add(RSPEnum.PAPER);
			moves.add(RSPEnum.SCISSORS);
		}else{
			moves.add(RSPEnum.SCISSORS);
			moves.add(RSPEnum.PAPER);
			moves.add(RSPEnum.ROCK);
		}
	}

}
