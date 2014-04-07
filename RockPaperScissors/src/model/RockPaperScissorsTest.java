package model;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class RockPaperScissorsTest {

	RockPaperScissors rps;

	@BeforeClass
	public void beforeClass(){
		rps=new RockPaperScissors();
	}

	@AfterClass
	public void tearDownClass(){
		rps=null;
	}

	@DataProvider(name="WinData")
	public Object[][] createWinData(){
		Object[][] tests ={
				{RSPEnum.ROCK,RSPEnum.SCISSORS},
				{RSPEnum.PAPER,RSPEnum.ROCK},
				{RSPEnum.SCISSORS,RSPEnum.PAPER}
		};
		return tests;
	}

	@DataProvider(name="TieData")
	public Object[][] createTieData(){
		Object[][] tests ={
				{RSPEnum.ROCK,RSPEnum.ROCK},
				{RSPEnum.PAPER,RSPEnum.PAPER},
				{RSPEnum.SCISSORS,RSPEnum.SCISSORS}
		};
		return tests;
	}
	@DataProvider(name="LostData")
	public Object[][] createLostData(){
		Object[][] tests ={
				{RSPEnum.ROCK,RSPEnum.PAPER},
				{RSPEnum.PAPER,RSPEnum.SCISSORS},
				{RSPEnum.SCISSORS,RSPEnum.ROCK}
		};
		return tests;
	}

		@DataProvider(name="testGame1")
	public Object[][] createDataGame1(){
		Player p1=new Player("winner");
		p1.setUpClass(true);
		Player p2=new Player("loser");
		p2.setUpClass(false);
		Object[][] tests ={
				{p1,p2}
		};
		return tests;
	}

	@DataProvider(name="testGame2")
	public Object[][] createDataGame2(){
		Player p1=new Player("winner");
		p1.setUpClass();
		Player p2=new Player("loser");
		p2.setUpClass();
		Object[][] tests ={
				{p1,p2}
		};
		return tests;
	}





	@Test(dataProvider="WinData")
	public void testWinPlay(RSPEnum p1, RSPEnum p2){
		assert Result.WIN.equals(rps.play(p1,p2));
	}
	@Test(dataProvider="TieData")
	public void testTiePlay(RSPEnum p1, RSPEnum p2){
		assert Result.TIE.equals(rps.play(p1,p2));
	}
	@Test(dataProvider="LostData")
	public void testLostPlay(RSPEnum p1, RSPEnum p2){
		assert Result.LOST.equals(rps.play(p1,p2));
	}

		@Test(dataProvider="testGame1")
	public void playGame1(Player p1, Player p2){
		assert Result.TIE.equals(rps.play(p1,p2));
	}

	@Test(dataProvider="testGame2")
	public void playGame2(Player p1, Player p2){
		rps.play(p1,p2);
		Result test=Result.LOST;
		if(p1.getScore()<p2.getScore()){
			test=Result.LOST;
			assert Result.LOST.equals(test);
		}
		else if(p1.getScore()>p2.getScore()){
			test=Result.WIN;
			assert Result.WIN.equals(test);
		}
		else if(p1.getScore()==p2.getScore()){
			test=Result.TIE;
			assert Result.TIE.equals(test);
		}

	}


}

