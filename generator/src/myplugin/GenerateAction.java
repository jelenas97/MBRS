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
import myplugin.generator.RepositoryGenerator;
import myplugin.generator.ServiceGenerator;
import myplugin.generator.ServiceImplGenerator;
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
	
		ModelAnalyzer analyzer = new ModelAnalyzer(root, "model");
		
		ModelAnalyzer analyzer2 = new ModelAnalyzer(root, "repository");
		
		ModelAnalyzer analyzer3 = new ModelAnalyzer(root, "service");

		ModelAnalyzer analyzer4 = new ModelAnalyzer(root, "service.impl");
		
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