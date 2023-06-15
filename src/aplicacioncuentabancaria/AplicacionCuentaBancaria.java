//aplicación Java en consola que permite gestionar un conjunto de cuentas bancarias
package aplicacioncuentabancaria;

import java.util.Arrays;
import java.util.Scanner;

public class AplicacionCuentaBancaria {

    public static void main(String[] args) {

        String c = "14650100971732511563";

        //función menú principal donde se muestra por pantalla las opciones y se da a elegir 
        menuPrincipal(); 

    }

    //tengo que crearlo fuera del  main e inicializarlos a static para que sean comunes a toda la clase
    public static int contCuentas = 0;
    //Creamos el array de objetos que contendrá las cuentas bancarias
    public static CuentaBancaria listaCuentas[] = new CuentaBancaria[10];

    //función para crear menu principal de la aplicación de cuenta bancaria
    private static void menuPrincipal() {
        
        Scanner teclado = new Scanner(System.in);
        
        int opcion;
        
        do {
            //texto por pantalla
            System.out.println("-----MENÚ PRINCIPAL-----\n");

            System.out.println("1.Crear Cuenta Bancaria \n2.Eliminar Cuenta Bancaria \n3.Gestionar Cuenta Bancaria"
                    + "\n4.Consultar Depósitos \n5.Salir del Programa");

            //entra por teclado la opción. hay que validar que sea del 1 al 5
            opcion = FuncionesValidar.validarIntCompleta("\nIntroduce una opción del 1 al 5: ", 1, 5);

            //switch para actuar dependiendo de la opción elegida
            switch (opcion) {

                //llama al método crear cuenta Bancaria
                case 1:

                    //condicón para que se pueda o no crear más cuentas
                    if (contCuentas > 9) {
                        System.out.println("límite de cuentas superado");
                        
                    } else {
                        System.out.println("Cuenta nº:  " + (contCuentas + 1));
                        
                         crearCuentaBanaria();
                    //al crear una cuenta tengo que contarla max 10
                    contCuentas++;

                    System.out.println("\n*******Cuenta creada, elige una opción: ******\n");
                    
                    }

                    break;

                //elimina la cuenta bancaria 
                case 2:

                    //si no hay ninguna cuenta creada no puede acceder
                    if (contCuentas != 0) {

                        int posicion = buscarCuenta();

                        if (posicion != -1) {

                            eliminarCuenta(listaCuentas, posicion);

                            System.out.println("\n********Cuenta eliminada, elige una opción: *******\n");

                            //si se elmina la cuenta el contador --
                            contCuentas--;

                        }

                    } else {

                        System.out.println("No hay ninguna cuenta creada....volviendo al menú principal\n");

                    }

                    break;

                case 3:

                    //si no hay ninguna cuenta creada no puede acceder
                    if (contCuentas != 0) {

                        submenuGestion();

                    } else {

                        System.out.println("No hay ninguna cuenta creada");
                        menuPrincipal();
                    }

                    break;

                case 4:
                    //consultar depósitos

                    System.out.println("*****DEPÓSITO TOTAL EFECTIVO EN EL BANCO*****\n");

                    double saldoTotal = consultarDepositos(listaCuentas);

                    System.out.println("Total saldo en cuentas: " + saldoTotal + "€\n");
                    ;

                    break;

                case 5:
                    //salir del programa
                    System.out.println("\n*****-----FIN DEL PROGRAMA-----*****\n");

            }

        } while (opcion != 5);

    }

    public static void crearCuentaBanaria() {

        //recorro el array para comprobar huecos
        if (contCuentas != 10) {

            //pido por teclado los datos, valido y se los paso al contructor 
            String titular = pedirValidarTitular();

            String nif = pedirValidarNif();

            String pass = pedirValidarPass();

            String CCC = pedirValidarCCC();

            listaCuentas[contCuentas] = new CuentaBancaria(titular, nif, pass, CCC);

        } else {
            System.out.println("Límite de cuentas superado");
        }

    }

    private static String pedirValidarTitular() {

        Scanner teclado = new Scanner(System.in);

        //creo variable boolean
        boolean titularCorrecto = false;

        //creo la variable titular para guardar lo introducido por teclado
        String titular;

        System.out.println("Introduce titular: ");

        do {
            titular = teclado.nextLine();

            titularCorrecto = FuncionesValidar.validarTitular(titular);
            if (titularCorrecto == false) {

                System.out.println("Error, titular formato incorrecto.\nIntroduce un nuevo titular: ");
            }
        } while (titularCorrecto == false);

        return titular;
    }

    private static String pedirValidarNif() {

        Scanner teclado = new Scanner(System.in);

        //creo variable boolean
        boolean nifCorrecto = false;

        //creo la variable titular para guardar lo introducido por teclado
        String nif;

        System.out.println("Introduce NIF: ");

        do {
            nif = teclado.nextLine();

            nifCorrecto = FuncionesValidar.validaNIF(nif);
            if (nifCorrecto == false) {

                System.out.println("Error, NIF formato incorrecto.\nIntroduce un nuevo NIF: ");
            }
        } while (nifCorrecto == false);

        return nif;

    }

    private static String pedirValidarPass() {

        Scanner teclado = new Scanner(System.in);

        //creo variable boolean
        boolean passCorrecto = false;

        //creo la variable titular para guardar lo introducido por teclado
        String pass;

        System.out.println("Introduce Contraseña: ");

        do {
            pass = teclado.nextLine();

            passCorrecto = FuncionesValidar.validarContraseña(pass);
            if (passCorrecto == false) {

                System.out.println("Error, Contraseña formato incorrecto.\nIntroduce una nueva contraseña: ");
            }
        } while (passCorrecto == false);

        return pass;
    }

    private static String pedirValidarCCC() {

        Scanner teclado = new Scanner(System.in);

        //creo variable boolean
        boolean CCCCorrecto = false;

        //creo la variable titular para guardar lo introducido por teclado
        String CCC;

        do {
            
            do{

            System.out.println("Introduce CCC (20 digitos): ");
            
            CCC = teclado.nextLine();
            
            }while(CCC.length()!= 20);
            

            CCCCorrecto = CuentaBancaria.comprobarCCC(CCC);

            if (CCCCorrecto == false) {

                System.out.println("Error, CCC con DC incorrecto.\nIntroduce una nueva CCC: ");
            }
            
            //mientras que no sea true o el CCC introducido no sea de 20 dígitos
        } while ((CCCCorrecto == false));

        return CCC;
    }

    //función que busca la ceunta por paámetro NIF y devuelve en que posicion de la lista está
    private static int buscarCuenta() {

        String nif = pedirValidarNif();

        //variable que nos dará la posición si lo encuentra. -1 si no lo encuentra
        int posicion = -1;

        //recorro la lista de cuentas y en cada cuenta entra en su NIF y lo compara con el dato introducido por teclado
        for (int i = 0; i < listaCuentas.length; i++) {
            
            if (listaCuentas[i] != null) {

                if (listaCuentas[i].getNif().equals(nif)) {

                    return posicion = i;
                }
            }

        }
        return posicion;
    }

    //función para eliminar objeto. Para eliminar solo tengo que mover a la izquierda la lista sobrescribiendo
    private static void eliminarCuenta(CuentaBancaria listaCuentas[], int posicion) {

        
        //para borrar cubro los objetos desde la posición a eliminar
        for (int i = posicion; i < listaCuentas.length - 1; i++) {
            listaCuentas[posicion] = listaCuentas[posicion + 1];
            posicion++;

        }

        listaCuentas[9] = null;

    }

    private static void submenuGestion() {
        
         System.out.println("------MENÚ GESTIÓN DE CUENTA------");
         System.out.println("\nIntroduce tu NIF para acceder a la área cliente");
        
         int posicionCuenta = buscarCuenta();
         
        if (posicionCuenta != -1) {
            
            int opcion = 0;

            System.out.println("\nCLIENTE:\n" + listaCuentas[posicionCuenta].toString() + "\n");
            do {
                System.out.println("------MENÚ GESTIÓN DE CUENTA------\n");

                System.out.println("1.Ver el número de cuenta completo \n2.Ver el titular de la cuenta \n3.Ver el NIF de la cuenta"
                        + "\n4.Modificar la contraseña \n5.Realizar un ingreso \n6.Retirar efectivo \n7.Consultar saldo \n8.Volver al menú principal");

                //entra por teclado la opción. hay que validar que sea del 1 al 5
                opcion = FuncionesValidar.validarIntCompleta("\nIntroduce una opción del 1 al 8: ", 1, 8);

                //switch para actuar dependiendo de la opción elegida
                switch (opcion) {

                    //ver número de cuenta
                    case 1:

                        System.out.println("Número de Cuenta:\n" + listaCuentas[posicionCuenta].getNumCuenta() + "\n" + "\n....volviendo al menú de gestión");

                        break;
                    //ver el titular de la cuenta    
                    case 2:

                        System.out.println("Tttular de Cuenta:\n" + listaCuentas[posicionCuenta].getTitular() + "\n" + "\n....volviendo al menú de gestión");

                        break;
                    case 3:

                        System.out.println("Nif del Titular:\n" + listaCuentas[posicionCuenta].getNif() + "\n" + "\n....volviendo al menú de gestión");

                        break;
                    
                    case 4:
                        //modificar contraseña
                        System.out.println("Modificador de contraseña:\n");
                        
                        String nuevoPass = pedirValidarPass();
                        
                        listaCuentas[posicionCuenta].setPassword(nuevoPass);
                        
                        System.out.println("\nCONTRASEÑA CAMBIADA CON ÉXITO...\n...volviendo al menú de gestión de cuenta\n");
                          
                        break;
                        
                    case 5:
                        
                        //realizar un ingreso
                        double ingreso = FuncionesValidar.verificarDoubleMin("Introduce la cantidad a ingresar: ", 0);
                        
                        listaCuentas[posicionCuenta].ingresar(ingreso);
                        
                        System.out.println("...INGRESO REALIZADO\n");
                       
                        
                        break;
                        
                    case 6:
                        
                        //retirar efectivo
                        double egreso;
                        
                          //no se puede retirar más de la cntidad que hay en cuenta
                        do{
                            
                        egreso = FuncionesValidar.verificarDoubleMin("Saldo: "+listaCuentas[posicionCuenta].getSaldo()+"€"+"\nIntroduce una cantidad a retirar inferior al saldo: ", 0);
                        
                        }while(egreso>listaCuentas[posicionCuenta].getSaldo()); 
                        
                        //método retirar 
                        listaCuentas[posicionCuenta].retirar(egreso);
                        
                         System.out.println("...EGRESO REALIZADO\n");
                         
                        break;
                    
                    case 7:
                        //consultar saldo
                        System.out.println("\n*****SALDO*****\n" + "Cuenta " + listaCuentas[posicionCuenta].getNumCuenta() + ": "+ listaCuentas[posicionCuenta].getSaldo()+ "€\n");
     
                        
                    case 8:
                        //volver al menú principal
                        System.out.println("....accediendo al menu principal");

                }

            } while (opcion != 8);

        } else {
            
            System.out.println("¡¡¡No existe ninguna cuenta asociada a ese nif!!!\n...volviendo al menú principal\n");
        }

    }
        
    
    /**función que recibe por parámetro el array de cuentas y devolverá el saldo total almacenado en el programa.
     * 
     * @param listaCuentas
     * @return saldoTotal
     */    
    public static double consultarDepositos(CuentaBancaria listaCuentas[]){
        
        double saldoTotal = 0;
        
        //sumo todos los saldos de los objetos
        for(int i=0;i<listaCuentas.length;i++){
            
            if(listaCuentas[i]!=null){
                
                saldoTotal += listaCuentas[i].getSaldo();
            }
        }
                
        return saldoTotal;
        
    }    

     

    
}
