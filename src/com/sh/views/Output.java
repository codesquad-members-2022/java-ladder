package com.sh.views;

import java.util.function.Consumer;

public class Output {

	public static Consumer<String> print = (text) -> System.out.print(text);
	public static Consumer<String> println = (text) -> System.out.println(text);
	public static Consumer<Object> prints = (obj) -> System.out.println(obj);

}
