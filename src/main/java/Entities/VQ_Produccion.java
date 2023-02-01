package Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "VQ_Produccion")
public class VQ_Produccion implements Serializable {

    @Id
    @Column(name = "mesproduccion")
    private int mes_produccion;

    @Column(name = "litros")
    private int litros;

    @Id
    @Column(name = "year_produccion")
    private int year_produccion;

    @Id
    @ManyToOne
    @JoinColumn(name = "idVaca")
    private VQ_Ganado VQGanado;
    
    public VQ_Produccion(){

    }

    public VQ_Produccion(int mes_produccion, int litros, int year_produccion, VQ_Ganado VQGanado) {
        this.mes_produccion = mes_produccion;
        this.litros = litros;
        this.year_produccion = year_produccion;
        this.VQGanado = VQGanado;
    }

    @Override
    public String toString() {
        return String.format("año produccion: %d, mes produccion: %s, litros producidos: %d, id de la VQ_Ganado: %d",year_produccion, mes_produccion, litros, VQGanado.getIdVaca());

    }

    public int getMes_produccion() {
        return mes_produccion;
    }

    public void setMes_produccion(int mes_produccion) {
        this.mes_produccion = mes_produccion;
    }

    public int getLitros() {
        return litros;
    }

    public void setLitros(int litros) {
        this.litros = litros;
    }

    public int getYear_produccion() {
        return year_produccion;
    }

    public void setYear_produccion(int year_produccion) {
        this.year_produccion = year_produccion;
    }

    public VQ_Ganado getVQGanado() {
        return VQGanado;
    }

    public void setVQGanado(VQ_Ganado VQGanado) {
        this.VQGanado = VQGanado;
    }
}
