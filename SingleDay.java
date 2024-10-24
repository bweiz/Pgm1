
public class SingleDay implements Comparable<SingleDay> {
	
	private String continent;
	private String country;
	private String date;
	private int total_cases;
	private int new_cases;
	private Long population;
	
	public SingleDay(String[] item) {
		String continent = item[0];
		String country = item[1];
		String date = item[2];
		int total_cases = Integer.parseInt(item[3]);
		int new_cases = Integer.parseInt(item[4]);
		Long population = Long.parseLong(item[5]);
	}
	
	public int compareTo(SingleDay Day) {
		if (this.new_cases < Day.new_cases) return -1;
		else if (this.new_cases > Day.new_cases) return 1;
		else return 0;
	}
	
	public int getNewCases() {
		return new_cases;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void printDay() {
		System.out.println("New Cases: " + new_cases + " at " + country + "/" + continent + " on " + date + " Total " + total_cases + " Pop: " + population);
	}
	
}
