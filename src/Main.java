import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CertificateManager certificateManager = new CertificateManager();

        Certificate certificate1 = new Certificate(1, 20.0, "Духи");
        Certificate certificate2 = new Certificate(2, 20.0, "Духи");
        Certificate certificate3 = new Certificate(3, 30.0, "Продукты");
        Certificate certificate4 = new Certificate(4, 30.0, "Продукты");
        Certificate certificate5 = new Certificate(5, 30.0, "Продукты");

        certificateManager.addCertificate(certificate1);
        certificateManager.addCertificate(certificate2);
        certificateManager.addCertificate(certificate3);
        certificateManager.addCertificate(certificate4);
        certificateManager.addCertificate(certificate5);

        certificateManager.sellCertificate(certificate1);
        certificateManager.sellCertificate(certificate2);
        certificateManager.sellCertificate(certificate3);
        certificateManager.sellCertificate(certificate4);
        certificateManager.sellCertificate(certificate5);

        // Получение отчетов
        List<Report> reports = certificateManager.getReports();
        Map<String, List<Certificate>> usedCertificatesBySection = certificateManager.getUsedCertificatesBySection();

        // Вывод отчетов
        System.out.println("Отчеты о проданных сертификатах:");
        for (Report report : reports) {
            System.out.println("ID сертификата: " + report.getCertificateId());
            System.out.println("Сумма сертификата: " + report.getValue());
            System.out.println("Дата продажи: " + report.getDateSold());
            System.out.println("--------------------");
        }

        System.out.println("Учет использованных сертификатов по секциям:");
        for (Map.Entry<String, List<Certificate>> entry : usedCertificatesBySection.entrySet()) {
            String section = entry.getKey();
            List<Certificate> usedCertificates = entry.getValue();
            System.out.println("Секция: " + section);
            System.out.println("Количество использованных сертификатов: " + usedCertificates.size());
            System.out.println("--------------------");
        }
    }
}