
package casestudy.dm.impl;

import casestudy.dm.dto.StationDTO;
import casestudy.dm.spi.data.parsing.FileStationsParser;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationsService {

  @Setter
  @Autowired
  private FileStationsParser data;

  public StationDTO getStationByCode(String RL100Code){
    return this.data.getStations().get(RL100Code);
  }
}
