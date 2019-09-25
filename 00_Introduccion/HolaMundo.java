/** 
 * Clase de introduccion
 * @author German C R
 */
class HolaMundo {
	/** 
	 * Metodo de inicio de programa
	 */
	public static void main(String[] args) {
		System.out.println("Hola mundo!");
		String nombre = "German";		
		System.out.println("Hola " + nombre + "!");
		byte unByte = -128;	// hasta 127
		System.out.println("Byte: " + unByte);
		// Comentario hasta final de linea
		/* Comentario varias 
		lineas */
		int numero = 1234567890;
		System.out.println("Entero: " + numero);
		float decimalFloat = 123456789012345f;
		System.out.println("float: " + decimalFloat);
		double decimalDoble = 1.234567890123456789;
		System.out.println("double: " + decimalDoble);
		
		//{
			long entLargo = 1234567890123456789L;	// Trillones
		//}
		System.out.println("entLargo: " + entLargo);

		char caracter = 110; // 'z'
		System.out.println("caracter: " + caracter);
		{	// Bloque instruccion
			char[] texto = {'a', 'b', 'c'};
			for (int i = 0; i < texto.length; i = i + 1)
				System.out.println("caracter: " + texto[i]);
		}
	}
}






