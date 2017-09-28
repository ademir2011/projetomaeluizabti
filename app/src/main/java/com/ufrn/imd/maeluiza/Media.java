package com.ufrn.imd.maeluiza;

/**
 * Created by ademi on 02/05/2017.
 */

public class Media {

    private String titulo;
    private String descricao;
    private String pathMedia;

    public Media(String titulo, String descricao, String pathMedia) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.pathMedia = pathMedia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPathMedia() {
        return pathMedia;
    }

    public void setPathMedia(String pathMedia) {
        this.pathMedia = pathMedia;
    }
}
