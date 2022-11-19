
package Ejercicio_Inmobiliaria;

/**
 *
 * @author diego vargas
 */
public class Propiedad 
{
    private String codigo_propiedad;
    private int cantidad;
    private String direccion;
    private String localidad;
    private double precio;

public Propiedad(){}

public Propiedad(String codigo,int cantidad, String direccion,String localidad,double precio)
{
    this.codigo_propiedad=codigo;
    this.cantidad=cantidad;
    this.direccion=direccion;
    this.localidad=localidad;           
    this.precio=precio;

}
public String getCodigo_Propiedad()
{       
    return codigo_propiedad;
}
public void setCodigo_Propiedad(String codigo)
{
    this.codigo_propiedad=codigo;    
}
public int getCantidad()
{
    return cantidad;
}

public void setCantidad(int cantidad)
{
    this.cantidad=cantidad;
}
public String getDireccion()
{
    return direccion;
}
public void setDireccion(String direccion)
{
    this.direccion=direccion;
}
public String getLocalidad()
{
    return localidad;
}
public void setLocalidad(String localidad)
{
    this.localidad=localidad;
}
public double getPrecio()
{
    return precio;
}
public void setPrecio(double precio)
{
    this.precio= precio;

}

public int verificar_Cantidad_Disponible()
{
    if(cantidad>0)
    {
        System.out.println("Hay cantidades disponibles de la propiedad solicitada...");
    }
    else
    {
        System.out.println("Lo siento, no hay cantidades disponibles para la propiedad solicitada");
    }
    return cantidad;   
}    
public boolean verificarCodigo(String codigo)
{

    codigo= codigo.replaceAll("[^a-zA-Z0-9]", "");
    if(codigo.length() !=11)
    {
        return false;
    }
    
    if(codigo.substring(0, 9).matches("[A-Z]*"))
    {
         return false;
    }
    
    return codigo.substring(4).matches("[0-9]*");
        
}

}
