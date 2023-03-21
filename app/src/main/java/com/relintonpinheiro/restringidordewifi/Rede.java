package com.relintonpinheiro.restringidordewifi;

public class Rede {
    private Integer id;

    public Rede(Integer id, String ssid) {
        this.id = id;
        this.ssid = ssid;
    }

    private String ssid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

}
