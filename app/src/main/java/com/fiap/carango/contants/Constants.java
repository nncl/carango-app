package com.fiap.carango.contants;

public enum Constants {
    HeiderURL("http://www.heiderlopes.com.br");

    private final String url;

    Constants(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
