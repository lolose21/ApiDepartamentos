package models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Departamento {

    private int deptno;
    private String nombre;
    private String localidad;

    public Departamento() {
    }

    public Departamento(int deptno, String nombre, String localidad) {
        this.deptno = deptno;
        this.nombre = nombre;
        this.localidad = localidad;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

}
