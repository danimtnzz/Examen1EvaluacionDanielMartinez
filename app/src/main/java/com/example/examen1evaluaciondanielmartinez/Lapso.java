package com.example.examen1evaluaciondanielmartinez;

public class Lapso {
    String tiempo;
    int numeroTiempo;

    public Lapso(String tiempo, int numeroTiempo) {
        this.tiempo = tiempo;
        this.numeroTiempo = numeroTiempo;
    }

    @Override
    public String toString() {
        return "Lapso{" +
                "tiempo='" + tiempo + '\'' +
                ", numeroTiempo=" + numeroTiempo +
                '}';
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public int getNumeroTiempo() {
        return numeroTiempo;
    }

    public void setNumeroTiempo(int numeroTiempo) {
        this.numeroTiempo = numeroTiempo;
    }
}
