import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class CertificateManager {
    private List<Certificate> certificates;
    private List<Report> reports;
    private Map<String, List<Certificate>> usedCertificatesBySection;

    public CertificateManager() {
        this.certificates = new ArrayList<>();
        this.reports = new ArrayList<>();
        this.usedCertificatesBySection = new HashMap<>();
    }

    public void addCertificate(Certificate certificate) {
        certificates.add(certificate);
    }

    public void sellCertificate(Certificate certificate) {
        certificate.sell();
        generateReport(certificate);
        updateUsedCertificatesBySection(certificate);
    }

    private void generateReport(Certificate certificate) {
        Report report = new Report(certificate.getId(), certificate.getValue(), certificate.getDateSold());
        reports.add(report);
    }

    private void updateUsedCertificatesBySection(Certificate certificate) {
        List<Certificate> usedCertificates = usedCertificatesBySection.getOrDefault(certificate.getSection(), new ArrayList<>());
        usedCertificates.add(certificate);
        usedCertificatesBySection.put(certificate.getSection(), usedCertificates);
    }

    public List<Report> getReports() {
        return reports;
    }

    public Map<String, List<Certificate>> getUsedCertificatesBySection() {
        return usedCertificatesBySection;
    }

    public List<Certificate> getUnusedCertificates() {
        List<Certificate> unusedCertificates = new ArrayList<>();
        for (Certificate certificate : certificates) {
            if (!certificate.isSold() && certificate.getValue() > 0) {
                unusedCertificates.add(certificate);
            }
        }
        return unusedCertificates;
    }
}
