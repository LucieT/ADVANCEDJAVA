package model;

public class RockPaperScissors {

		public Result play(RSPEnum p1, RSPEnum p2){

			if (p1==RSPEnum.ROCK && p2==RSPEnum.PAPER){
				return Result.LOST;
			}else if (p1==RSPEnum.ROCK && p2==RSPEnum.SCISSORS){
				return Result.WIN;
			}else if (p1==RSPEnum.PAPER && p2==RSPEnum.ROCK){
				return Result.WIN;
			}else if (p1==RSPEnum.PAPER && p2==RSPEnum.SCISSORS){
				return Result.LOST;
			}else if (p1==RSPEnum.SCISSORS && p2==RSPEnum.PAPER){
				return Result.WIN;
			}else if (p1==RSPEnum.SCISSORS && p2==RSPEnum.ROCK){
				return Result.LOST;
			}else{
				return Result.TIE;
			}
		}

		Result playRandom(Player p1, Player p2){
			Result result=Result.LOST;
			for(int i=0;i<10;i++){
				result=play(p1.getNextMove(i),p2.getNextMove(i));
				if(result==Result.WIN)p1.setScore(p1.getScore()+1);
				else if(result==Result.TIE){
					p1.setScore(p1.getScore()+1);
					p2.setScore(p2.getScore()+1);
				}else{
					p2.setScore(p2.getScore()+1);
				}
			}
			return result;
		}

		Result play(Player p1, Player p2){
			Result result=Result.LOST;
			for(int i=0;i<3;i++){
				result=play(p1.getNextMove(i),p2.getNextMove(i));
				if(result==Result.WIN)p1.setScore(p1.getScore()+1);
				else if(result==Result.TIE){
					p1.setScore(p1.getScore()+1);
					p2.setScore(p2.getScore()+1);
				}else{
					p2.setScore(p2.getScore()+1);
				}
			}
			if(p1.getScore()<p2.getScore()){
				result=Result.LOST;
			}
			else if(p1.getScore()>p2.getScore()){
				result=Result.WIN;
			}
			else if(p1.getScore()==p2.getScore()){
				result=Result.TIE;
			}
			return result;
		}
}
