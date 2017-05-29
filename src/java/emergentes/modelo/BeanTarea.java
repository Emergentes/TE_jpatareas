/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emergentes.modelo;

import emergentes.entidades.Tarea;
import emergentes.jpa.TareaJpaController;
import emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BeanTarea {

    private EntityManagerFactory emf;
    private TareaJpaController daoTarea;

    public BeanTarea() {

        emf = Persistence.createEntityManagerFactory("TE_jpatareasPU");
        daoTarea = new TareaJpaController(emf);
    }

    public void insertar(Tarea t) {
        daoTarea.create(t);
    }

    public void editar(Tarea t) throws Exception {
        daoTarea.edit(t);
    }

    public void eliminar(int id) throws NonexistentEntityException {
        daoTarea.destroy(id);
    }

    public List<Tarea> obtenerTodos() {
        return daoTarea.findTareaEntities();
    }

    public Tarea buscarTarea(int id) {
        return daoTarea.findTarea(id);
    }
}
