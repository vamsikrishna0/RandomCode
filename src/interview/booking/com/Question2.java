package interview.booking.com;

import java.util.HashSet;
import java.util.Scanner;

public class Question2 {

	
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<String> favPassions = new HashSet<>();
        for(int i=0; i<n; i++){
        	int m = sc.nextInt();
        	
        	while(m > 0){
        		favPassions.add(sc.next());
        		m--;
        	}
        }
        int y = sc.nextInt();
        Destination[] destinations = new Destination[y];
        int p = 0;
        int noOfDestinations = y;
        while(y > 0){
        	Destination x = new Destination(sc.next(),sc.nextDouble(),sc.nextDouble());
        	int z = sc.nextInt();
        	while(z>0){
        		x.getPassions().add(sc.next());
        		z--;
        	}
        	destinations[p] = x;
        	p++;
        	y--;
        }
        
        int maxCommonPasssions = 0;
        Destination favDestinationsPair1 = new Destination();
        Destination favDestinationsPair2 = new Destination();
        for(int j=0; j<noOfDestinations; j++){
        	for(int k=0; k<noOfDestinations; k++){
        		if(j != k && j < k){
        			HashSet<String> commonPassions = new HashSet<>();
        			commonPassions.addAll(destinations[j].passions);
        			commonPassions.addAll(destinations[k].passions);
        			int count = 0;
        			for(String x : commonPassions){
        				if(favPassions.contains(x)){
        					count++;
        				}
        			}
        			if(count > maxCommonPasssions){
        				favDestinationsPair1 = destinations[j];
        				favDestinationsPair2 = destinations[k];
        				maxCommonPasssions = count;
        			}else if(count == maxCommonPasssions){
        				if(distance(favDestinationsPair1, favDestinationsPair2) > distance(destinations[j], destinations[k])){
        					favDestinationsPair1 = destinations[j];
            				favDestinationsPair2 = destinations[k];
        				}
        			}
        		}
        	}
        }
        
        if(favDestinationsPair1.name.compareTo(favDestinationsPair2.name) > 0)
        	System.out.println(favDestinationsPair2.name + " "+ favDestinationsPair1.name);
        else
        	System.out.println(favDestinationsPair1.name + " "+ favDestinationsPair2.name);
        sc.close();
    }
    public static double distance(Destination point1, Destination point2){
    	   int EARTH_RADIUS = 6371;//in km
    	    double point1_lat_in_radians  = Math.toRadians( point1.latitude );
    	    double point2_lat_in_radians  = Math.toRadians( point2.latitude );
    	    double point1_long_in_radians  = Math.toRadians( point1.longitude );
    	    double point2_long_in_radians  = Math.toRadians( point2.longitude );
    	    return Math.acos( Math.sin( point1_lat_in_radians ) * Math.sin( point2_lat_in_radians ) +
    	                 Math.cos( point1_lat_in_radians ) * Math.cos( point2_lat_in_radians ) *
    	                 Math.cos( point2_long_in_radians - point1_long_in_radians) ) * EARTH_RADIUS;
    }
}

class Destination{
	String name;
	double latitude;
	double longitude;
	HashSet<String> passions = new HashSet<>();
	public Destination(){
		
	}
	public Destination(String name, double latitude, double longitude) {
		super();
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the passions
	 */
	public HashSet<String> getPassions() {
		return passions;
	}
	/**
	 * @param passions the passions to set
	 */
	public void setPassions(HashSet<String> passions) {
		this.passions = passions;
	}
	
}
