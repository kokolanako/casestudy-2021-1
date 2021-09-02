
package casestudy.dm.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({"PLC", "RL100-Code", "RL100-Langname", "RL100-Kurzname",
    "Typ Kurz", "Typ Lang", "Betriebszustand", "Datum ab", "Datum bis", "Niederlassung", "Regionalbereich", "Letzte Änderung"})
public class StationDTO {

  @JsonProperty("PLC")
  private String plc;

  @JsonProperty("RL100-Code")
  private String RL100Code;

  @JsonProperty("RL100-Langname")
  private String RL100LongName;

  @JsonProperty("RL100-Kurzname")
  private String RL100ShortName;

  @JsonProperty("Typ Kurz")
  private String shortType;

  @JsonProperty("Typ Lang")
  private String longType;

  @JsonProperty("Betriebszustand")
  private String operationalState;

  @JsonProperty("Datum ab")
  private String dateFrom;

  @JsonProperty("Datum bis")
  private String dateUntil;

  @JsonProperty("Niederlassung")
  private String location;

  @JsonProperty("Regionalbereich")
  private String region;

  @JsonProperty("Letzte Änderung")
  private String lastChange;

  @Override
  public String toString() {
    return "Station: " + plc + " | " + RL100Code + " | "
        + RL100LongName + " | " + RL100ShortName + " | " + shortType + " | "
        + longType + " | " + operationalState
        + " | " + location + " | "
        + region;
  }
}
