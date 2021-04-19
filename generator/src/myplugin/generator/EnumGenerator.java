package myplugin.generator;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import com.nomagic.magicdraw.core.Application;

import freemarker.template.TemplateException;
import myplugin.generator.fmmodel.FMEnumeration;
import myplugin.generator.fmmodel.FMModel;
import myplugin.generator.options.GeneratorOptions;

public class EnumGenerator extends BasicGenerator {

	public final String PROJECT_NAME = Application.getInstance().getProject().getName();

	public EnumGenerator(GeneratorOptions generatorOptions) {
		super(generatorOptions);
		// TODO Auto-generated constructor stub
	}

	public void generate() {

		try {
			super.generate();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		List<String> enumVals = new ArrayList<>();
		List<FMEnumeration> enums = FMModel.getInstance().getEnumerations();
		for (int i = 0; i < enums.get(0).getValuesCount(); i++) {
			enumVals.add(enums.get(0).getValueAt(i));
		}

		Writer out;
		Map<String, Object> context = new HashMap<String, Object>();
		try {
			out = getWriter(enums.get(0).getName(), enums.get(0).getTypePackage());
			if (out != null) {
				context.clear();
				context.put("enum", enums.get(0));
				context.put("app_name", PROJECT_NAME);
				context.put("values", enumVals);
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
