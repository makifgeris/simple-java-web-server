import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleWebServer {
    private static final int PORT = 1989;

    public static void main(String[] args) {
        // UTF-8 encoding ayarla
        System.setProperty("file.encoding", "UTF-8");

        System.out.println("Web sunucusu " + PORT + " portunda başlatılıyor...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Sunucu başarıyla başlatıldı!");
            System.out.println("Tarayıcınızda http://localhost:" + PORT + " adresini ziyaret edin");

            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    handleClient(clientSocket);
                } catch (IOException e) {
                    System.err.println("İstemci bağlantısı hatası: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Sunucu başlatma hatası: " + e.getMessage());
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream(), "UTF-8"));
            PrintWriter out = new PrintWriter(
                new OutputStreamWriter(clientSocket.getOutputStream(), "UTF-8"));
            BufferedOutputStream dataOut = new BufferedOutputStream(
                clientSocket.getOutputStream())
        ) {
            String requestLine = in.readLine();
            if (requestLine == null || requestLine.isEmpty()) {
                return;
            }

            System.out.println("İstek alındı: " + requestLine);

            // HTTP isteğinin geri kalanını oku
            String line;
            while ((line = in.readLine()) != null && !line.isEmpty()) {
                // Header'ları oku ama kullanma
            }

            // HTML içeriği oluştur
            String htmlContent = generateHTML();

            // HTTP yanıtı gönder
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/html; charset=UTF-8");
            out.println("Content-Length: " + htmlContent.getBytes("UTF-8").length);
            out.println("Connection: close");
            out.println();
            out.flush();

            dataOut.write(htmlContent.getBytes("UTF-8"));
            dataOut.flush();

        } catch (IOException e) {
            System.err.println("İstemci işleme hatası: " + e.getMessage());
        }
    }

    private static String generateHTML() {
        StringBuilder html = new StringBuilder();

        html.append("<!DOCTYPE html>\n");
        html.append("<html lang=\"tr\">\n");
        html.append("<head>\n");
        html.append("    <meta charset=\"UTF-8\">\n");
        html.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        html.append("    <title>Kişisel Web Sayfası</title>\n");
        html.append("    <style>\n");
        html.append("        body {\n");
        html.append("            font-family: Arial, sans-serif;\n");
        html.append("            background-color: #f0f0f0;\n");
        html.append("            padding: 20px;\n");
        html.append("        }\n");
        html.append("        h1 {\n");
        html.append("            color: #333;\n");
        html.append("            text-align: center;\n");
        html.append("        }\n");
        html.append("        h2 {\n");
        html.append("            color: #666;\n");
        html.append("            text-align: center;\n");
        html.append("        }\n");
        html.append("        p {\n");
        html.append("            color: #444;\n");
        html.append("            line-height: 1.6;\n");
        html.append("        }\n");
        html.append("    </style>\n");
        html.append("</head>\n");
        html.append("<body>\n");
        html.append("    <h1>Mehmet Akif Geriş</h1>\n");
        html.append("    <h2>Öğrenci No: 1240505033</h2>\n");
        html.append("    \n");
        html.append("    <p>\n");
        html.append("        <b>Merhaba!</b> Ben <font color=\"blue\">Mehmet Akif Geriş</font>, \n");
        html.append("        Yazılım Mühendisliği bölümünde okuyan bir öğrenciyim.\n");
        html.append("    </p>\n");
        html.append("    \n");
        html.append("    <p>\n");
        html.append("        <font color=\"green\"><b>İlgi Alanlarım:</b></font><br>\n");
        html.append("        - Web Geliştirme<br>\n");
        html.append("        - Ağ Programlama ve Socket Uygulamaları<br>\n");
        html.append("        - Yapay Zeka<br>\n");
        html.append("        - Mobil Uygulama Geliştirme\n");
        html.append("    </p>\n");
        html.append("    \n");
        html.append("    <p>\n");
        html.append("        Üniversitede aldığım <font color=\"red\"><b>Nesneye Yönelik Programlama</b></font> dersi \n");
        html.append("        sayesinde socket programlama hakkında bilgi edindim. Bu proje, \n");
        html.append("        öğrendiklerimi pratikte uygulama fırsatı sundu.\n");
        html.append("    </p>\n");
        html.append("    \n");
        html.append("    <p>\n");
        html.append("        <i>\"Teknoloji sürekli gelişiyor ve ben de bu gelişimin bir parçası olmak istiyorum.\"</i>\n");
        html.append("    </p>\n");
        html.append("    \n");
        html.append("    <hr>\n");
        html.append("    <p style=\"text-align: center; color: gray;\">\n");
        html.append("        Bu sayfa Java Socket Programlama ile oluşturulmuştur<br>\n");
        html.append("        Port: 1989 | ");
        html.append(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
        html.append("\n");
        html.append("    </p>\n");
        html.append("</body>\n");
        html.append("</html>");

        return html.toString();
    }
}
