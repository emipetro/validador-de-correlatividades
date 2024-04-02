package domain;

import java.util.List;

public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materias;

    //constructor
    public Inscripcion(Alumno alumno, List<Materia> materias) {
        this.alumno = alumno;
        this.materias = materias;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    //aprobada
    public boolean aprobada(){
        for(Materia materia : materias){
            if(!alumno.puedeCursar(materia)){
                return false;
            }
        }
        return true;
    }

}
