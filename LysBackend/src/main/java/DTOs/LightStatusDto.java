package DTOs;

import entities.LightStatus;
/**
 *
 * @author marcg
 */
public class LightStatusDto {
    private int id;
    private String name;
    private boolean status;

    public LightStatusDto(LightStatus light) {
        this.id = light.id();
        this.name = light.name();
        this.status = light.status();
    }
    
     public Integer id() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean status() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
