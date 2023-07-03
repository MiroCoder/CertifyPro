import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Certificate {
    private int id;
    private double value;
    private String section;
    private boolean sold;
    private Date dateSold;

    public Certificate(int id, double value, String section) {
        this.id = id;
        this.value = value;
        this.section = section;
        this.sold = false;
        this.dateSold = null;
    }

    public int getId() {
        return id;
    }

    public double getValue() {
        return value;
    }

    public String getSection() {
        return section;
    }

    public boolean isSold() {
        return sold;
    }

    public Date getDateSold() {
        return dateSold;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void sell() {
        this.sold = true;
        this.dateSold = new Date();
    }

    public void use(double amount) {
        if (amount <= value) {
            value -= amount;
        } else {
            System.out.println("Недостаточно средств на сертификате!");
        }
    }
}