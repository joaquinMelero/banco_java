// FUNCIONES
package jmelero_funciones;

import java.util.Scanner;


public class Jmelero_funciones {

//función para verificar entrada por teclado de un entero, con minimo 
     public static int verificarInt(String mensaje, int minimo){
         Scanner teclado = new Scanner (System.in);
         int numero;
         do{
            System.out.println(mensaje); 
            while(!teclado.hasNextInt()){
                System.out.println("Error " + mensaje);
                teclado.next();
            }  
        numero = teclado.nextInt();
        }while(numero<minimo);
        return numero;
     }
     
     //función para verificar letra sin mínimo ni maximo
     public static int verificarIntSin(String mensaje){
         Scanner teclado = new Scanner(System.in);
         int numero;
            System.out.println(mensaje);
            while(!teclado.hasNextInt()){
                System.out.println("Error " + mensaje);
                teclado.next();
            } 
         numero = teclado.nextInt();
         return numero;
     }
     
     //funcion validar numero entero y no letras con minimo y maximo 
     public static int validarIntCompleta(String mensaje, int minimo, int maximo){
         Scanner teclado = new Scanner(System.in);//creo escaner para leer por teclado
         int numero;//definimos la variable numero
         do{// bucle hacer
           System.out.println(mensaje);//mensaje que nos solicitara introducir en el programa
           while(!teclado.hasNextInt()){//mientras que el dato inntroducido no sea un numero
               System.out.println("Error número no correcto, ");//mensaje que se muestra de error
               teclado.next();//solicitamos introducir otro numero
           }
         numero = teclado.nextInt();// indicamos que la variable numero toma el valor introducido por teclado
         }while((numero>maximo)||(numero<minimo));//definimos el minimo y maximo 
         return numero;
     }
     
     //fucion para verificar double si minimo ni maximo
     public static double verificarDouble(String mensaje){
         Scanner teclado = new Scanner(System.in);//crear escaner para teclado
         double numero;//definimos variabe numero
         System.out.println(mensaje);//mensaje que se introduce desde el programa
             while(!teclado.hasNextDouble()){//mientras el dato introducido no sea double
                 System.out.println("Error, número incorrecto");//muestra elmensaje de error
                 teclado.next();//pide siguiente entrada
             }
         numero = teclado.nextDouble();//variable numero toma el valor de entrada de teclado
         return numero;
    }
     
     //funcion verificar double con minimo
     public static double verificarDoubleMin(String mensaje, double minimo){
         Scanner teclado = new Scanner(System.in);//creamos escaner de teclado
         double numero;//definimos variable numero
         do{
            System.out.println(mensaje);//mensaje que se introduce desde el programa
            while(!teclado.hasNextDouble()){//mientras que el dato introducido no sea numero double
                System.out.println("Error, número incorrecto, introduce otro: ");//mensaje de error que se muestra
                teclado.next();//se introduce otro dato
            }
         numero = teclado.nextDouble();//variable numero toma valor de dato introducido por teclado   
            }while(numero<minimo);
         return numero;//devuelve la variable numero 
         }
     
     //funcion verificar Double con min y max
     public static double verificarDoubleMinMax(String mensaje, double minimo, double maximo){
         Scanner teclado = new Scanner (System.in);//crear escaner de teclado
         double numero;//definir variable 
         do{
            System.out.println(mensaje);//mensaje para programa
            while(!teclado.hasNextDouble()){//mientras el dato introducido por teclado no sea numero double
                System.out.println("Error, numero incorrecto");//mensaje de error que se muestra
                teclado.next();//pide el siguiente numero
            }
         numero = teclado.nextDouble();//variable numero toma el valor de la entrada del teclado
         }while((numero<minimo)||(numero>maximo));
         return numero;        
     }
                  
     //función área Triángulo
     public static double areaTriangulo (double b, double h) {    
        double area;
        area= (b*h)/2;
        return area; 
     }
    //función volumen Cono
     public static double volumenCono(double r, double h){
        double volumen; 
        volumen = (Math.PI*(r*r)*h)/3;
        return volumen;
   }
     //función ejercicio es bisiesto
     public static boolean esBisiesto (int año){
         boolean bisiesto = false;//define variable bisiesto como boolean y se inicia en false
         if(año<=0){
             throw new IllegalArgumentException("El año introducido no puede ser menor que 0");
         }
         if(bisiesto = (año%4==0) && (año%100!=0) || (año%400==0)){// si cumple estas condiciones es bisisesto, la variable toma valor true
             bisiesto = true;
         }
         return bisiesto; 
     }
     
     //fución resolver ecuación de primer grado
     public static double ecuacionPrimerGrado(double a, double b){
         double x;
         x = -b/a;
         if (x>=0){
             System.out.println("La solución es: "+ x);
         }else{
             System.out.println("No tiene solución real: " + x);
         }
         return x;
     }
     
     //función para resolver potencia y=x^n
     public static double potencia(double base, int exponente){
         double y=1;//definimos variable y 
         for(int i=1; i<=exponente; i++){
             y = y*base;   
         }
         return y;
     }
     
     //funcion numero de cifras
     public static int numeroCifras(int numero){
         int cifra = 1;//definimos variable cifra y se inicia a 1
         while(numero>10){//mientras que el numero sea mayor que 10 se divide por este
             numero = numero /10;
             cifra = cifra + 1;//cifra es el contador  
         }
         return cifra;
     }
     
     //funcion es capicua 
     public static boolean esCapicua(int numero){
         boolean esCapicua=false;//definimos variable esCapicua como boolean
         int invertido = 0, resto;// definimos variables invertido, resto
         int numero1 = numero;//creo variable numero1 para guardar el numero introducido
         
         while(numero>0){//mientras el numero sea mayor que 0
             resto = numero % 10;//el resto es la primera cifra del inverso
             invertido = invertido*10 + resto;//la variable invertido guarda las cifras
             numero = numero/10;//dividimos por 10 para la sigueinte cifra 
             }
         if(numero1==invertido){
             esCapicua = true;
         }
         return esCapicua;
        
     }
     
     //funcion para clacular precio de llamada
     public static double costeLlamadaTelefonica(int segundos){
         int minutos = segundos/60;//definimos e iniciamos variable minutos
         int segundosRestantes = segundos - (minutos*60);// definimos e iniciamos variable segundosRestantes
         double importe;
         if(minutos<=3){//si los minutos son menos o igual a 3
             if(segundosRestantes==0){//si no hay segundos de más, solo minutos enteros
                 importe = minutos*15;//el numero de minutos que es menor que 3 por 15
             }else{
                 importe = minutos*15 + 15;//minutos por 15 y los segundos adicionales se consideran como minuto entero
             }
         }else if(segundosRestantes==0){//mas de 3 minutos y sin segundos restantes
             importe = (3*15)+(minutos-3)*7;//importe 3 primeros min por 15 cent + minutos - 3 primeros por 7 cent
         }else{
             importe =(3*15)+(minutos-3)*7+7;//importe 3 primeros min por 15 cent + minutos - 3 primeros por 7 cent + los segundos adicionales se consideran minuto entero a 7 cent
         }
         return importe;
     }
     
     //funcion es primo
     public static boolean esPrimo(int numero){
         int contDivisiones = 0;
         boolean esPrimo = false;
         for(int i=1; i<=numero; i++)//ciclo que nos guarda en contDividiones los divisores del numero
             if(numero % i == 0){
                 contDivisiones++;
             }
         if(contDivisiones == 2){//para ser primo solo puede dividirse por 1 y si mismo 
             esPrimo = true;
         }
         return esPrimo;
     }
     
     //funcion es perfecto
     public static boolean esPerfecto(int numero){
         boolean esPerfecto = false;//definimos variable e iniciamos en false
         int sumaDivisores = 0;//vriable para guardar la suma de divisores
         for(int i=1; i<=numero; i++){//ciclo para comprobar los dividores de numero
             if(numero % i == 0){//condicion de que sean divisores
                 sumaDivisores = sumaDivisores + i;//se guarda los divisores
             }
         }
         sumaDivisores = sumaDivisores - numero;//restamos a la suma de los divisores el mismo numero
         if (sumaDivisores == numero){//condicion para que sea perfecto
             esPerfecto = true;
         }
         return esPerfecto;
     }
     
}
     
     
    

