package br.stats.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.stats.model.Statistic;
import br.stats.service.StatisticService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@Api(value = "statistics", description = "the statistics API")
public class StatisticApi {

	private final HttpServletRequest request;
	
	@Autowired
	private StatisticService statisticService;

    @org.springframework.beans.factory.annotation.Autowired
    public StatisticApi(ObjectMapper objectMapper, HttpServletRequest request) {
        this.request = request;
    }

    @ApiOperation(value = "Get statistics from last 60 seconds", nickname = "getStatistics", notes = "", response = Statistic.class, tags={ "statistics", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation", response = Statistic.class) })
    @RequestMapping(value = "/statistics",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    public ResponseEntity<Statistic> getStatistics(){
         	return new ResponseEntity<Statistic>(statisticService.getStatistic(), HttpStatus.OK);
    };

}
