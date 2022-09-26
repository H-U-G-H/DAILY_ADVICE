import java.io.*;
import java.net.*;

public class DailyAdviceClient
{
    public void go() // ����� ������� ���������
    {
        try
        {
            Socket socket = new Socket("127.0.0.1", 4242); // IP-����� � ����
            InputStreamReader stream = new InputStreamReader(socket.getInputStream()); // ��������������� ���������� �����
            BufferedReader reader = new BufferedReader(stream); // ���������� �����

            String advice = reader.readLine(); // ������� ������ � ������ � ����������
            System.out.println("������� �� ������: " + advice); // �����

            reader.close(); // �������� ������
        }
        catch(IOException exception) // ��������� ����������
        {
            exception.printStackTrace(); // ������� ������ ���� ������
        } // OUT OF TRY-CATCH
    } // OUT OF EXECUTION METHOD

    public static void main(String[] args) // �������� �����
    {
        DailyAdviceClient client = new DailyAdviceClient(); // ��������� ������ �������
        client.go(); // ������ ���������
    } // OUT OF MAIN METHOD
} // OUT OF CLASS
