console.log("Hola que hay");
var directorio = process.cwd();
console.log("directorio: " + directorio);
console.log("Uso CPU: " + process.cpuUsage());
console.log("Uso User: " + process.cpuUsage().user);
