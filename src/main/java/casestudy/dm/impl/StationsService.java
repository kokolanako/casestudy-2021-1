
package casestudy.dm.impl;

import casestudy.dm.dto.StationDTO;
import casestudy.dm.spi.data.parsing.FileStationsParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationsService {
  @Autowired
  private FileStationsParser data;


//  public StationsService(FileStationsParser data) {
//
//  }

  public StationDTO getStationByCode(String RL100Code){
    return this.data.getStations().get(RL100Code);
  }
}
