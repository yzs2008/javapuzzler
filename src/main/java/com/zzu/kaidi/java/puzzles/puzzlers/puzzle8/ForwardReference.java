package com.zzu.kaidi.java.puzzles.puzzlers.puzzle8;

public class ForwardReference {

	static {
		i=0;
		//System.out.println(i);//forward reference
	}
	static int i=1;
}
