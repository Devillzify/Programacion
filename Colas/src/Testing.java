
public class Testing
{
    public static void main(String[] args)
    {

        Ordenada.insert(ClientGenerator.CantidadClientes(20));
        System.out.println("ahora ordenado");
        System.out.println("-----------------");
        Ordenada.show();
        System.out.println(ClientGenerator.Preciototal);


    }
}