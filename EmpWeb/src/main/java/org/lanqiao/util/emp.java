package org.lanqiao.util;

public class emp {
    private Integer employee_id;
    private String employee_name;
    private Integer employee_gender;
    private String employee_phone;
    private String employee_email ;
    private String employee_addr;

    public emp() {
    }

    public emp(Integer employee_id, String employee_name, Integer employee_gender, String employee_phone, String employee_email, String employee_addr) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_gender = employee_gender;
        this.employee_phone = employee_phone;
        this.employee_email = employee_email;
        this.employee_addr = employee_addr;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public Integer getEmployee_gender() {
        return employee_gender;
    }

    public void setEmployee_gender(Integer employee_gender) {
        this.employee_gender = employee_gender;
    }

    public String getEmployee_phone() {
        return employee_phone;
    }

    public void setEmployee_phone(String employee_phone) {
        this.employee_phone = employee_phone;
    }

    public String getEmployee_email() {
        return employee_email;
    }

    public void setEmployee_email(String employee_email) {
        this.employee_email = employee_email;
    }

    public String getEmployee_addr() {
        return employee_addr;
    }

    public void setEmployee_addr(String employee_addr) {
        this.employee_addr = employee_addr;
    }
}
