package Colas;

public class ClientGenerator
{

   static int Precio;
   static int Preciototal;
   static int cantidad;
   static int PagoAdulto = 8;
   static int PagoNino = 4;
   static String Adulto = "Adulto";
   static String Nino = "Niño";
   public ClientGenerator()
   {

   }

    public static String GeneradorClient()
   {
       int random = (int)Math.floor(Math.random() * 100);
       if(random < 50)
           return "Adulto";
       else
       {
           return "Niño";
       }
   }

   public static String CantidadClientes(int cantidad)
   {
       for(int i = 0; i < cantidad; i++)
       {
           String edad = GeneradorClient();
           System.out.println(edad);
           Ordenada.insert(edad);
           if(edad.equals("Adulto"))
           {
               Preciototal += 8;
           }
           else
               Preciototal += 4;
       }

       System.out.println("La ganacia total es de: " + Preciototal);

       return null;
   }

}
