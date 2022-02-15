class OutView {
	void print(char[][] ladder){
		for(char[] row : ladder){
			printRow(row);
		}
	}

	void printRow(char[] row){
		for(char character : row){
			System.out.print(character);
		}
		System.out.println();
	}
}
