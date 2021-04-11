package myplugin.generator;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.ui.MainFrame;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import myplugin.generator.options.GeneratorOptions;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.TemplateException;

public class PomGenerator extends BasicGenerator {
	public final String PROJECT_NAME = Application.getInstance().getProject().getName();
	
	public PomGenerator(GeneratorOptions generatorOptions) {
		super(generatorOptions);
	}

	public void generate() {

		String pom = "pom";
		String packageName = "";

		try {
			super.generate();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		Writer out;
		Map<String, Object> context = new HashMap<String, Object>();
		try {
			out = getWriter(pom, packageName);
			if (out != null) {
				context.clear();
				context.put("project_name", PROJECT_NAME);
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
