package casestudy.dm.spi.data.parsing;

import casestudy.dm.dto.StationDTO;
import java.util.Map;

public interface FileStationsParser {
  Map<String, StationDTO> getStations();
}
