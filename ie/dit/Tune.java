package ie.dit;

public class Tune implements Player{
	
	private int x;
	private String title;
	private String alTitle = "";
	private String notation;

	public Tune(){

	}

	public void play(){
		
		TuneBook tune = new TuneBook("hnj0.abc");

		tune.toString();
	}

	public int getX(){
		return x;
	}
	public String getTitle(){
		return title;
	}
	public String getalTitle(){
		return alTitle;
	}
	public String getNotation(){
		return notation;
	}
	public void setX(int element){
		this.x = element;

	}
	public void setTitle(String element){
		this.title = element;
	}
	public void setalTitle(String element){
		this.alTitle = element;
	}

	public String toString(){
		if(alTitle = ""){
			return String.format("%d, %s", x, title);

		}
		else
		{
			return String.format("%d, %s, %s", x, title, alTitle);
		}
	}


}