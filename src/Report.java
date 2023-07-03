import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Report {
    private int certificateId;
    private double value;
    private Date dateSold;

    public Report(int certificateId, double value, Date dateSold) {
        this.certificateId = certificateId;
        this.value = value;
        this.dateSold = dateSold;
    }

    public int getCertificateId() {
        return certificateId;
    }

    public double getValue() {
        return value;
    }

    public Date getDateSold() {
        return dateSold;
    }
}