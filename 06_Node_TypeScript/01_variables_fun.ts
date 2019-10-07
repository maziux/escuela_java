var hola = "Hola";
console.log("Guay " + hola);
function otroHola(saludo) {
	console.log("Saludo " + saludo);
}
otroHola(" adios JS!");

let variableNum:number;
variableNum = 100;
console.log(variableNum);

let miUnion: number | string | boolean;
miUnion = true;
miUnion = "...";
miUnion = 34;

interface Tiempo {
	dia: number;
	mes: number;
	anio: number;
};

let miCumple:Tiempo = {dia: 7, mes: 12, anio:87};
console.log("Cumple el " + miCumple.dia + " del " + miCumple.mes + " del " + miCumple.anio);

// any: tipo que puede ser de cualquier tipo
function concatenar(texto1:string, texto2:any) {
	console.log("Concatenado: " + texto1 + texto2);
}

concatenar("total, ", "que recibe una cosa");
concatenar("u otra, ", 200);