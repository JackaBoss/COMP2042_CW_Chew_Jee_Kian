package main;

import main.MyStage;
import main.BackgroundImage;
import main.End;


public abstract class GenerateLevel {
	private final int WaterLevel;
	private final int EndGoals;
	protected final MyStage Background;
	private Boolean PlayMusic;



	protected GenerateLevel(int waterLevel, int noOfGoals, MyStage base, String BackgroundImage, Boolean playMusic) {
		WaterLevel = waterLevel;
		EndGoals = noOfGoals;
		Background = base;
		PlayMusic = playMusic;
		Background.add(new BackgroundImage(BackgroundImage));
		generateEnd(EndGoals);
	}
	
	public int getWaterLevel() {
		return WaterLevel;
	}
	
	public int getEndGoals() {
		return EndGoals;
	}
	
	public boolean isEndGoalComplete() {
		for (final End end : Background.getObjects(End.class)) {
			if (!end.isActivated()) 
				return false;
		}
		return true;
	}
	
	protected abstract void generateRow1();
	protected abstract void generateRow2();
	protected abstract void generateRow3();
	protected abstract void generateRow4();
	protected abstract void generateRow5();
	protected abstract void generateRow6();
	protected abstract void generateRow7();
	protected abstract void generateRow8();
	protected abstract void generateRow9();
	
	private void generateEnd(int count) {
		for(int i = 0; i < count; i++) {
			Background.add(new End((BackgroundImage.width / (count * 2)) + (BackgroundImage.width / count) * i - 35, 96));
		}	
	}
	
	
	protected final void generateAllRows() {
		generateRow1();
		generateRow2();
		generateRow3();
		generateRow4();
		generateRow5();
		generateRow6();
		generateRow7();
		generateRow8();
		generateRow9();
	}
	
	
	public Boolean getPlayMusic() {
		return PlayMusic;
	}
}