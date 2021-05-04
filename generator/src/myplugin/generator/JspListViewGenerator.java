package myplugin.generator;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import freemarker.template.TemplateException;
import myplugin.generator.fmmodel.FMClass;
import myplugin.generator.fmmodel.FMEnumeration;
import myplugin.generator.fmmodel.FMModel;
import myplugin.generator.fmmodel.FMProperty;
import myplugin.generator.options.GeneratorOptions;
import myplugin.generator.options.ProjectOptions;
import myplugin.generator.options.TypeMapping;

public class JspListViewGenerator extends BasicGenerator {

	public JspListViewGenerator(GeneratorOptions generatorOptions) {
		super(generatorOptions);
	}

	public void generate() {

		 try {
	            super.generate();
	        } catch (IOException e) {
	            JOptionPane.showMessageDialog(null, e.getMessage());
	        }

	        List<FMClass> classes = FMModel.getInstance().getClasses();
	        for (int i = 0; i < classes.size(); i++) {
	            FMClass cl = classes.get(i);
	            Writer out;
	            Map<String, Object> context = new HashMap<String, Object>();
	            try {
	                String modelPackage = cl.getTypePackage();
	                String controllerPackage = replacePackageFragment(modelPackage, "model", "controller");
	                String servicePackage = replacePackageFragment(modelPackage, "model", "service");
	                String dtoPackage = replacePackageFragment(modelPackage, "model", "dto");

	                out = getWriter(cl.getName(), cl.getTypePackage());
	                if (out != null) {

	                    context.clear();

	                    List<String> javaTypes = new ArrayList<String>();
	                    List<TypeMapping> typeMappings = ProjectOptions.getProjectOptions().getTypeMappings();
	                    for(TypeMapping type: typeMappings) {
	                        javaTypes.add(type.getDestType());
	                    }

	                    List<String> enumerationTypes = new ArrayList<String>();
	                    List<FMEnumeration> enumerations = FMModel.getInstance().getEnumerations();
	                    for(FMEnumeration enumVal: enumerations) {
	                        enumerationTypes.add(enumVal.getName());
	                    }

	                    // find entity relations in properties
	                    Map<String, FMProperty> entity_relations = new HashMap<String, FMProperty>();
	                    for(FMProperty p: cl.getProperties()) {
	                        if(!javaTypes.contains(p.getType()) && !enumerationTypes.contains(p.getType())) {
	                            entity_relations.put(p.getType(), p);
	                        }
	                    }

	                    context.put("class", cl);
	                    context.put("properties", cl.getProperties());
	                    context.put("referencedProperties", cl.getReferencedProperties());
	                    getTemplate().process(context, out);
	                    out.flush();
	                }
	            } catch (TemplateException e) {
	                JOptionPane.showMessageDialog(null, e.getMessage());
	            } catch (IOException e) {
	                JOptionPane.showMessageDialog(null, e.getMessage());
	            }
	        }
	        
	 }       
	
}
