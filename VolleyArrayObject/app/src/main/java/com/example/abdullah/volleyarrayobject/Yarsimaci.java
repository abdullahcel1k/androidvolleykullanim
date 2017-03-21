package com.example.abdullah.volleyarrayobject;

import java.io.Serializable;

/**
 * Created by abdullah on 3/20/17.
 */

public class Yarsimaci implements Serializable {
    private String yarismaciName;
    private String yarismaciGrupName;
    private String yarismaciImageUrl;

    public Yarsimaci(){

    }

    public Yarsimaci(String yarismaciName, String yarismaciGrupName, String yarismaciImageUrl){
        super();
        this.yarismaciName = yarismaciName;
        this.yarismaciGrupName = yarismaciGrupName;
        this.yarismaciImageUrl = yarismaciImageUrl;

    }

    public String getYarismaciName() {
        return yarismaciName;
    }

    public void setYarismaciName(String yarismaciName) {
        this.yarismaciName = yarismaciName;
    }

    public String getYarismaciGrupName() {
        return yarismaciGrupName;
    }

    public void setYarismaciGrupName(String yarismaciGrupName) {
        this.yarismaciGrupName = yarismaciGrupName;
    }

    public String getYarismaciImageUrl() {
        return yarismaciImageUrl;
    }

    public void setYarismaciImageUrl(String yarismaciImageUrl) {
        this.yarismaciImageUrl = yarismaciImageUrl;
    }
}
