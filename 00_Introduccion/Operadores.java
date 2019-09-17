class Operadores {
	public static void main(String[] args){
		
		if ("aa".equals(args[0])) {
			System.out.println("Quieres dos AA");
		} else {
			System.out.println("Quieres otra cosa");
		}
		
		// Operador ternario
		System.out.println( 5 != 5 ? "Pues si" : "Pues no");
		
		System.out.println( "aa".equals(args[0]) ? "Quieres dos AA" : "Quieres otra cosa" );
		
		// Operadores bit a bit: & | ^
		byte result = 113 & 199;
		System.out.println("AND binario: " + result);
		
	}
}