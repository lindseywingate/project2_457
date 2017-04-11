
package finalProj;

/**
 *
 * @author Dakota Krout
 */
import java.util.Random;

public class Aircraft
{
	private String name;		
	private int altitude;		
	private int heading;		
	private int speed;		
	private boolean arriving;	
	private String airport;		
	private int[] location;		
	static int aircraftNumber = 222;			
        
	static String[] airports = {"MSP","MOT","GFK","DEN","RDU","ORL","PFN"};	

	private String[] letters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

	public Aircraft(String name, int altitude, int heading, int speed, boolean arriving, String airport)
	{
		this.name = name;
		this.altitude = altitude;
		this.heading = heading;
		this.speed = speed;
		this.arriving = arriving;
		this.airport = airport;
	}

	//make this create random aircraft
	public Aircraft()
	{
		Random rand  = new Random();
		this.name = "AA"+aircraftNumber;
		aircraftNumber++;

		//randomize these values
		
		this.altitude = rand.nextInt(9900)+100;
		this.heading = rand.nextInt(360);
		this.speed = rand.nextInt(400)+100;
		this.arriving = rand.nextBoolean();
		this.airport = airports[rand.nextInt(airports.length)];
		
		
	}

	public String getName()
	{
		return name;
	}

	public int getAltitude()
	{
		return altitude;
	}

	public int getHeading()
	{
		return heading;
	}	

	public int getSpeed()
	{
		return speed;
	}

	public boolean isArriving()
	{
		return arriving;
	}

	public String getAirport()
	{
		return airport;
	}

	public int[] getLocation()
	{
		return location;
	}

	public void setLocation(int[] location)
	{
		this.location = location;
	}

	public void setLocation(int x, int y)
	{
		this.location[0] = x;
		this.location[1] = y;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setAltitude(int altitude)
	{
		if(altitude > 0 && altitude <= 40000)
			this.altitude = altitude;
	}

	public void setHeading(int heading)
	{
		if(heading >= 0 && heading < 360)
			this.heading = heading;
	}	

	public void setSpeed(int speed)
	{
		if(speed > 0)
			this.speed = speed;
	}

	public void setArriving(boolean arriving)
	{
		this.arriving = arriving;
	}

	public void setAirport(String airport) throws Exception
	{
		if(airport.length() == 3)
                {
			this.airport = airport;
                }
                else 
                {
                    throw new Exception("Airport codes must have 3 letters");
                }
	}
        
        @Override
        public boolean equals(Object other)
        {
            if(other instanceof Aircraft)
            {
                return this.getName().equals(((Aircraft)other).getName());
            }    
            return false;
        }
        
        public int compareTo(Aircraft other)
        {
            return this.getName().compareTo(other.getName());
        }
}