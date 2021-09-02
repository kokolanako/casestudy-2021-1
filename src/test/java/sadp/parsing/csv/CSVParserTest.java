
package sadp.parsing.csv;


import casestudy.dm.dto.StationDTO;
import casestudy.dm.sadp.parsing.csv.CSVParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CSVParserTest {

  private CSVParser parser;
  private String file= "DBNetz-Betriebsstellenverzeichnis-Stand2021-07.csv";

  @BeforeEach
  public void setUp(){
    this.parser =new CSVParser();
    this.parser.setSeparator(';');
    this.parser.setStationsFile(this.file);
    this.parser.setDataInResourcesFolder(true);
  }

  @Test
  public void testParsingMethod()  {
    try {
      this.parser.afterPropertiesSet();
      StationDTO dto=this.parser.getStations().get("bjf_s");
      Assertions.assertEquals("BJF S",dto.getRL100Code());
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
