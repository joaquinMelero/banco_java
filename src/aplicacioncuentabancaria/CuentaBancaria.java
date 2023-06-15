//clase CuentaBancaria con los atributos y métodos necesarios para trabajar con un objeto CuentaBancaria.

package aplicacioncuentabancaria;

import java.util.Scanner;

public class CuentaBancaria {


    //atributos de la clase CuentaBancaria
    private String titular;
    private String nif;
    private String password;
    private double saldo;
    private String entidad;
    private String oficina;
    private String numCuenta;
    
  
  
//Constructor con los parámetros de la cuenta corriente de forma individual.
    public CuentaBancaria(String titular, String nif, String password, String entidad, String oficina, String DC, String numCuenta) {
        
       
      
    
        this.titular = titular;
        this.nif = nif;
        this.password = password;
        this.entidad = entidad;
        this.oficina = oficina;
        this.numCuenta = numCuenta;
        
        

     
    }
  
    
//Constructor con los parámetros titular y CCC sin descomponer. Este constructor 
//descompondrá el CCC y llamará al constructor básico mostrado anteriormente.
    public CuentaBancaria(String titular, String nif, String password, String CCC){
     
        
        this.titular = titular;
        this.nif = nif;
        this.password = password;
        this.numCuenta = CCC;
        
        
    }
    
    //métodos get
    public String getTitular() {
        return titular;
    }

    public String getNif() {
        return nif;
    }

    public String getPassword() {
        return password;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getEntidad() {
        return entidad;
    }

    public String getOficina() {
        return oficina;
    }

    public String getNumCuenta() {
        return numCuenta;
    }
    
    //métodos set. Se debe comprobar la validez y no modificar el atributo si no se verifica. 
    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    //método ingresar. Aumenta el saldo en la cantidad pasada por parámetro. No puede ser negativo
    public void ingresar(double cantidad){
        if(cantidad<0){
            throw new IllegalArgumentException("La cantidad a ingresar no puede ser negativa");
        }
        this.saldo += cantidad;
    }
        
    //Método Se restará la cantidad indicada del saldo de la cuenta. Este valor debe ser positivo y nunca superior al saldo de la cuenta. 
    public void retirar(double cantidad){
       
        if(cantidad<0){
            throw new IllegalArgumentException("La cantidad a ingresar no puede ser negativa");
        }else if(cantidad>this.saldo){
            throw new IllegalArgumentException("Retirada superior al saldo, la cuenta no puede quedar en negativo");    
        }
        
        saldo -= cantidad;
    }   
    
   //Comprobar la validez de un CCC. El método devolverá true o false si el CCC 
    public static boolean comprobarCCC(String CCC){
        
        //expeción si no son enteros y si no tiene la medida
        
       
       boolean digitosCorrectos = false;//variable a devolver einicializo a false
       
       //separo la cuenta en 2 listas para sacar el digito de control
       String entOf = "00" + CCC.substring(0,8);// le añado dos 0 para que tenga 10
       
       String cuenta = CCC.substring(10,20);//guardo los otros 10 restantes
       
       String digControl = CCC.substring(8,10);//guardo los 2 dígitos de control
       
       //tengo que comprobar si son correctos esos digitos. Llamo a la funcion crear digitos y compruebo
       
       //primer digito con entidad + oficia
       int primerDigito = crearDigitos(entOf);
      
       //segundo digito con cuenta
       int segundoDigito = crearDigitos(cuenta);
       
       //los digitos los convierto a tipo String
       String digitos = String.valueOf(primerDigito)+ String.valueOf(segundoDigito);
       
       //los he tenido que convertir a int de nuevo porque al compararlos en tipo String me daba false
        int digitosFinales = Integer.parseInt(digitos);
        int digitosIntroducidos = Integer.parseInt(digControl);
       
       //si son correctos
       if(digitosFinales == digitosIntroducidos){
           digitosCorrectos = true;
       }

       return digitosCorrectos;
    }
    
    //método paragenerar dígitos de control
    private static int crearDigitos(String cadena){
         
         int digito =0;//variable donde guardare el gígito generado
         
         int pesos [] = {1,2,4,8,5,10,9,7,3,6};//lista de los pesos
         
         //puedo hacer 10 subcadenas y guardarla en el nuevo array 
         int arrayCadena [] = new int [10];
         
         //recorro la cadena y voy convirtiendo a int y guardando en el nuevo arrayCadena
         for(int i=0; i<arrayCadena.length; i++){
             arrayCadena[i] = Integer.parseInt(cadena.substring(i,i+1));
         }
         
         //multiplico los elementos de cada array y los sumo
         for(int i=0; i<pesos.length; i++){
             
             digito += pesos[i]*arrayCadena[i];
         }
         
         //la suma se divide por 11 y mequedo el resto
         digito = digito % 11;
         
         //se lo restamos a 11
         digito = 11 - digito;
         
         //condición de dígito 10 o 11
         if (digito == 10){
             digito = 1;    
         }else if(digito == 11){
             digito =0;
         }
         
         return digito;
      }
      
      //El método devuelve los dos dígitos de  control dado los códigos de entidad, oficina y número de cuenta. 
    public static String obtenerDigitosControl(String entidad, String oficina, String numCuenta){
        
        //variable que guarda la cadena de la cuenta para pasarle mi método privado de crear digitos
        //esta cadena la componen: entidad + oficina
        String entOf = "00" + entidad + oficina;
        
     
        //segunda cadena para el segundo dígito
        String cuenta = numCuenta;
        
        //llamo al método privado para que cree los dígitos
        int digitosControl1 = crearDigitos(entOf);
        int digitosControl2 = crearDigitos(cuenta);
        
        //los convierto a String para devolver
        String PrimerControl = String.valueOf(digitosControl1); 
        String SegundoControl = String.valueOf(digitosControl2);
        
        String digitosControl = PrimerControl + SegundoControl;
        
        return digitosControl;
    }

   
   

    @Override
    public String toString() {
        return "CuentaBancaria{" + "titular=" + titular + ", nif=" + nif + '}';
    }
        
    

    
}

