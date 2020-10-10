/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOs;

import entities.LightStatus;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcg
 */
public class LightStatusDtos {
    
    List<LightStatusDto> all = new ArrayList();

    public LightStatusDtos(List<LightStatus> Lights) {
        Lights.forEach((p) -> {
            all.add(new LightStatusDto(p));
        });
    }

    public List<LightStatusDto> getAll() {
        return all;
    }

    public void setAll(List<LightStatusDto> all) {
        this.all = all;
    }
    
    
}
