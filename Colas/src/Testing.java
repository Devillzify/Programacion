package Colas;

public class Testing
{
    public static void main(String[] args)
    {

        Ordenada.insert(ClientGenerator.CantidadClientes(10));
        System.out.println("ahora ordenado");
        System.out.println("-----------------");
        Ordenada.show();
        System.out.println(ClientGenerator.Preciototal);
    }
}