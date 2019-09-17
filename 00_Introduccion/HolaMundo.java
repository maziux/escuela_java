class HolaMundo{
	public static void main(String[] args){
		
		System.out.println("Hola Mundo!");
		String nombre = "Miguel";
		System.out.println("Hola " + nombre + "!");
		
		byte unByte = -128; // hasta 127 - 1 byte
		System.out.println("Byte: " + unByte);
		
		int entero = 1000; // 4 bytes
		System.out.println("Entero: " + entero);
		
		float decimalFloat = 1.234567890123456789f; // 4 bytes - 8 bits exp, 24 bits mantisa
		System.out.println("Decimal: " + decimalFloat);
		
		double decimalDoble = 0.123456789012345678901; // 8 bytes - 12 bits exp, 52 bits mantisa
		System.out.println("Doble: " + decimalDoble);
		
		long entLargo = 1234567890123456789L;
		System.out.println("entLargo: " + entLargo);
		
		char caracter = 65; //'z'
		System.out.println("caracter: " + caracter);
		
		{
			char[] texto = {'a','b','c'};
			System.out.println("texto: " + texto[1]);
			
			for(int i = 0; i < texto.length; i = i + 1)
				System.out.println("caracter: " + texto[i]);
		}
		
	}
}