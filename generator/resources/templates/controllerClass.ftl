package ${class.typePackage};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;

import service.${class.name}Service;

@Controller
@RequestMapping("/${class.name}")
public class ${class.name}Controller{

	@Autowired
	private ${class.name}Service ${class.name?uncap_first}Service;
	
	
	@GetMapping(value = "/all")
	public ResponseEntity<List< ${class.name}>> getAll() {
        try {
            return new ResponseEntity<>( ${class.name?uncap_first}Service.getAll(), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
	@GetMapping(value = "/{id}")
	public ResponseEntity<List<${class.name}>> getOne(@PathVariable Long id) {

        try {
            return new ResponseEntity<>(${class.name?uncap_first}Service.getOne(id), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @PutMapping(value="/update/{id}")
    public ResponseEntity update(@PathVariable Long id,  @RequestBody ${class.name} ${class.name?uncap_first}) {
        try {
            ${class.name} ${class.name?uncap_first}1 = ${class.name?uncap_first}Service.update(${class.name?uncap_first});

            if ( ${class.name?uncap_first}1 == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>( ${class.name?uncap_first}1, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getStackTrace(), HttpStatus.BAD_REQUEST);
        }
    }
      
    @PostMapping("/add")
    public ResponseEntity< ${class.name}> add(@RequestBody ${class.name} ${class.name?uncap_first}){

        try {

            ${class.name}  ${class.name?uncap_first}1 =  ${class.name?uncap_first}Service.add(${class.name?uncap_first});
            if (${class.name?uncap_first}1  == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
                return new ResponseEntity<>(${class.name?uncap_first}1, HttpStatus.CREATED);

        } catch (Exception e){
            System.out.println(e);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PutMapping(value="/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {

        Boolean deleted = ${class.name?uncap_first}Service.delete(id);

        if (deleted) {
            return new ResponseEntity<Boolean>(${class.name?uncap_first}Service.delete(id), HttpStatus.OK);
        }

        return new ResponseEntity<Boolean>(${class.name?uncap_first}Service.delete(id), HttpStatus.NOT_FOUND);
    }
 
}