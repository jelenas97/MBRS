package ${class.typePackage};

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import ${class.typePackage}.${class.name};

@Repository
public interface ${class.name}Repository extends JpaRepository<${class.name}> {

}