package main.java.fr.epita.model;

import java.util.Date;

public class Patients{
    private String pat_num_hc;
    private String pat_lastname;
    private String  pat_firstname;
    private String  pat_address;
    private String  pat_tel;
    private Integer pat_insurance_id;
    private Date pat_subscription_date;

    public Patients() {
    }

    public Patients(String pat_num_hc, String pat_lastname, String pat_firstname, String pat_address, String pat_tel, Integer pat_insurance_id, Date pat_subscription_date) {
        this.pat_num_hc = pat_num_hc;
        this.pat_lastname = pat_lastname;
        this.pat_firstname = pat_firstname;
        this.pat_address = pat_address;
        this.pat_tel = pat_tel;
        this.pat_insurance_id = pat_insurance_id;
        this.pat_subscription_date = pat_subscription_date;
    }

    public String getPat_num_hc() {
        return pat_num_hc;
    }

    public void setPat_num_hc(String pat_num_hc) {
        this.pat_num_hc = pat_num_hc;
    }

    public String getPat_lastname() {
        return pat_lastname;
    }

    public void setPat_lastname(String pat_lastname) {
        this.pat_lastname = pat_lastname;
    }

    public String getPat_firstname() {
        return pat_firstname;
    }

    public void setPat_firstname(String pat_firstname) {
        this.pat_firstname = pat_firstname;
    }

    public String getPat_address() {
        return pat_address;
    }

    public void setPat_address(String pat_address) {
        this.pat_address = pat_address;
    }

    public String getPat_tel() {
        return pat_tel;
    }

    public void setPat_tel(String pat_tel) {
        this.pat_tel = pat_tel;
    }

    public Integer getPat_insurance_id() {
        return pat_insurance_id;
    }

    public void setPat_insurance_id(Integer pat_insurance_id) {
        this.pat_insurance_id = pat_insurance_id;
    }

    public Date getPat_subscription_date() {
        return pat_subscription_date;
    }

    public void setPat_subscription_date(Date pat_subscription_date) {
        this.pat_subscription_date = pat_subscription_date;
    }

    @Override
    public String toString() {
        return "Patients{" +
                "pat_num_hc='" + pat_num_hc + '\'' +
                ", pat_lastname='" + pat_lastname + '\'' +
                ", pat_firstname='" + pat_firstname + '\'' +
                ", pat_address='" + pat_address + '\'' +
                ", pat_tel='" + pat_tel + '\'' +
                ", pat_insurance_id=" + pat_insurance_id +
                ", pat_subscription_date=" + pat_subscription_date +
                '}';
    }
}

