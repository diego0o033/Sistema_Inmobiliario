
package Ejercicio_Inmobiliaria;

import java.util.Scanner;
/**
 *
 * @author diego vargas
 */
public class InmobiliariaApp {

    
    public static void main(String[] args) 
    {
        Inmobiliaria inm= new Inmobiliaria();
        Scanner ingreso_datos= new Scanner(System.in);
        int opcion_seleccionada= 0;
        int opcion_menu_sistema=0;
        
        System.out.println("Bienvenido al sistema, para comenzar a operar con menu principal, debe ingresar el nombre de la inmobiliaria");
        System.out.println("Ingrese un nombre para la Inmobiliaria");
        inm.set_Nombre(ingreso_datos.nextLine());
        
        System.out.println("Bienvenido al sistema de la inmobiliaria:" + " " + inm.getNombre());
        System.out.println("Si desea operar con el menu principal del sistema de la inmobiliaria, debe ingresar la opcion 1, de lo contrario ingrese 0");
        opcion_seleccionada= ingreso_datos.nextInt();
        
        do
        {
            if(opcion_seleccionada==1)
            {
               menu_Principal(); 
               opcion_menu_sistema=ingreso_datos.nextInt();
               ingreso_datos.nextLine();
            }
            
            switch(opcion_menu_sistema)
            {
                case 1:
                    int cantidad_propiedades=0;
                    System.out.println("A seleccionada la opcion para comenzar a realizar la carga de propiedades en la" + " " + inm.getNombre());
                    System.out.println("Ingrese la cantidad de propiedades que va a cargar en el sistema");
                    cantidad_propiedades=ingreso_datos.nextInt();
                    inm.cargar_Propiedad(cantidad_propiedades);
                    break;
                case 2:
                    inm.mostrarPropiedades();
                    break;
                case 3:
                    double precio_consultado=0;
                    System.out.println("Ingrese un precio, a continuacion se van a mostrar propiedades por debajo o igual al precio ingresado");
                    precio_consultado=ingreso_datos.nextDouble();
                    inm.buscar_PropiedadXPrecio(precio_consultado);
                    break;
                case 4:
                    String codigo_propiedad="";
                    System.out.println("Ingrese el codigo de la propiedad que se desea vender");
                    codigo_propiedad=ingreso_datos.nextLine();
                    
                    if(inm.vender_Propiedad(codigo_propiedad)==false)
                    {
                        System.out.println("Lo siento, debe ingresar un codigo que pertenezca a una propiedad de nuestra inmobiliaria");
                    }
                    else
                    {
                        System.out.println("Se ha realizado la venta con exito, felicitaciones!!");
                    }
                    break;
                case 5:
                    System.out.println("A continuacion, se mostrara en pantalla el valor total, por las ventas realizadas de las propiedades\n"
                    + " " + "que pertenecen a la " + " " + inm.getNombre());
                    if(inm.ventas_Totales_Propiedades()>0)
                    {
                        System.out.println("Las ventas totales por las propiedades vendidas son:" + " " + inm.ventas_Totales_Propiedades());
                    }
                    else
                    {
                        System.out.println("Lo siento, las ventas no vienen bien...no has realizado ninguna venta");
                    }
                    break;
                   
                case 6:
                    System.out.println(" Ha seleccionado la opcion salir del sistema, hasta luego!!!");
                    salir_Sistema();
                    break;
                default:
                  System.out.println("Recuerde que las opciones validas del menu son del 1 al 6");
            
            }
        
        }while(opcion_menu_sistema>0 || opcion_menu_sistema <6);
    }
 
public static void menu_Principal()
{
    System.out.println("Bienvenido al menu principal del sistema inmobiliaria del norte");
    System.out.println("A continuacion se mostraran las opciones princpales del menu");
    System.out.println("*************************************************************************");
    System.out.println("1.Cargar propiedades al sistema, puede ingresar casas o departamentos");
    System.out.println("2.Mostrar las propiedades disponibles en la inmobiliaria y las cantidades disponibles");
    System.out.println("3.Mostrar propiedades por debajo o igual al precio consultado");
    System.out.println("4.Realizar la venta de una propiedad");
    System.out.println("5.Visualizar las ventas totales de las propiedades vendidas");
    System.out.println("6.Salir del sistema");
}    

public static void salir_Sistema()
{
    System.out.println("Saliendo del sistema de inmobiliaria del norte....");
    System.exit(0);
}

}



