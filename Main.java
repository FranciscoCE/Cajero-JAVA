
package Ejercicio7;

import java.util.Scanner;

public class Main {
    
    
    public static int buscarCuenta(Cuenta cuentas[], int n){
        
        
        
        int i=0, indice=0;
        boolean cuentaEncontrada = false;
        
        while((i<cuentas.length) && (cuentaEncontrada == false)){
            if(cuentas[i].getNumeroCuenta() == n){
                cuentaEncontrada = true;
                indice = i;
            }
            
            i++;
        }
        if(cuentaEncontrada == false){
            indice = -1;
        }
        return indice;
    }
    
    public static void main (String [] args){
        
        Scanner entrada = new Scanner(System.in);
        
        String nombre, apellido;
        int numeroCuenta, numeroCuentas, opcion, indiceCuenta;
        double saldo, cantidad;
        Cuenta cuentas[];
        Cliente cliente1;
        
        System.out.println("Apertura de cuenta(s).");
        System.out.print("\nIngresa nombre: ");
        nombre = entrada.nextLine();
        System.out.print("Ingresa apellido: ");
        apellido = entrada.nextLine();
        
        System.out.print("\n¿Cuántas cuentas desea aperturar? -->");
        numeroCuentas = entrada.nextInt();
        
        cuentas = new Cuenta[numeroCuentas];
               
        for(int i=0; i<cuentas.length; i++){
            System.out.println("\nIngresa los datos de la cuenta número: "+(i+1)+".");
            System.out.print("Ingresa número de cuenta: ");
            numeroCuenta = entrada.nextInt();
            System.out.print("Ingresa saldo inicial: ");
            saldo = entrada.nextDouble();
            
            cuentas [i] = new Cuenta (numeroCuenta, saldo);
        }
        
        cliente1 = new Cliente(nombre, apellido, cuentas);
        
        
        do{
            System.out.println("\t\n\n.....::MENÚ::.....");
            System.out.println("1.-Ingresar dinero.");
            System.out.println("2.-Retirar dinero.");
            System.out.println("3.-Consultar saldo.");
            System.out.println("4.-Salir.");
            System.out.print("\nSeleccione una opción: ");
            opcion = entrada.nextInt();
            
            
                switch(opcion){
                    
                    case 1: 
                        System.out.println("Ingresa el número de cuenta: ");
                        numeroCuenta = entrada.nextInt();
                        indiceCuenta = buscarCuenta(cuentas, numeroCuenta);
                        
                        
                        if(indiceCuenta == -1){
                            System.out.println("La cuenta no existe.");
                        }
                        
                        else{
                            System.out.print("Ingrese la cantidar que quiere depositar en la cuenta: ");
                            cantidad = entrada.nextDouble();
                            
                            cliente1.ingresar_dinero(indiceCuenta, cantidad);
                            System.out.println("Operación realizada con éxito.");
                            System.out.println("Tu saldo es: "+cliente1.consultar_saldo(indiceCuenta));
                        }
                        break;
                        
                        
                    case 2:  
                        System.out.println("Ingresa el número de cuenta: ");
                        numeroCuenta = entrada.nextInt();
                        indiceCuenta = buscarCuenta(cuentas, numeroCuenta);
                        
                        
                        if(indiceCuenta == -1){
                            System.out.println("La cuenta no existe.");
                        }
                        
                        else{
                            System.out.print("Ingresa la cantidad que quieres retirar: ");
                            cantidad = entrada.nextDouble();
                            if(cantidad > cliente1.consultar_saldo(indiceCuenta)){
                                System.out.println("No tienes fondos suficientes.");
                            }
                            else{
                            cliente1.retirar_dinero(indiceCuenta, cantidad);
                            System.out.println("Operación realizada con éxito.");
                            System.out.println("Tu saldo es: "+cliente1.consultar_saldo(indiceCuenta));
                            }
                        }
                    break;
                        
                    case 3:
                        System.out.println("Ingresa el número de cuenta: ");
                        numeroCuenta = entrada.nextInt();
                        indiceCuenta = buscarCuenta(cuentas, numeroCuenta);
                        
                        
                        if(indiceCuenta == -1){
                            System.out.println("La cuenta no existe.");
                        }
                        
                        else{
                            System.out.println("Tu saldo es: "+cliente1.consultar_saldo(indiceCuenta));
                        }
                        break;
                        
                    case 4:
                        System.out.println("Saliendo... Vuelva pronto.");
                        break;
                    
                    default:
                        System.out.println("Opción incorrecta, seleccione otra opción. ");
                }
            
            
        }while(opcion != 4);
        
        
    }
}
