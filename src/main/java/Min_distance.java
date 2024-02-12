
public class Min_distance {
	public double distanceInKilometerByHaversine(double x1, double y1, double x2, double y2) {
	    double distance;
	    double radius = 6371; // 지구 반지름(km)
	    double toRadian = Math.PI / 180;

	    System.out.println("x1: " + x1 + " " +"y1: "+y1);
	    System.out.println("x2: " + x2 + " " + "y2: "+y2);
	    
	    double deltaLatitude = Math.abs(x1 - x2) * toRadian;
	    double deltaLongitude = Math.abs(y1 - y2) * toRadian;

	    double sinDeltaLat = Math.sin(deltaLatitude / 2);
	    double sinDeltaLng = Math.sin(deltaLongitude / 2);
	    double squareRoot = Math.sqrt(
	        sinDeltaLat * sinDeltaLat +
	        Math.cos(x1 * toRadian) * Math.cos(x2 * toRadian) * sinDeltaLng * sinDeltaLng);

	    distance = 2 * radius * Math.asin(squareRoot);

	    return Math.round(distance*Math.pow(10, 4)/100.0);
	}
}
