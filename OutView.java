class OutView {
	void print(char[][] ladder){
		for(char[] row : ladder){
			for(char line : row){
				System.out.print(line);
			}
			System.out.println();
		}
	}
}
