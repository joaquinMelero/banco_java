//Clase donde se encuentran las funciones de validar del pasado trimestre
package aplicacioncuentabancaria;

import java.util.Scanner;


public class FuncionesValidar {
    
    //funcion validar numero entero y no letras con minimo y maximo 
    public static int validarIntCompleta(String mensaje, int minimo, int maximo) {
        Scanner teclado = new Scanner(System.in);//creo escaner para leer por teclado
        int numero;//definimos la variable numero
        do {// bucle hacer
            System.out.println(mensaje);//mensaje que nos solicitara introducir en el programa
            while (!teclado.hasNextInt()) {//mientras que el dato inntroducido no sea un numero
                System.out.println("Error número no correcto, ");//mensaje que se muestra de error
                teclado.next();//solicitamos introducir otro numero
            }
            numero = teclado.nextInt();// indicamos que la variable numero toma el valor introducido por teclado
        } while ((numero > maximo) || (numero < minimo));//definimos el minimo y maximo 
        return numero;
     }
    
    public static boolean validaNIF (String nif){
        
        //expresión regular: que obligatoriamente empiece por un número de 0-9, se repita 8 veces y
        //obligatoriamente acabe en una letra y se repita una vez
        return nif.matches("^([0-9]{8}[A-Za-z]{1}$)");
    }
    
    public static boolean validarTitular(String nombre){
        
        //expresión regular: obligatoriamente empiece por un una letra mayuscula, siga por almenos una
        //minúscula, siga un espacio que puede aparecer o no, y todo esto se puede repetir 1,2,3 
        return nombre.matches("^([A-Z]{1}[a-z]+[ ]?){1,3}$");
    }
    
    public static String validarIdentificador(String mensaje){
         
        Scanner teclado = new Scanner(System.in);
         
            System.out.println(mensaje);
            String identificador = "";
            while(!validaNIF(identificador)){
                System.out.println("Error " + mensaje);
                teclado.next();
            } 
         identificador = teclado.nextLine();
       
        return identificador;
    }
    
    public static boolean validarContraseña(String contraseña){
        
        //expresión regular: longitud mínima de 10,al menos una letra mayúscula, al menos una minúscula
        //y dos dígitos
        return contraseña.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d{2,})[a-zA-Z\\d]{8,}$");
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
    
   
 
    
}
