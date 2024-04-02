package domain;

import java.util.List;

public class Alumno {
    private String nombre;
    private String apellido;
    private List<Materia> materiasAprobadas;

    //constructor
    public Alumno(String nombre, String apellido, List<Materia> materiasAprobadas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.materiasAprobadas = materiasAprobadas;
    }

    // setters y getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void setMateriasAprobadas(List<Materia> materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    // extras
    public void agregarMateriasAprobadas(List<Materia> materias){
        this.materiasAprobadas.addAll(materias);
    }

    public boolean aprobo(Materia unaMateria){
        return this.materiasAprobadas.contains(unaMateria);
    }

    public boolean puedeCursar(Materia unaMateria){
        List<Materia> correlativas = unaMateria.getMateriasCorrelativas();
        if(correlativas==null){
            return true;
        }
        for(Materia estaCorrelativa : correlativas){
            if(!this.aprobo(estaCorrelativa)){
                return false;
            }
        }
        return true;
    }
}
