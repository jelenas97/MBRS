package ${class.typePackage};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import mbrs.tim2.model.${class.name};
<#list referencedProperties as property>
import mbrs.tim2.model.${property.type?cap_first};
</#list>
import org.springframework.ui.Model;
import java.util.Collection;
import java.util.List;

import mbrs.tim2.service.${class.name}Service;
<#list referencedProperties as property>
import mbrs.tim2.service.${property.type?cap_first}Service;
</#list>

@Controller
@RequestMapping("/${class.name?uncap_first}")
public class ${class.name}Controller{

	@Autowired
	private ${class.name}Service ${class.name?uncap_first}Service;
	
	<#list referencedProperties as property>
	@Autowired
	private ${property.type?cap_first}Service ${property.type?uncap_first}Service;
	</#list>
	
	
	
	@GetMapping
	public String getAll(Model model) {
		initModel(model);
		return "${class.name}ListView";
    }
    
	@GetMapping(value = "/new")
	public String create(Model model) {
		initModel(model);
		<#list referencedProperties as property>
		List<${property.type?cap_first}> ${property.name?uncap_first}List = (List<${property.type?cap_first}>) ${property.type?uncap_first}Service.getAll();
        model.addAttribute("${property.name?uncap_first}List", ${property.name?uncap_first}List);
		</#list>
		return "${class.name}Form";
    }
    
    @PostMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @ModelAttribute ${class.name} ${class.name?uncap_first}) {
        try {
            ${class.name?uncap_first}Service.save(${class.name?uncap_first});
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getStackTrace(), HttpStatus.BAD_REQUEST);
        }
    }
      
    @PostMapping(value = "/new")
    public String add(@ModelAttribute ${class.name} ${class.name?uncap_first}){
 
            ${class.name?uncap_first}Service.save(${class.name?uncap_first});
            return "redirect:/${class.name?uncap_first}";
    }
    
    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<${class.name}> delete(@PathVariable Long id) {
    	${class.name} ${class.name?uncap_first} = ${class.name?uncap_first}Service.getById(id);
    	
    	try {
    		${class.name?uncap_first}Service.delete(${class.name?uncap_first});
    		return new ResponseEntity<>(${class.name?uncap_first}, HttpStatus.OK);
    	}
    	catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
    
    private void initModel(Model model) {
    	model.addAttribute("${class.name?uncap_first}", new ${class.name}());
    	model.addAttribute("${class.name?uncap_first}List", ${class.name?uncap_first}Service.getAll());
    }
 
}
