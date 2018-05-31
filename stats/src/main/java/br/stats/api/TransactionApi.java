package br.stats.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.stats.model.Transaction;
import br.stats.model.TransactionJson;
import br.stats.service.TransactionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@Api(value = "transactions", description = "the transactions API")
public class TransactionApi {

    private final HttpServletRequest request;
    
    @Autowired
    private TransactionService transactionService;

    @org.springframework.beans.factory.annotation.Autowired
    public TransactionApi(ObjectMapper objectMapper, HttpServletRequest request) {
        this.request = request;
    }
    
    @ApiOperation(value = "Add a new Transaction", nickname = "addTransaction", notes = "", tags={ "transactions", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Successful transaction"),
        @ApiResponse(code = 204, message = "Transaction is older than 60 seconds") })
    @RequestMapping(value = "/transactions",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> addTransaction(@ApiParam(value = "Transaction" ,required=true )  @Valid @RequestBody TransactionJson body){
    	try {
        	transactionService.addTransaction(body);
    	} catch(Exception e) {
            return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);    		
        }
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    };

}
