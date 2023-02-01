package Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "VQ_Ganado")
// insert into VQ_Ganado (ID, fechaEntrada, fechaSacrificio, nombre, idNave, id_madre) values (1, '2015-02-13', '2021-02-13', 'Orly', 2, null);
public class VQ_Ganado implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private int idVaca;

    @Column(name = "fechaEntrada")
    private String fechaEntrada;

    @Column(name = "fechaSacrificio")
    private String fechaSacrificio;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idNave")
    private VQ_Naves VQNaves;

    @ManyToOne
    @JoinColumn(name = "idVaca")
    private VQ_Ganado madre;

    @OneToMany//(cascade = CascadeType.ALL)
    @Column(name = "idVaca")
    private List<VQ_Produccion> listaProducciones;

    @OneToMany//(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_madre")
    private List<VQ_Ganado> listaVacasHijas;


    public VQ_Ganado() {
    }

    public VQ_Ganado(int idVaca, String fechaEntrada, String fechaSacrificio, String nombre, VQ_Naves idVQNaves, VQ_Ganado madre, List<VQ_Produccion> listaProducciones) {
        this.idVaca = idVaca;
        this.fechaEntrada = fechaEntrada;
        this.fechaSacrificio = fechaSacrificio;
        this.nombre = nombre;
        this.VQNaves = idVQNaves;
        this.madre = madre;
        this.listaProducciones = listaProducciones;
    }

    public VQ_Ganado(String fechaEntrada, String fechaSacrificio, String nombre, VQ_Naves idVQNaves, VQ_Ganado madre, List<VQ_Produccion> listaProducciones) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSacrificio = fechaSacrificio;
        this.nombre = nombre;
        this.VQNaves = idVQNaves;
        this.madre = madre;
        this.listaProducciones = listaProducciones;
    }

    public int getIdVaca() {
        return idVaca;
    }

    public void setIdVaca(int idVaca) {
        this.idVaca = idVaca;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSacrificio() {
        return fechaSacrificio;
    }

    public void setFechaSacrificio(String fechaSacrificio) {
        this.fechaSacrificio = fechaSacrificio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public VQ_Naves getIdNave() {
        return VQNaves;
    }

    public void setIdNave(VQ_Naves idVQNaves) {
        this.VQNaves = idVQNaves;
    }

    public VQ_Ganado getMadre() {
        return madre;
    }

    public void setIdMadre(VQ_Ganado madre) {
        this.madre = madre;
    }

    public List<VQ_Produccion> getListaProducciones (){
        return listaProducciones;
    }
    public void setListaProducciones (List<VQ_Produccion> listaProducciones){
        this.listaProducciones = listaProducciones;
    }


}
