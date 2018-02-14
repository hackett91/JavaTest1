package ie.dit;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.BufferedWriter;
import java.util.Scanner;


public class TuneBook{

	ArrayList<Tune> tunes = new ArrayList<Tune>();

	String abc;


	// abc represent the file in which I should load


	 public static void main(String[] args)
    {
        TuneBook tb = new TuneBook("hnj0.abc");
        System.out.println(tb);

        Tune t = tb.findTune("Scotsman over the Border");
        t.play();
    }

	public TuneBook(String abc){

		this.abc = abc;

	}

	public Tune findTune(String tune){

		Tune tune_ob = new Tune();

		String compare;

		for(Tune tune_ob: tunes)
		{
			compare = tune_ob.getTitle();

			if(compare.equal(tune)){
				return tune;
			}
			else
			{
				return null;
			}


		}

	}

	public String toString(){


		// most effiencient way to implement string
		StringBuffer sb = new StringBuffer();
		String lineup;

		// use the getter to extract the field out of the object to display in string


		for(Tune line:tunes)
		{
			if((lineup =line.getTitle())== "X")
			{
				sb.append(lineup + ", ");
			}
		}

		return sb.toString();
	}
	}

	  public void loadFile()
	  {
	  		//initially
	  	Tune tune;
	  	int x_count = 0;
	  	int t_count = 0;

	    BufferedReader myText = null; 

	    try{

		      myText = new BufferedReader(new FileReader(this.abc));
		      String l;

		      while ((l=myText.readLine())!=null )
		       {
		        if(startWith(l) == "X")
		        {
		        	tune.setX(l);
		        	x_count++;
		        }
		        if(startWith(l) == "T")
		        {
		        	t_count++;
		 
		        	if(t_count ==  1)
		        	{
		        		tune.setTitle(l);
		        		tune.setalTitle(null);
		        	}
		        	else if(t_count == 2)
		        	{
		        		tune.setalTitle(l);
		        		t_count = 0;
		        	}

		        }
		        if(x_count == 1)
		        {
		        	tunes.add(tune);
		        	x_count =0;
		        }
		      }
	    	}

	    	
	    
			catch(IOException e)
		{
  			e.printStackTrace();
		}
		finally
		{
  			if (myText!=null) 
  			{
    			try
    			{
      					myText.close();
    			}
    			catch(Exception e)
    			{
        			e.printStackTrace();
        		}
      		}
    	}
  }

	



}