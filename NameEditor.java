class NameEditor {
	private boolean isValidate(String name){
		if(name.length() > 5){
			return false;
		}
		return true;
	}

	private String shortenName(String name){
		String shortName = name.substring(0, 5);
		return shortName;
	}

	private String extendName(String name){
		String extendedName = name + " ".repeat(5-name.length());
		return extendedName;
	}
}
