

public class ClientGenerator
{
   static int Preciototal = 0;
   static int PagoAdulto = 12;
   static int PagoNino = 6;
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
           return "Nino";
       }
   }

   public static String CantidadClientes(int cantidad)
   {
       for(int i = 1; i < cantidad; i++)
       {
           String edad = GeneradorClient();
           System.out.println(edad);
           Ordenada.insert(edad);
           if(edad.equals("Adulto"))
           {
               Preciototal += PagoAdulto;
           }
         if(edad.equals("Nino"))
         {
             Preciototal += PagoNino;
         }
       }



       return null;
   }

}
