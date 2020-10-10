package facades;

import DTOs.LightStatusDto;
import DTOs.LightStatusDtos;
import entities.LightStatus;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class LightStatusFacade {

    private static LightStatusFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private LightStatusFacade() {
    }

    public static LightStatusFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new LightStatusFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public LightStatus InserLightToDB(LightStatusDto lightDto) {
        EntityManager em = emf.createEntityManager();
        LightStatus light = new LightStatus(lightDto.name(), lightDto.status());
        try {
            em.getTransaction().begin();
            em.persist(light);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return light;
    }

    public LightStatus editLight(LightStatusDto lightDto) {
        EntityManager em = emf.createEntityManager();
        LightStatus light = em.find(LightStatus.class, lightDto.id());
        try {
            em.getTransaction().begin();
            light.setName(lightDto.name());
            light.setStatus(lightDto.status());
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return light;
    }

    public LightStatus popDb() {
        EntityManager em = emf.createEntityManager();
        LightStatus light = new LightStatus("Hej", false);
        try {
            em.getTransaction().begin();
            em.persist(light);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return light;
    }

    public LightStatusDtos getAllLights() {
        EntityManager em = emf.createEntityManager();

        try {
            Query query = em.createQuery("SELECT l FROM LightStatus l");
            List<LightStatus> lights = query.getResultList();
            LightStatusDtos lightdtos = new LightStatusDtos(lights);
            return lightdtos;
        } finally {
            em.close();
        }
    }

}
