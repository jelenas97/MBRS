package myplugin;

import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import myplugin.analyzer.AnalyzeException;
import myplugin.analyzer.ModelAnalyzer;
import myplugin.generator.EJBGenerator;
import myplugin.generator.EnumGenerator;
import myplugin.generator.EnumInterfaceGenerator;
import myplugin.generator.HomeControllerGenerator;
import myplugin.generator.JspDetailsViewGenerator;
import myplugin.generator.JspFormGenerator;
import myplugin.generator.JspHomePageGenerator;
import myplugin.generator.JspListViewGenerator;
import myplugin.generator.JspNavbarGenerator;
import myplugin.generator.MainGenerator;
import myplugin.generator.PomGenerator;
import myplugin.generator.RepositoryGenerator;
import myplugin.generator.ServiceGenerator;
import myplugin.generator.ServiceImplGenerator;
import myplugin.generator.ApplicationPropertiesGenerator;
import myplugin.generator.ConfigurationGenerator;
import myplugin.generator.ControllerGenerator;
import myplugin.generator.fmmodel.FMModel;
import myplugin.generator.options.GeneratorOptions;
import myplugin.generator.options.ProjectOptions;


/** Action that activate code generation */
@SuppressWarnings("serial")
class GenerateAction extends MDAction{
	
	
	public GenerateAction(String name) {			
		super("", name, null, null);		
	}

	public void actionPerformed(ActionEvent evt) {
		
		if (Application.getInstance().getProject() == null) return;
		Package root = Application.getInstance().getProject().getModel();
		
		if (root == null) return;
	
		ModelAnalyzer analyzer = new ModelAnalyzer(root, "mbrs.tim2.model");
		
		ModelAnalyzer analyzer2 = new ModelAnalyzer(root, "mbrs.tim2.repository");
		
		ModelAnalyzer analyzer3 = new ModelAnalyzer(root, "mbrs.tim2.service");

		ModelAnalyzer analyzer4 = new ModelAnalyzer(root, "mbrs.tim2.service.impl");
		
		ModelAnalyzer analyzer5 = new ModelAnalyzer(root, "mbrs.tim2.controller");
		
		ModelAnalyzer analyzer6 = new ModelAnalyzer(root, "mbrs.tim2");
		
		ModelAnalyzer analyzer7 = new ModelAnalyzer(root, "mbrs.tim2");
		
		ModelAnalyzer analyzer8 = new ModelAnalyzer(root, "mbrs.tim2");
		
		ModelAnalyzer analyzer9 = new ModelAnalyzer(root, "");
		
		ModelAnalyzer analyzer10 = new ModelAnalyzer(root, "");

		ModelAnalyzer analyzer11 = new ModelAnalyzer(root, "");
		
		ModelAnalyzer analyzer12 = new ModelAnalyzer(root, "mbrs.tim2.enumerations");
		
		ModelAnalyzer analyzer13 = new ModelAnalyzer(root, "mbrs.tim2.enumerations");
		
		ModelAnalyzer analyzer14 = new ModelAnalyzer(root, "mbrs.tim2.controller");
		
		ModelAnalyzer analyzer15 = new ModelAnalyzer(root, "mbrs.tim2.configuration");
		
		ModelAnalyzer analyzer16 = new ModelAnalyzer(root, "");

		ModelAnalyzer analyzer17 = new ModelAnalyzer(root, "");
		
		try {
			analyzer.prepareModel();	
			GeneratorOptions go1 = ProjectOptions.getProjectOptions().getGeneratorOptions().get("EJBGenerator");			
			EJBGenerator ejbGenerator = new EJBGenerator(go1);
			ejbGenerator.generate();
			
			analyzer2.prepareModel();	
			GeneratorOptions go2 = ProjectOptions.getProjectOptions().getGeneratorOptions().get("RepositoryGenerator");			
			RepositoryGenerator repositoryGenerator = new RepositoryGenerator(go2);
			repositoryGenerator.generate();
			
			analyzer3.prepareModel();	
			GeneratorOptions go3 = ProjectOptions.getProjectOptions().getGeneratorOptions().get("ServiceGenerator");			
			ServiceGenerator serviceGenerator = new ServiceGenerator(go3);
			serviceGenerator.generate();
			
			analyzer4.prepareModel();	
			GeneratorOptions go4 = ProjectOptions.getProjectOptions().getGeneratorOptions().get("ServiceImplGenerator");			
			ServiceImplGenerator serviceImplGenerator = new ServiceImplGenerator(go4);
			serviceImplGenerator.generate();
			
			analyzer5.prepareModel();	
			GeneratorOptions go5 = ProjectOptions.getProjectOptions().getGeneratorOptions().get("ControllerGenerator");			
			ControllerGenerator controllerGenerator = new ControllerGenerator(go5);
			controllerGenerator.generate();
			
			analyzer6.prepareModel();	
			GeneratorOptions go6 = ProjectOptions.getProjectOptions().getGeneratorOptions().get("PomGenerator");			
			PomGenerator pomGenerator = new PomGenerator(go6);
			pomGenerator.generate();
			
			analyzer7.prepareModel();	
			GeneratorOptions go7 = ProjectOptions.getProjectOptions().getGeneratorOptions().get("ApplicationPropertiesGenerator");			
			ApplicationPropertiesGenerator appPropGenerator = new ApplicationPropertiesGenerator(go7);
			appPropGenerator.generate();
			
			analyzer8.prepareModel();	
			GeneratorOptions go8 = ProjectOptions.getProjectOptions().getGeneratorOptions().get("MainGenerator");			
			MainGenerator mainGenerator = new MainGenerator(go8);
			mainGenerator.generate();
			
			analyzer9.prepareModel();	
			GeneratorOptions go9 = ProjectOptions.getProjectOptions().getGeneratorOptions().get("JspFormGenerator");			
			JspFormGenerator jspFormGenerator = new JspFormGenerator(go9);
			jspFormGenerator.generate();
			
			analyzer10.prepareModel();	
			GeneratorOptions go10 = ProjectOptions.getProjectOptions().getGeneratorOptions().get("JspListViewGenerator");			
			JspListViewGenerator jspListViewGenerator = new JspListViewGenerator(go10);
			jspListViewGenerator.generate();
			
			analyzer11.prepareModel();	
			GeneratorOptions go11 = ProjectOptions.getProjectOptions().getGeneratorOptions().get("JspDetailsViewGenerator");			
			JspDetailsViewGenerator jspDetailsViewGenerator = new JspDetailsViewGenerator(go11);
			jspDetailsViewGenerator.generate();
			
			analyzer12.prepareModel();	
			GeneratorOptions go12 = ProjectOptions.getProjectOptions().getGeneratorOptions().get("EnumGenerator");			
			EnumGenerator enumGenerator = new EnumGenerator(go12);
			enumGenerator.generate();
			
			analyzer13.prepareModel();	
			GeneratorOptions go13 = ProjectOptions.getProjectOptions().getGeneratorOptions().get("EnumInterfaceGenerator");			
			EnumInterfaceGenerator enumInterfaceGenerator = new EnumInterfaceGenerator(go13);
			enumInterfaceGenerator.generate();
			
			analyzer14.prepareModel();	
			GeneratorOptions go14 = ProjectOptions.getProjectOptions().getGeneratorOptions().get("HomeControllerGenerator");			
			HomeControllerGenerator homeControllerGenerator = new HomeControllerGenerator(go14);
			homeControllerGenerator.generate();
			
			analyzer15.prepareModel();	
			GeneratorOptions go15 = ProjectOptions.getProjectOptions().getGeneratorOptions().get("ConfigurationGenerator");			
			ConfigurationGenerator configurationGenerator = new ConfigurationGenerator(go15);
			configurationGenerator.generate();
			
			analyzer16.prepareModel();	
			GeneratorOptions go16 = ProjectOptions.getProjectOptions().getGeneratorOptions().get("JspHomePageGenerator");			
			JspHomePageGenerator jspHomePageGenerator = new JspHomePageGenerator(go16);
			jspHomePageGenerator.generate();
			
			analyzer17.prepareModel();	
			GeneratorOptions go17 = ProjectOptions.getProjectOptions().getGeneratorOptions().get("JspNavbarGenerator");			
			JspNavbarGenerator jspNavbarGen = new JspNavbarGenerator(go17);
			jspNavbarGen.generate();
			
			/**  @ToDo: Also call other generators */
			JOptionPane.showMessageDialog(null, "Code is successfully generated! Generated code is in folder: " + go1.getOutputPath());
			exportToXml();
		} catch (AnalyzeException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} 			
	}
	
	private void exportToXml() {
		if (JOptionPane.showConfirmDialog(null, "Do you want to export generated classes as XML?") == 
			JOptionPane.OK_OPTION)
		{	
			JFileChooser jfc = new JFileChooser();
			if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				String fileName = jfc.getSelectedFile().getAbsolutePath();
			
				XStream xstream = new XStream(new DomDriver());
				BufferedWriter out;		
				try {
					out = new BufferedWriter(new OutputStreamWriter(
							new FileOutputStream(fileName), "UTF8"));					
					xstream.toXML(FMModel.getInstance().getClasses(), out);
					xstream.toXML(FMModel.getInstance().getEnumerations(), out);
					
				} catch (UnsupportedEncodingException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());				
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());				
				}		             
			}
		}	
	}	  

}