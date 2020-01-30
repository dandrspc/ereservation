package com.platzi.ereservation.business.resourses;

import com.platzi.ereservation.business.resourses.vo.ClientVO;
import com.platzi.ereservation.business.services.ClientService;
import com.platzi.ereservation.model.Client;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("api/client")
@Api(tags = "Client")
public class ClientResource {

    private final ClientService clientService;
    public ClientResource(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    @ApiOperation(value = "Create client", notes = "Service to create a new client")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Client created")})
    public ResponseEntity<Client> createClient(@RequestBody ClientVO clientVo) {
        Client client = new Client();
        client.setName(clientVo.getName());
        client.setLastName(clientVo.getLastName());
        client.setAddress(clientVo.getAddress());
        client.setPhoneNumber(clientVo.getPhoneNumber());
        client.setEmail(clientVo.getEmail());
        return new ResponseEntity<>(this.clientService.update(client), HttpStatus.OK);
    }

    @PutMapping("/{identification}")
    public ResponseEntity<Client> updateClient(@PathVariable("identification") String identification, ClientVO clientVO) {
        Client client = this.clientService.findByIdentification(identification);
        if(client == null){
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }else {
            client.setName(clientVO.getName());
            client.setLastName(clientVO.getLastName());
            client.setAddress(clientVO.getAddress());
            client.setPhoneNumber(clientVO.getPhoneNumber());
            client.setEmail(clientVO.getEmail());
        }
        return new ResponseEntity<>(this.clientService.create(client), HttpStatus.CREATED);
    }

    @DeleteMapping("/{identification}")
    public void removeClient(@PathVariable("identification") String identification, ClientVO clientVO) {
        Client client = this.clientService.findByIdentification(identification);
        if(client != null){
            this.clientService.delete(client);
        }
    }
    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
        return ResponseEntity.ok(this.clientService.findAll());
    }
}
