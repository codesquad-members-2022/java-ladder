class OutView {
	void print(String[][] ladder){
		for(String[] row : ladder){
			for(String line : row){
				System.out.print(line);
			}
			System.out.println();
		}
	}
}
