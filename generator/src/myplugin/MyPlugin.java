package myplugin;

import java.io.File;

import javax.swing.JOptionPane;

import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.actions.ActionsConfiguratorsManager;


import myplugin.generator.options.GeneratorOptions;
import myplugin.generator.options.ProjectOptions;

/** MagicDraw plugin that performes code generation
 * 
 * 
 * Tip: Run Eclipse as admin
 * 
 * 
 * This plugin will use the Java 1.8 spec but MagicDraw 17.0.3 comes preinstalled with Java 1.7
 * To fix this, make MagicDraw use your custom JRE
 * Open MAGICDRAW_HOME folder, and inside bin folder, open mduml.properties
 * Simply change JAVA_HOME to your JRE location, for example:JAVA_HOME=C:\\Program Files\\Java\\jdk1.8.0_251
 **/
public class MyPlugin extends com.nomagic.magicdraw.plugins.Plugin {

	String pluginDir = null;

	public void init() {
		JOptionPane.showMessageDialog(null, "Code generator is loaded!");

		pluginDir = getDescriptor().getPluginDirectory().getPath();

		// Creating submenu in the MagicDraw main menu
		ActionsConfiguratorsManager manager = ActionsConfiguratorsManager.getInstance();
		manager.addMainMenuConfigurator(new MainMenuConfigurator(getSubmenuActions()));

		/**
		 * @Todo: load project options (@see myplugin.generator.options.ProjectOptions)
		 *        from ProjectOptions.xml and take ejb generator options
		 */
		
		String destDir = System.getProperty("user.home") + File.separator + "__generated__";

		GeneratorOptions ejbOptions = new GeneratorOptions(destDir + File.separator + "src" + File.separator + "main" + File.separator + "java", "ejbclass", "templates", "{0}.java", true, "mbrs.tim2.model"); 
		
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("EJBGenerator", ejbOptions); 
		
		ejbOptions.setTemplateDir(pluginDir + File.separator +  ejbOptions.getTemplateDir()); // apsolutna putanja 
		
		GeneratorOptions repositoryOptions = new GeneratorOptions(destDir + File.separator + "src" + File.separator + "main" + File.separator + "java", "repositoryclass", "templates", "{0}Repository.java", true, "mbrs.tim2.repository");
		
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("RepositoryGenerator", repositoryOptions);
		
		repositoryOptions.setTemplateDir(pluginDir + File.separator + repositoryOptions.getTemplateDir()); // apsolutna putanja
		
		GeneratorOptions serviceOptions = new GeneratorOptions(destDir + File.separator + "src" + File.separator + "main" + File.separator + "java", "serviceClass", "templates", "{0}Service.java", true, "mbrs.tim2.service");
		
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("ServiceGenerator", serviceOptions);
		
		serviceOptions.setTemplateDir(pluginDir + File.separator + serviceOptions.getTemplateDir()); // apsolutna putanja
		
		GeneratorOptions serviceImplOptions = new GeneratorOptions(destDir + File.separator + "src" + File.separator + "main" + File.separator + "java", "serviceImplClass", "templates", "{0}ServiceImpl.java", true, "mbrs.tim2.service.impl");
		
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("ServiceImplGenerator", serviceImplOptions);
		
		serviceImplOptions.setTemplateDir(pluginDir + File.separator + serviceImplOptions.getTemplateDir()); // apsolutna putanja
		
		GeneratorOptions controllerOptions = new GeneratorOptions(destDir + File.separator + "src" + File.separator + "main" + File.separator + "java", "controllerClass", "templates", "{0}Controller.java", true, "mbrs.tim2.controller");
		
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("ControllerGenerator", controllerOptions);
		
		controllerOptions.setTemplateDir(pluginDir + File.separator + controllerOptions.getTemplateDir()); // apsolutna putanja
		
		GeneratorOptions pomOptions = new GeneratorOptions(destDir, "pomFile", "templates", "pom.xml", true, "");
		
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("PomGenerator", pomOptions);
		
		pomOptions.setTemplateDir(pluginDir + File.separator + pomOptions.getTemplateDir()); // apsolutna putanja

		GeneratorOptions appPropOptions = new GeneratorOptions(destDir + File.separator + "src" + File.separator + "main" + File.separator + "resources", "appPropertiesFile", "templates", "application.properties.xml", true, "");
		
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("ApplicationPropertiesGenerator", appPropOptions);
		
		appPropOptions.setTemplateDir(pluginDir + File.separator + appPropOptions.getTemplateDir()); // apsolutna putanja
		
		GeneratorOptions mainOptions = new GeneratorOptions(destDir + File.separator + "src" + File.separator + "main" + File.separator + "java", "mainClass", "templates", "{0}.java", true, "mbrs.tim2");
		
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("MainGenerator", mainOptions);
	
		mainOptions.setTemplateDir(pluginDir + File.separator + mainOptions.getTemplateDir()); // apsolutna putanja

	}

	private NMAction[] getSubmenuActions() {
		return new NMAction[] { new GenerateAction("Generate"), };
	}

	public boolean close() {
		return true;
	}

	public boolean isSupported() {
		return true;
	}
}
