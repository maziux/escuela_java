class EstructurasControl{
	public static void main(String[] args){
		
		/*
		for (int i = 0; i < args.length; i++){
			System.out.println("Arg " + i);
			System.out.println("Arg " + args[i]);
		}
		*/
		
		int i = 0;
		while(i < args.length){
			System.out.println("Arg " + i);
			System.out.println("Arg " + args[i]);
			i++;
		}

		i = 0;
		/*
		for ( ; i < args.length; ){
			System.out.println("Arg " + i);
			System.out.println("Arg " + args[i]);
			i++;
		}
		*/
		
		do {
			System.out.println("Siempre muestra");
		} while(false);
		
		boolean siEjecutar = 5 < 3 && 20 == 20;
		
		if(siEjecutar)
			System.out.println("La condicion es true");
		else // else if 
			System.out.println("La condicion es false");
			
		int valor = 1;
		switch (valor) {
			case 0:
				System.out.println("Valor cero");
				break;
			case 1:
				System.out.println("Valor uno");
				break;
			case 2:
				System.out.println("Valor dos");
				break;
			default:
				System.out.println("otro valor");
				break;
		}
		
		
	}
}