package ${class.typePackage};

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.${class.name}Repository;
import service.${class.name}Service;
import model.*;
import java.util.Optional;
import java.util.Date;

@Service
public class ${class.name}ServiceImpl implements ${class.name}Service {

    @Autowired
    private ${class.name}Repository ${class.name?uncap_first}Repository;

    @Override
    public List < ${class.name} > getAll() {
    return this.${class.name?uncap_first}Repository.findAll();
    }

    @Override
    public Optional <${class.name}> getOne(Long id) {
    return this.${class.name?uncap_first}Repository.findById(id);
    }

    @Override
    public void update(${class.name} ${class.name?uncap_first}) {
    this.${class.name?uncap_first}Repository.save(${class.name?uncap_first});
    }

    @Override
    public void add(${class.name} ${class.name?uncap_first}) {
    this.${class.name?uncap_first}Repository.save(${class.name?uncap_first});
    }

    @Override
    public void delete(Long id) {
        Optional <${class.name}> ${class.name?uncap_first} = ${class.name?uncap_first}Repository.findById(id);
        if (${class.name?uncap_first}.isPresent()) {
        ${class.name?uncap_first}Repository.delete(${class.name?uncap_first}.get());
        }
    }
    
<#list methods as method>
	<#if method.returnType.name == "Collection" || method.returnType.name == "Set" || method.returnType.name == "List" >
    @Override
    ${method.visibility} ${method.returnType.name}<${class.name}> ${method.name}Generated(<#list method.parameters as parameter>${parameter.type.name} ${parameter.name}<#sep>, </#sep></#list>){
        // TODO Auto-generated method stub
    }

	<#else>
    @Override
    ${method.visibility} ${method.returnType.name} ${method.name}Generated(<#list method.parameters as parameter>${parameter.type.name} ${parameter.name}<#sep>, </#sep></#list>){
        // TODO Auto-generated method stub
    }

	</#if>
</#list>
}


