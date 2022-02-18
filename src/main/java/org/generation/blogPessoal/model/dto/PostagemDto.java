package org.generation.blogPessoal.model.dto;

import java.util.Date;
import java.util.Objects;

public class PostagemDto {

    private long id;
    private String titulo;
    private String texto;
    private Date date;
    public PostagemDto() {}

    public PostagemDto(long id, String titulo, String texto, Date date) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PostagemDto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", texto='" + texto + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostagemDto that = (PostagemDto) o;
        return id == that.id && Objects.equals(titulo, that.titulo) && Objects.equals(texto, that.texto) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, texto, date);
    }
}
