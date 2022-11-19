

package Ejercicio_Inmobiliaria;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author diego vargas
 */
public class Inmobiliaria 
{
    private String nombre;
    private ArrayList<Propiedad> propiedades;
    private ArrayList <Propiedad> propiedades_vendidas;

public Inmobiliaria(String nombre)
{
    this.nombre=nombre;
    
}
   public Inmobiliaria()
{
    this.propiedades= new ArrayList<>();
    this.propiedades_vendidas=new ArrayList<>();
}

public void set_Nombre(String nombre)
{
    this.nombre=nombre;
}

public String getNombre()
{
    return nombre;
}

public void cargar_Propiedad(int cantidad_propiedad)
{
    Scanner ingreso_datos= new Scanner(System.in);
    int opcion_seleccionada=0;
    int i=1;
    String codigo_ingresado="";
     
         while(i<= cantidad_propiedad)
         { 
                System.out.println("Bienvenido al sistema de carga de propiedades, si desea cargar un inmueble del tipo casa, ingrese 1/ \n"
                        + " " + "si desea cargar un inmueble del tipo departamento, ingrese 2");
                opcion_seleccionada= ingreso_datos.nextInt();
                ingreso_datos.nextLine();
           switch (opcion_seleccionada)
           {
            case 1:  
                Casa casa= new Casa();
                System.out.println("A continuación debe cargar las caracteristicas del inmueble tipo casa");
                System.out.println("**********************************************************************");
                System.out.println("Ingrese el codigo para identificar la propiedad/inmueble en el sistema\n"
                        + " " + "(el formato para el ingreso del codigo es el siguiente: casa-001)");
                codigo_ingresado=ingreso_datos.nextLine();
                if(casa.verificarCodigo(codigo_ingresado)== true)
                {
                    System.out.println("Se ingreso correctamente el codigo para la propiedad");
                    casa.setCodigo_Propiedad(codigo_ingresado);
                    System.out.println("Ingrese la cantidad de unidades disponibles para este mismo inmueble");
                    casa.setCantidad(ingreso_datos.nextInt());
                    System.out.println("Ingrese la direccion en donde se encuentra el inmueble");
                    casa.setDireccion(ingreso_datos.next());
                    System.out.println("Ingrese la localidad del inmueble");
                    casa.setLocalidad(ingreso_datos.next());
                    System.out.println("Ingrese el precio que corresponde para el inmueble");
                    casa.setPrecio(ingreso_datos.nextDouble());
                    System.out.println("Ingrese los metros cuadrados con los que cuenta la casa");
                    casa.setMetros_Cuadrados(ingreso_datos.nextInt());
                    System.out.println("La propiedad cuenta con patio si/no");
                    String patio=ingreso_datos.next();
                    if(patio.equalsIgnoreCase("si"))
                    {
                        casa.setPatio(true);
                    }
                    else
                    {
                        casa.setPatio(false);
                    }
                    
                    System.out.println("Ingrese la cantidad de ambientes de la propiedad");
                    casa.setCantidad_Ambientes(ingreso_datos.nextInt());
                    propiedades.add(casa);
                    break;
                    
                }
                else
                {
                    System.out.println("Lo siento, debe ingresar un codigo con formato valido");
                    break;
                }
               
            case 2:
                Departamento depto= new Departamento();
                System.out.println("A continuación debe cargar las caracteristicas del inmueble tipo departamento");
                System.out.println("**********************************************************************");
                System.out.println("Ingrese el codigo para identificar la propiedad en el sistema\n" 
                        + " " + "(el formato para el ingreso del codigo es el siguiente, a modo de ejemp:  dep-001)");
                codigo_ingresado=ingreso_datos.nextLine();
                if(depto.verificarCodigo(codigo_ingresado)== true)
                {    
                    System.out.println("Se ingreso correctamente el codigo para la propiedad");
                    depto.setCodigo_Propiedad(ingreso_datos.nextLine());
                    System.out.println("Ingrese la cantidad de unidades disponibles para este mismo inmueble");
                    depto.setCantidad(ingreso_datos.nextInt());
                    System.out.println("Ingrese la direccion en donde se encuentra el inmueble");
                    depto.setDireccion(ingreso_datos.next());
                    System.out.println("Ingrese la localidad del inmueble");
                    depto.setLocalidad(ingreso_datos.next());
                    System.out.println("Ingrese el precio que corresponde para el inmueble");
                    depto.setPrecio(ingreso_datos.nextDouble());
                    System.out.println("Ingrese los metros cuadrados con los que cuenta la casa");
                    depto.setMetros_cuadrados(ingreso_datos.nextInt());
                    System.out.println("Ingrese la cantidad de ambientes de la propiedad");
                    depto.setCantidad_ambientes(ingreso_datos.nextInt());
                    System.out.println("La propiedad cuenta con balcon si/no");
                    String balcon=ingreso_datos.next();
                    if(balcon.equalsIgnoreCase("si"))
                    {
                        depto.setBalcon(true);
                    }
                    else
                    {
                        depto.setBalcon(false);
                    }
                    propiedades.add(depto);
                    break;
                }
                else
                {
                    System.out.println("Lo siento, debe ingresar un codigo con formato valido");
                    break;
                }
             default:
              System.out.println("Debe ingresar un valor valido, recuerde que debe ingresar 1 o 2");   
            }
         i++;
         } 
     System.out.println("Finalizaste la carga de pripiedades"); 
}

public void mostrarPropiedades()
{
  int sumar_cantidad= 0;
    
    for(Propiedad p: propiedades)
    {
        sumar_cantidad += p.getCantidad();
        System.out.println("A continuacion se muestran las propiedades disponibles con sus respectivas caracteristicas:" + p);
    }
  System.out.println("La cantidad de propiedades disponibles con las que cuenta la inmobiliaria son:" + " " + sumar_cantidad);  
}

public void buscar_PropiedadXPrecio(double precio_ingresado)
{
    for(Propiedad p: propiedades)
    {
        if(p.getPrecio()<= precio_ingresado)
        {
            System.out.println("Se muestran las propiedades que estan dentro del rango de precio solicitado" + p);
        
        }
    } 
}
public boolean vender_Propiedad(String codigo_inmueble)
{
    Scanner ingreso_teclado= new Scanner(System.in);
    boolean venta_realizada= false;
    int cantidad_vender=0;
    
    for(Propiedad p: propiedades)
    {
        if(p.getCodigo_Propiedad().equalsIgnoreCase(codigo_inmueble))
        {
            System.out.println("La siguiente propiedad se encuentra en el sistema de la" + " " + nombre + " " + "\n"
            + "a continuacion se procede a verificar si hay unidades disponibles...");
            System.out.println("Ingrese la cantidad que desea vender");
            cantidad_vender=ingreso_teclado.nextInt();
          if(p.verificar_Cantidad_Disponible()>0 && p.getCantidad() >= cantidad_vender)
          {
              System.out.println("Hay disponibilidad,las cantidades disponibles para la propiedad que desea vender son:" + p.verificar_Cantidad_Disponible());
              System.out.println("Se realizo la venta de la propiedad....");
            
              
              p.setCantidad(p.getCantidad()-cantidad_vender);
              propiedades_vendidas.add(p);
               
                venta_realizada=true;
                return venta_realizada;
          }
          else
          {
              System.out.println("Lo siento, no hay cantidades/unidades disponibles para realizar la venta de la propiedad solicitada");
          }
        }
    }
  return venta_realizada;  
}

public double ventas_Totales_Propiedades()
{
   double sumar_ventas=0;
    
    for(Propiedad pv: propiedades_vendidas)
    {
        sumar_ventas += pv.getPrecio();
    }
  return sumar_ventas;
}

}
