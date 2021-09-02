
package casestudy.dm.sadp.parsing.csv;


import casestudy.dm.dto.StationDTO;
import casestudy.dm.spi.data.parsing.FileStationsParser;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.Setter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Component
public class CSVParser implements FileStationsParser, InitializingBean {
  @Setter
  @Value("${db.data.stations.resource.filename}")
  private String stationsFile;

  private char separator = ';';

  @Value("#{new Boolean('${db.data.stations.resource.fileInResources}')}")
  private Boolean dataInResourcesFolder;


  private Map<String, StationDTO> stationsMap = new HashMap<>();


  @Override
  public Map<String, StationDTO> getStations() {
    return this.stationsMap;
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    if (stationsFile == null || stationsFile.isBlank()) {
      throw new IOException("invalid file name in resources folder");
    }
    CsvMapper mapper = new CsvMapper();
    CsvSchema csvSchema = mapper.typedSchemaFor(StationDTO.class).withHeader()
        .withColumnSeparator(this.separator)
        .withNullValue(" ");
    MappingIterator<StationDTO> stations = null;
    if (dataInResourcesFolder.booleanValue()) {
      InputStream reader = getClass().getClassLoader().getResourceAsStream(this.stationsFile);
      stations = mapper.readerFor(StationDTO.class)
          .with(csvSchema)
          .readValues(reader);
    }
    while (stations.hasNextValue()) {
      StationDTO dto = stations.nextValue();
      String mapToKey = dto.getRL100Code().toLowerCase().replace(" ", "_");
      this.stationsMap.put(mapToKey, dto);
    }
  }
}
