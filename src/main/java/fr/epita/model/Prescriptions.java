package main.java.fr.epita.model;

public class Prescriptions {
    // 6;2758965423102;1;2
    private int presc_id;
    private  Long presc_ref_pat;
    private int  presc_code;
    private int presc_days;

    public Prescriptions() {
    }

    public Prescriptions(int presc_id, Long presc_ref_pat, int presc_code, int presc_days) {
        this.presc_id = presc_id;
        this.presc_ref_pat = presc_ref_pat;
        this.presc_code = presc_code;
        this.presc_days = presc_days;
    }

    public int getPresc_id() {
        return presc_id;
    }

    public void setPresc_id(int presc_id) {
        this.presc_id = presc_id;
    }

    public Long getPresc_ref_pat() {
        return presc_ref_pat;
    }

    public void setPresc_ref_pat(Long presc_ref_pat) {
        this.presc_ref_pat = presc_ref_pat;
    }

    public int getPresc_code() {
        return presc_code;
    }

    public void setPresc_code(int presc_code) {
        this.presc_code = presc_code;
    }

    public int getPresc_days() {
        return presc_days;
    }

    public void setPresc_days(int presc_days) {
        this.presc_days = presc_days;
    }

    @Override
    public String toString() {
        return "Prescripitons{" +
                "presc_id=" + presc_id +
                ", presc_ref_pat=" + presc_ref_pat +
                ", presc_code=" + presc_code +
                ", presc_days=" + presc_days +
                '}';
    }
}
