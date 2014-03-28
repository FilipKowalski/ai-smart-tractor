package com.dszi.randomizer;

import com.dszi.utils.RandomUtils;

public class RandomGroundGenerator {

	public static String generateIrrigation() {
		return Integer.toString(RandomUtils.getRandomNumber()) + "%";
	}
	
	public static String generateSoilDesctruction() {
		return Integer.toString(RandomUtils.getRandomNumber()) + "%";
	}
	
	public static String generateNumberOfPests() {
		return Integer.toString(RandomUtils.getRandomNumber());
	}
}
