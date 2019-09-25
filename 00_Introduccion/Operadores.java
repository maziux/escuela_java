class Operadores {
	public static void main(String[] argumentos) 
	{
		System.out.println("Has puesto " + argumentos[0]);
		System.out.println( 5 != 5  ?  "Pues si"  : "Pues no");

		if ("aa".equals(argumentos[0]))
			System.out.println("Quieres dos AA");
		else
			System.out.println("Quieres otra cosa");
		
		System.out.println("Quieres dos " 
			+ ("aa".equals(argumentos[0]) ? "AA" : "otra cosa"));
		int i = 1, j = 2;
		String resultado = 
			(34 / 43) > 1 ? "--" 
			: (i == j) ? "i = j" 
			: (i == j+1) ? "i = j"
			: "por defecto" ;
		
		byte result = 113 & 199;
		System.out.println("AND binario = " + result);
		
		
	}
}