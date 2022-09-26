import java.io.*;
import java.net.*;

public class DailyAdviceClient
{
    public void go() // лернд гюосяйю опнцпюллш
    {
        try
        {
            Socket socket = new Socket("127.0.0.1", 4242); // IP-юдпея х онпр
            InputStreamReader stream = new InputStreamReader(socket.getInputStream()); // бшянйнспнбмебши яхлбнкэмши онрнй
            BufferedReader reader = new BufferedReader(stream); // яхлбнкэмши астеп

            String advice = reader.readLine(); // явхрюрэ ярпнйс я онрнйю б оепелеммсч
            System.out.println("яЕЦНДМЪ РШ ДНКФЕМ: " + advice); // бшбнд

            reader.close(); // гюйпшрхе онрнйю
        }
        catch(IOException exception) // напюанрйю хяйкчвемхи
        {
            exception.printStackTrace(); // бшбндхр онкмши осрэ ньхайх
        } // OUT OF TRY-CATCH
    } // OUT OF EXECUTION METHOD

    public static void main(String[] args) // нямнбмни лернд
    {
        DailyAdviceClient client = new DailyAdviceClient(); // щйгелокъп йкюяяю йкхемрю
        client.go(); // гюосяй опнцпюллш
    } // OUT OF MAIN METHOD
} // OUT OF CLASS
