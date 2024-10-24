import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Driver {
	public static void main(String[] args) throws IOException {
		BST<SingleDay> daysTree = new BST<SingleDay>();
		Map<String, MinPQ<SingleDay>> countryMap = new HashMap<String, MinPQ<SingleDay>>();
		String line;
		
		try (BufferedReader in = new BufferedReader(new FileReader("owid-covid-data.csv"))) {				// New buffer reader to read csv file
			in.readLine();																					// skip first line
			
			while ((line = in.readLine()) != null) {
				String[] dayString = line.split(",");
				SingleDay day = new SingleDay(dayString);
				MinPQ<SingleDay> mpq = countryMap.computeIfAbsent(dayString[1], k -> new MinPQ<SingleDay>());
				mpq.insert(day);
				
				if (mpq.size() > 3) {
					mpq.delMin();
				}


			}
			
			for (Map.Entry<String, MinPQ<SingleDay>> s : countryMap.entrySet()) {							// Fill up Binary Search Tree
				MinPQ<SingleDay> mpq = s.getValue();
				while(mpq.size() != 0) {
					daysTree.put(mpq.delMin());
					
				}
			}

			try (BufferedWriter out = new BufferedWriter(new FileWriter("pgm1_output.txt"))) {
				for (Object s : daysTree.OrderedTraversal("In")) {
					out.write((String) s);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		

		
	}
}
