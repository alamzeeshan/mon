package com.capcom.monitoring.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Test {
	
	
	public static void main(String[] args) {
		
		
		Map<Integer, String> map = new HashMap<>();
		
		String aa = map.put(100, "Zeeshan");
		
		System.out.println(aa);
		
		map.put(200, "alam");
		map.put(21200, "adasd");
		map.put(11200, "45tf");
		String bb = map.put(100, "Rameez");
		System.out.println(bb);
		
		System.out.println(map);
		
		
		System.out.println(map.get(200));
		System.out.println(map.get(121212200));
		
		
	}
	
	
	
	
	
	
	

	public static void main1(String[] args) {
		String[] array = {"apm","ftgei","click2compute","itecalm","ftgops","itecudeploy","itecstash","akamai"
				+ "ngcc","openstack","citrix","oltx","netbenefits","coreops","seiops"};
		
		int[] costarray = {14300, 23400, 34400,12300,45400,96700,83600,57500,95900,34500,56500,56700,23900,39800};

		/*for (String s : array) {			
			System.out.println(s);			
		}*/
		
		/*List<Integer> list = new ArrayList<>(500);
		for (int i =0; i < 500; i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(0, 13 + 1);
			list.add(randomNum);
		}
		System.out.println(list);*/
		
		
		int count = 224466;
		for (int i =0; i < 25; i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(0, 13 + 1);
			String name = "vos"+count;
			count++;
			//System.out.println(name);
			System.out.println(name +"\t"+costarray[randomNum] + "\t"+array[randomNum]);
		}
		
		System.out.println(array.length);
		
	}

}
