package com.fiap.carango.contants;

public enum Constants {
    HeiderURL("http://www.heiderlopes.com.br");

    private String url;

    Constants(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
