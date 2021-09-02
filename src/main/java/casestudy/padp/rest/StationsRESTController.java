
package casestudy.padp.rest;

import casestudy.dm.dto.StationDTO;
import casestudy.dm.impl.StationsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/betriebsstelle")
public class StationsRESTController {
  @Autowired
  private StationsService stationsService;

//
//  public StationsRESTController(StationsService stationsService){}

  private static final Logger LOGGER = LoggerFactory.getLogger(StationsRESTController.class);

  /**
   * @param request url with requested station-code
   * @return
   */
  @GetMapping("/**")
  public ResponseEntity getStationInformation(HttpServletRequest request) {

    LOGGER.info("Request to url: {} and uri: {} ", request.getRequestURL().toString(), request.getRequestURI());
    String stationAbbreviation = this.extractStationCode(request.getRequestURI());
    StationDTO stationDto = this.stationsService.getStationByCode(stationAbbreviation);
    LOGGER.info("Request for station: {}", stationAbbreviation);
    if (stationDto == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data found for the station: " + stationAbbreviation);
    }
    return ResponseEntity.status(HttpStatus.OK).body(stationDto);
  }

  private String extractStationCode(String requestURI) {
    String excludeBaseRequestMapping = this.getClass().getAnnotation(RequestMapping.class).value()[0] + "/"; //reflection
    String station = requestURI.replace(excludeBaseRequestMapping, "");
    return station.trim();
  }
}
