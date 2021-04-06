package ${class.typePackage};

import java.util.Optional;
import java.util.List;
import model.*;
import org.springframework.stereotype.Service;

@Service
public interface ${class.name}Service {

    List <${class.name}> getAll();

    Optional < ${class.name} > getOne(Long id);

    void update(${class.name} ${class.name?lower_case});

    void add(${class.name} ${class.name?lower_case});

    void delete(Long id);
    
<#list methods as method>
    ${method.visibility} ${method.returnType.name} ${method.name}Generated(<#list method.parameters as parameter>${parameter.type.name} ${parameter.name}<#sep>, </#sep></#list>);
</#list>
}
