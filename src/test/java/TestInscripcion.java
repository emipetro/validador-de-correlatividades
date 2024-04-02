import domain.Materia;
import domain.Alumno;
import domain.Inscripcion;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class TestInscripcion {
    public void testAprobada_alumnoPuedeCursarTodo(){
        // materias
        Materia syo = new Materia("SyO",null);
        Materia ayed = new Materia("AyED",null);
        Materia ads = new Materia("AdS",List.of(syo,ayed));

        // alumno
        List<Materia> materiasAprobadas = new ArrayList<>();
        materiasAprobadas.add(syo);
        materiasAprobadas.add(ayed);

        Alumno alumno = new Alumno("Juan","Suarez",materiasAprobadas);

        // inscripcion

        List<Materia> materiasInscripcion = new ArrayList<>();
        materiasInscripcion.add(ads);
        Inscripcion inscripcion = new Inscripcion(alumno,materiasInscripcion);

        assertTrue("El alumno puede cursar todas las materias de la inscripción",inscripcion.aprobada());
    }

    public void testAprobada_alumnoNoPuedeCursarTodo(){
        //materias
        Materia ayed = new Materia("AyED",null);
        Materia ami = new Materia("AMI",null);
        Materia discreta = new Materia("Discreta", null);
        Materia sintaxis = new Materia("Sintaxis",List.of(discreta,ayed));

        //alumno
        List<Materia> materiasAprobadas = new ArrayList<>();
        materiasAprobadas.add(ami);
        materiasAprobadas.add(ayed);

        Alumno alumno = new Alumno("Mario","Perez",materiasAprobadas);

        //inscripcion
        List<Materia> materiasInscripcion = new ArrayList<>();
        materiasInscripcion.add(sintaxis);
        Inscripcion inscripcion = new Inscripcion(alumno,materiasInscripcion);

        assertFalse("El alumno puede cursar todas las materias de la inscripción",inscripcion.aprobada());
    }
}