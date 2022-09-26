import java.io.*;
import java.net.*;

public class DailyAdviceServer
{
    String[] adviceList = {"����� �������� ��������.", "������ ���������� ������. ���, ��� �� ������ ��� ������.",
    "��� �����: �� �������", "������ ������ ���� �� �������. ������� ������ ���������� ��, ��� �� *�� ����� ����* � �� �������.",
    "�������� ��� ����� ��������� ������ ��������."}; // ������ �������

    public void go() // ����� ������� ���������
    {
        try
        {
            ServerSocket serverSocket = new ServerSocket(4242); // ����� �������

            while (true) // ����������� ����
            {
                Socket socket = serverSocket.accept(); // ��������� ���������� �� �������

                PrintWriter writer = new PrintWriter(socket.getOutputStream()); // ����� �������� ������
                String advice = getAdvice(); // �����
                writer.println(advice); // ���������� ������ � �������
                writer.close(); // �������� ������
                System.out.println(advice); // ����� ������ �� �������
            } // OUT OF LOOP
        }
        catch (IOException exception) // ��������� ����������
        {
            exception.printStackTrace(); // ������� ������ ���� ������
        } // OUT OF TRY-CATCH
    } // OUT OF EXECUTION METHOD

    private String getAdvice() // ����� ������ ������
    {
        int random = (int) (Math.random() * adviceList.length); // ��������� ����� �� 0 �� 4.5 � ����� 0.5
        return adviceList[random]; // ���������� ��������� �����
    } // OUT OF METHOD

    public static void main(String[] args) // �������� �����
    {
        DailyAdviceServer server = new DailyAdviceServer(); // ��������� ������ �������
        server.go(); // ������ ���������
    } // OUT OF MAIN METHOD
} // OUT OF CLASS
