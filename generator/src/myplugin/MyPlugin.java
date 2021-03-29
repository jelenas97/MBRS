package myplugin;

import java.io.File;

import javax.swing.JOptionPane;

import myplugin.generator.options.GeneratorOptions;
import myplugin.generator.options.ProjectOptions;

import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.actions.ActionsConfiguratorsManager;

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

		GeneratorOptions ejbOptions = new GeneratorOptions(destDir, "ejbclass", "templates", "{0}.java", true, "ejb");
		
		ProjectOptions.getProjectOptions().getGeneratorOptions().put("EJBGenerator", ejbOptions);

		ejbOptions.setTemplateDir(pluginDir + File.separator + ejbOptions.getTemplateDir()); // apsolutna putanja
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