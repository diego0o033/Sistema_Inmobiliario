
package Ejercicio_Inmobiliaria;

/**
 *
 * @author diego vargas
 */
public class Casa extends Propiedad
{
    private int metros_cuadrados;
    private boolean patio;
    private int cantidad_ambientes;
    
public Casa(){}

public Casa(String codigo_propiedad,int cantidad, String direccion, String localidad, double precio, int metros, boolean patio, int cantidad_amb)
{
    super(codigo_propiedad,cantidad,direccion,localidad, precio);
    this.metros_cuadrados=metros;
    this.patio=patio;
    this.cantidad_ambientes=cantidad_amb;
}
    public void setMetros_Cuadrados(int metros)
    {
        this.metros_cuadrados=metros;
    }
    
    public void setPatio(boolean patio)
    {
        this.patio=patio;
    }
    
    public void setCantidad_Ambientes(int cantidad)
    {
        this.cantidad_ambientes=cantidad;
    }
    @Override
    public String toString()
{
    String patio_casa="";
    
    if(patio==true)
    {
        patio_casa="si";
    }
    else
    {
        patio_casa="no";
    }
    return "Casa {' " + "posee el siguiente codigo de identificacion: " + " " + super.getCodigo_Propiedad() + " " + " tiene" + " " + metros_cuadrados + " " + " metros cuadrados " + " " + "cuenta con" + " " + cantidad_ambientes + " " + "ambientes" + " \n" + 
            patio_casa + "cuenta con patio" + " \n" + " " + " se encuentra en la siguiente direccion: " + " " + super.getDireccion() + " " + " la cual pertenece a la localidad: " + "   \n" + super.getLocalidad()
            + " " + " hay la siguiente cantidad disponible: " + " " + super.getCantidad() + " \n" + " tiene un valor en dolares de US$:" + " " + super.getPrecio() + '}';   
}

    @Override
    public int verificar_Cantidad_Disponible() 
    {
        if(super.getCantidad()>0)
        {
        System.out.println("Hay cantidades disponibles de la casa solicitada...");
        }
        else
        {
        System.out.println("Lo siento, no hay cantidades disponibles para la casa solicitada");
        }
     return super.getCantidad(); 
    }
    
@Override
   public boolean verificarCodigo(String codigo)
{
    codigo= codigo.replaceAll("[^a-zA-Z0-9]", "");
    if(codigo.length() !=7)
    {
        return false;
    }
    
    if(codigo.substring(0, 4).matches("[A-Z]*"))
    {
         return false;
    }
    
    return codigo.substring(4).matches("[0-9]*");
    
}

}
