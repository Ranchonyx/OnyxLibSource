package com.onyxlib.RandomChars;
import java.util.concurrent.ThreadLocalRandom;
public class RandomChars {
	private char[] alpha = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private char[] ownArray;
	public RandomChars(char[] pOwnArray) {
		this.ownArray = pOwnArray;
	}
	public RandomChars() {}
	public char getRandomChar() {
		if(ownArray != null) {
			char current = ownArray[ThreadLocalRandom.current().nextInt(0, ownArray.length)];
			return current;
		} else {
			char _current = alpha[ThreadLocalRandom.current().nextInt(0, alpha.length)];
			return _current;
		}
	}
}
