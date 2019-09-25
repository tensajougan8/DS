/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ValdoVedank
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class combinations {
	HashMap<String, Integer> map2 = new HashMap<String, Integer>();
	HashMap<String, Integer> com3 = new HashMap<String, Integer>();
	HashMap<String, Integer> support = new HashMap<String, Integer>();
	ArrayList<String> predict1 = new ArrayList<String>();
	HashMap<String, Integer> confmap2 = new HashMap<String, Integer>();
	int counttrans = 0;

	public static void main(String[] args) {
		combinations test = new combinations();
		String ar1[];
		Scanner input = new Scanner(System.in);
		int i = 0, counttrans = 0, freq = 0;
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<String> arr1 = new ArrayList<String>();
		ArrayList<String> comb2 = new ArrayList<String>();
		ArrayList<String> comb3 = new ArrayList<String>();
		ArrayList<String> combof3 = new ArrayList<String>();
		ArrayList<String> pre = new ArrayList<String>();
		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
		HashMap<String, Integer> map3 = new HashMap<String, Integer>();
		HashMap<String, Integer> confmap = new HashMap<String, Integer>();
		HashMap<String, Integer> confmap2 = new HashMap<String, Integer>();

		LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
		try {
			BufferedReader in = new BufferedReader(new FileReader("E:\\r.txt"));

			String str = in.readLine();
			while ((str = in.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(str);

				st.nextToken();
				String ar = st.nextToken();
				st = new StringTokenizer(ar, ",");
				while (st.hasMoreTokens()) {
					String item = st.nextToken();
					if (map.containsKey(item)) {
						map1.put(item, map1.get(item) + 1);
					} else {
						map.put(item, i + 1);
						map1.put(item, 1);
						arr.add(item);
						i++;
					}

				}
				counttrans++;
			}
			in.close();

			System.out.println("________ID__________");

			int ID = 0;
			String key;

			for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
				key = entry.getKey();
				ID = entry.getValue();
				System.out.println(key + " : " + ID);
			}

			System.out.println();
			System.out.println("_______Occurance_________");

			int value = 0;

			for (HashMap.Entry<String, Integer> entry : map1.entrySet()) {
				key = entry.getKey();
				value = entry.getValue();
				System.out.println(key + " : " + value);
			}

			System.out.println();

			System.out.println("set: " + arr);
			System.out.println("transactions: " + counttrans);

			i = 0;
			int ite = ID;
			int ite2 = ID - 1;
			int ite3 = ID - 2;

			for (i = 0; i < ite; i++) {
				for (int k = i + 1; k < ite; k++) {
					comb2.add(arr.get(i) + " " + arr.get(k));
				}
			}

			System.out.println("comb of 2: " + comb2);

			for (i = 0; i < ite; i++) {
				for (int k = i + 1; k < ite; k++) {
					for (int l = k + 1; l < ite; l++) {
						if (!((arr.get(k).equals(arr.get(l)))))
							combof3.add(arr.get(i) + " " + arr.get(k) + " " + arr.get(l));
					}
				}
			}

			System.out.println("comb of 333: " + combof3);

			BufferedReader inn = new BufferedReader(new FileReader("E:\\r.txt"));

			String str1 = inn.readLine();
			while ((str1 = inn.readLine()) != null) {
				StringTokenizer st1 = new StringTokenizer(str1);

				st1.nextToken();
				String ar12 = st1.nextToken();
				st1 = new StringTokenizer(ar12, ",");
				while (st1.hasMoreTokens()) {
					String item = st1.nextToken();
					arr1.add(item);
				}

				// System.out.println("arr1" + arr1);
				test.arraycompare(arr1, comb2);
				test.comparearray3(arr1, combof3);
				arr1.clear();

			}
			inn.close();

			// support
			int ID1;
			float g = 0;

			for (HashMap.Entry<String, Integer> entry : test.map2.entrySet()) {
				key = entry.getKey();
				ID1 = entry.getValue();
				System.out.println(key + " : " + ID1);

				// System.out.println(ID1 + " support " + counttrans);
				g = (float) ID1 / counttrans * 100;
				// System.out.println(key + " support " + g);
				if (g > 60) {
					test.support.put(key, (int) g);
					System.out.println(key + " >60 " + g);
				}

			}
				for (HashMap.Entry<String, Integer> entry : test.com3.entrySet()) {
				key = entry.getKey();
				ID1 = entry.getValue();
				System.out.println(key + " : " + ID1);

				// System.out.println(ID1 + " support " + counttrans);
				g = (float) ID1 / counttrans * 100;
				// System.out.println(key + " support " + g);
				if (g > 10) {
					test.support2.put(key, (int) g);
					System.out.println(key + " > " + g);
				}

			}

			// conf
			int ID2;
			float ID3 = 0;
			int countmaps = 0;
			for (HashMap.Entry<String, Integer> entry : map1.entrySet()) { // occurance deno
				for (HashMap.Entry<String, Integer> entry2 : test.map2.entrySet()) // comb num
				{
					String key1 = entry.getKey();
					String key2 = entry2.getKey();
					if (key2.contains(key1)) {
						ID1 = entry.getValue();
						ID2 = entry2.getValue();
						ID3 = (float) ID2 / ID1 * 100;
						if (ID3 > 60 && ID3 <= 100) {

							String item1 = entry2.getKey() + "=>" + entry.getKey();
							confmap.put(item1, (int) ID3);

						}
					}
					// System.out.println("ID2/ID1=ID3:"+ID2+" "+ID1+" "+ID3);

				}
			}

			for (HashMap.Entry<String, Integer> entry : confmap.entrySet()) {
				key = entry.getKey();
				ID1 = entry.getValue();
				System.out.println("confmap:" + key + " : " + ID1);
			}

			for (HashMap.Entry<String, Integer> entry1 : test.com3.entrySet()) {
				key = entry1.getKey();
				value = entry1.getValue();
				System.out.println(key + " : " + value);
			}
			for (HashMap.Entry<String, Integer> entry : test.com3.entrySet()) { // occurance deno
				for (HashMap.Entry<String, Integer> entry2 : test.map2.entrySet()) // comb num
				{
					String key1 = entry2.getKey();
					String key2 = entry.getKey();
					if (key2.contains(key1)) {
						ID1 = entry2.getValue();
						ID2 = entry.getValue();
						String[] splitStr = key2.split("\\s+");
						ID3 = (float) ID2 / ID1 * 100;
						if (ID3 > 70 && ID3 <= 100) {
							 for (i = 0; i < splitStr.length; i++) {
							 if (key1.contains(splitStr[i])) {
							 } else {
							String item1 = entry2.getKey() + "=>" + entry.getKey(); // splitStr[i];
							test.confmap2.put(item1, (int) ID3);

							}
							 }

						}
					}
				}
			}
			for (HashMap.Entry<String, Integer> entry : confmap2.entrySet()) {
				key = entry.getKey();
				ID1 = entry.getValue();
				System.out.println("confmap2:" + key + " : " + ID1);
			}
			boolean a = false;
			try {
				while (!a) {
					for (i = 0; i < arr.size(); i++) {
						System.out.println(i + " " + arr.get(i));
					}

					System.out.println("Enter any item you want to choose");
					int num = input.nextInt();
					pre.add(arr.get(num));
					test.predict(arr, num);
					System.out.println("Customers have also bought these items");
					for (i = 0; i < test.predict1.size(); i++) {
						System.out.println(i + " " + test.predict1.get(i));

					}
					a = true;
				}
				/*
				 * num = input.nextInt(); pre.add(test.predict1.get(num));
				 * test.predict2(test.predict1, num); for (i = 0; i < test.predict1.size(); i++)
				 * { System.out.println(i + "" + test.predict1.get(i)); }
				 */
			} catch (IndexOutOfBoundsException f) {
				System.out.println("The number isnt displayed, you dumbfuck!!");
				a = false;
			}

		} // try block
		catch (IOException e) {

		} // catch close

	} // Closing bracket for main class

	public void predict2(ArrayList<String> predict12, int num) {
		// TODO Auto-generated method stub
		String al = predict12.get(num);
		for (HashMap.Entry<String, Integer> entry : confmap2.entrySet()) {
			String key = entry.getKey();

			if (key.contains(al)) {
				String[] splitStr = key.split("\\s+");
				for (int i = 0; i < splitStr.length; i++)
					if (splitStr[i].equals(al) || splitStr[i].equals(predict1.get(i))) {

					} else {
						predict1.add(splitStr[i]);
					}
			}

		}
	}

	public void predict(ArrayList<String> arr, int num) {
		// TODO Auto-generated method stub
		String al = arr.get(num);
		for (HashMap.Entry<String, Integer> entry : support.entrySet()) {
			String key = entry.getKey();

			if (key.contains(al)) {
				String[] splitStr = key.split("\\s+");
				for (int i = 0; i < splitStr.length; i++)
					if (splitStr[i].equals(al) && splitStr[i].equals(al)) {

					} else {
						predict1.add(splitStr[i]);
					}
			}
			// System.out.println("confmap2:" + key + " : " + ID1);
		}

	}// end of predict function

	public void arraycompare(ArrayList<String> arr1, ArrayList<String> arr2) {
		// TODO Auto-generated method stub
		int i = 0;
		int count = 0;

		int ID = 0;
		int ite = ID;

		ArrayList<String> comb3 = new ArrayList<String>();
		for (i = 0; i < arr1.size(); i++) {
			for (int k = i + 1; k < arr1.size(); k++) {
				comb3.add(arr1.get(i) + " " + arr1.get(k));

			}
		}

		for (i = arr1.size() - 1; i > 0; i--) {
			for (int k = i - 1; k >= 0; k--) {
				comb3.add(arr1.get(i) + " " + arr1.get(k));
			}
		}
		// System.out.println("comb new"+comb3);

		for (i = 0; i < comb3.size(); i++) {
			for (int j = 0; j < arr2.size(); j++) {
//                 System.out.println("comb 3"+comb3.get(i));
//                 System.out.println("arr2 "+arr2.get(j));
				if (comb3.get(i).equals(arr2.get(j))) {
					// count++;
					// System.out.println("comb 3"+comb3.get(i));
					// System.out.println("arr2 "+arr2.get(j));
					// System.out.println("count"+count);
					if (map2.containsKey(comb3.get(i))) {
						map2.put(comb3.get(i), map2.get(comb3.get(i)) + 1);

					} else {
						map2.put(comb3.get(i), 1);

					}

				}

			}

		}
//        String key;
//        int ID1;
//
//        for (HashMap.Entry< String, Integer> entry : map2.entrySet()) {
//            key = entry.getKey();
//            ID1 = entry.getValue();
//            System.out.println(key + " : " + ID1);
//        }

	}// Closing bracket for function

	public void comparearray3(ArrayList<String> arr1, ArrayList<String> arr3) {
		Outer: for (int i = 0; i < arr3.size(); i++) {
			String is = arr3.get(i);
			int count = 0;
			Inner: for (int j = 0; j < arr1.size(); j++) {
				String is2 = arr1.get(j);

				if (is.contains(is2)) {
					count++;

				}
				if (count == 3) {
					if (com3.containsKey(is)) {
						com3.put(is, com3.get(is) + 1);
					} else {
						com3.put(is, 1);
					}
					break;
				}
			}
		}
	}// Closing bracket for function comparearray3

}// Closing bracket for class
