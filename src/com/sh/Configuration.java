package com.sh;

import com.sh.utils.Input;
import com.sh.utils.Output;

public class Configuration {
	private static final Configuration CONFIGURATION = new Configuration();

	private Configuration() {}

	public static Configuration getInstance() {
		return CONFIGURATION;
	}

	public Settings getSettings() {
		return new Settings(getInput(), getOutput());
	}

	private Input getInput() {
		return new Input();
	}

	private Output getOutput() {
		return new Output();
	}
}
