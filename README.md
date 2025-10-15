#  Java Socket Web Server

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Status](https://img.shields.io/badge/Status-Active-success.svg?style=for-the-badge)

Saf Java Socket programlama kullanılarak geliştirilmiş, hafif ve eğitim amaçlı bir HTTP web sunucusu. Harici kütüphane kullanmadan, sadece Java'nın yerleşik socket API'leri ile HTTP protokolü implementasyonu yapılmıştır.

##  Proje Bilgileri

| Bilgi | Detay |
|-------|-------|
| **Öğrenci** | Mehmet Akif Geriş |
| **Öğrenci No** | 1240505033 |
| **Port** | 1989 |
| **Dil** | Java |

Bu proje, ağ programlama dersi kapsamında socket programlama ve HTTP protokolü bilgilerini pratikte uygulamak amacıyla geliştirilmiştir.

##  Özellikler

-  **Saf Java Implementation** - Harici kütüphane yok, sadece Java SE
-  **HTTP/1.1 Protokolü** - Standart HTTP protokol desteği
-  **UTF-8 Encoding** - Türkçe karakter desteği
-  **Responsive Design** - Mobil uyumlu HTML sayfası
-  **Real-time Timestamp** - Dinamik tarih/saat gösterimi
-  **Clean UI** - Modern ve minimalist tasarım
-  **Thread-Safe** - Güvenli bağlantı yönetimi

##  Ekran Görüntüsü

```
┌─────────────────────────────────────────┐
│     Mehmet Akif Geriş                   │
│     Öğrenci No: 1240505033              │
│                                         │
│  Merhaba! Ben Mehmet Akif Geriş,       │
│  Yazılım Mühendisliği bölümünde         │
│  okuyan bir öğrenciyim.                 │
│                                         │
│  İlgi Alanlarım:                        │
│  - Web Geliştirme                       │
│  - Ağ Programlama                       │
│  - Yapay Zeka                           │
│  - Mobil Uygulama Geliştirme            │
└─────────────────────────────────────────┘
```

##  Hızlı Başlangıç

### Gereksinimler

```bash
Java 8 veya üzeri
```

### Kurulum

1. **Repoyu klonlayın**
```bash
git clone https://github.com/makifgeris/simple-java-web-server.git
cd simple-java-web-server
```

2. **Projeyi derleyin**
```bash
javac -encoding UTF-8 SimpleWebServer.java
```

3. **Sunucuyu başlatın**
```bash
java SimpleWebServer
```

4. **Tarayıcınızda açın**
```
http://localhost:1989
```

### Beklenen Çıktı

```
Web sunucusu 1989 portunda başlatılıyor...
Sunucu başarıyla başlatıldı!
Tarayıcınızda http://localhost:1989 adresini ziyaret edin
İstek alındı: GET / HTTP/1.1
```

##  Proje Yapısı

```
simple-java-web-server/
│
├── SimpleWebServer.java    # Ana sunucu dosyası
└── README.md             # Proje dokümantasyonu
```

### Dosya İçeriği

| Dosya | Açıklama |
|-------|----------|
| `SimpleWebServer.java` | Socket sunucu implementasyonu ve HTML üretimi |
| `README.md` | Bu döküman |
| `sunucu_calistir.bat` | Windows için otomatik derleme ve çalıştırma scripti |

### Kullanılan Teknolojiler ve API'ler

| Teknoloji | Kullanım Amacı |
|-----------|----------------|
| `ServerSocket` | TCP/IP sunucu socket oluşturma |
| `Socket` | İstemci bağlantılarını yönetme |
| `BufferedReader` | HTTP isteklerini okuma |
| `PrintWriter` | HTTP başlıklarını gönderme |
| `BufferedOutputStream` | HTML içeriğini gönderme |
| `SimpleDateFormat` | Tarih/saat formatlama |

### HTTP İstek/Yanıt Akışı

```java
// 1. İstemci Bağlantısı
Socket clientSocket = serverSocket.accept();

// 2. İstek Okuma
String requestLine = in.readLine();
// Örnek: "GET / HTTP/1.1"

// 3. Yanıt Gönderme
out.println("HTTP/1.1 200 OK");
out.println("Content-Type: text/html; charset=UTF-8");
out.println("Content-Length: " + htmlContent.getBytes("UTF-8").length);
out.println("Connection: close");
out.println();

// 4. İçerik Gönderme
dataOut.write(htmlContent.getBytes("UTF-8"));
```

### Port Yapılandırması

```java
private static final int PORT = 1989;
```

>  **Not:** Port numarasını değiştirmek için yukarıdaki satırı düzenleyin.

### Kod Yapısı

```java
SimpleWebServer
│
├── main()              // Sunucuyu başlatır
├── handleClient()      // Her istemciyi işler
└── generateHTML()      // Dinamik HTML üretir
```

#### Metod Açıklamaları

| Metod | Açıklama | Parametreler |
|-------|----------|--------------|
| `main()` | Sunucuyu başlatır ve sonsuz döngüde istemci bekler | `String[] args` |
| `handleClient()` | İstemci isteğini işler ve yanıt gönderir | `Socket clientSocket` |
| `generateHTML()` | HTML içeriğini string olarak oluşturur | - |


##  Kullanım Senaryoları

### Senaryo 1: Temel Kullanım
```bash
# Sunucuyu başlat
java SimpleWebServer

# Tarayıcıdan bağlan
http://localhost:1989
```

### Senaryo 2: Farklı Port Kullanımı
```java
// SimpleWebServer.java içinde
private static final int PORT = 8080;  // Port değiştir
```
```bash
javac -encoding UTF-8 SimpleWebServer.java
java SimpleWebServer
# http://localhost:8080
```

### Senaryo 3: Curl ile Test
```bash
curl http://localhost:1989
```
### Senaryo 4: Windows'ta Hızlı Başlatma

**Komut satırından:**
```cmd
sunucu_calistir.bat
```

**veya** Windows Explorer'da `sunucu_calistir.bat` dosyasına çift tıklayın.

**sunucu_calistir.bat içeriği:**
```batch
@echo off
echo ====================================
echo Java Web Sunucusu Baslatiliyor...
echo ====================================
echo.

echo Derleniyor...
javac -encoding UTF-8 SimpleWebServer.java

if %errorlevel% neq 0 (
    echo.
    echo HATA: Derleme basarisiz!
    pause
    exit /b 1
)

echo Derleme basarili!
echo.
echo Sunucu baslatiliyor...
echo.

java SimpleWebServer

pause
```


## 🐛 Sorun Giderme

### Problem: Port zaten kullanımda

```bash
# Hata: java.net.BindException: Address already in use
```

**Çözüm:**
```bash
# Linux/Mac
lsof -ti:1989 | xargs kill -9

# Windows
netstat -ano | findstr :1989
taskkill /PID <PID_NUMARASI> /F
```

### Problem: Bağlantı reddedildi

```bash
# Hata: Connection refused
```

**Çözüm:**
- Sunucunun çalıştığından emin olun
- Firewall ayarlarını kontrol edin
- Doğru portu kullandığınızdan emin olun

### Problem: Türkçe karakterler görünmüyor

**Çözüm:**
```bash
# UTF-8 encoding ile derleyin
javac -encoding UTF-8 SimpleWebServer.java
```


##  Teşekkürler

Bu projeyi geliştirmeme yardımcı olan:

- Java dokümantasyonu ve topluluk
- Stack Overflow topluluğu

##  Kaynaklar

- [Java Socket Programming](https://docs.oracle.com/javase/tutorial/networking/sockets/)
- [HTTP Protocol Specification](https://www.w3.org/Protocols/rfc2616/rfc2616.html)
- [Java Documentation](https://docs.oracle.com/en/java/)

---

<div align="center">

**⭐ Projeyi beğendiyseniz yıldız vermeyi unutmayın! ⭐**

Made with ☕ and 💻 by Mehmet Akif Geriş

</div>
