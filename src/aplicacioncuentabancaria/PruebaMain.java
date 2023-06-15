
package aplicacioncuentabancaria;

import static aplicacioncuentabancaria.AplicacionCuentaBancaria.listaCuentas;
import java.util.Arrays;


public class PruebaMain {

    
    public static void main(String[] args) {
        
      listaCuentas[0] = new CuentaBancaria ("Joaquín", "15510464t", "M1sdsjDD5554", "14650100971732511563");
      listaCuentas[1] = new CuentaBancaria ("Pepe", "15510464d", "M1sdsjDD5554", "14650100971732511563");
      listaCuentas[2] = new CuentaBancaria ("Maria", "15510464f", "M1sdsjDD5554", "14650100971732511563");
      listaCuentas[3] = new CuentaBancaria ("Sam", "15510464l", "M1sdsjDD5554", "14650100971732511563");
      
       System.out.println(Arrays.toString(listaCuentas));
      
       eliminarCuenta(listaCuentas, 2);
       
       System.out.println(Arrays.toString(listaCuentas));
      
       
    }

    private static void eliminarCuenta(CuentaBancaria listaCuentas[], int posicion) {

        

        //para borrar cubro los objetos desde la posición a eliminar
        for (int i = posicion; i < listaCuentas.length - 1; i++) {
            listaCuentas[posicion] = listaCuentas[posicion + 1];
            posicion++;

        }

        listaCuentas[9] = null;

    }
    
   
}
