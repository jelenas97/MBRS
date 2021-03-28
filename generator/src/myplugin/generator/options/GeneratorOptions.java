package myplugin.generator.options;

/** GeneratorOptions: options used for code generation. Every generator (ejb generator, forms generator etc) should
 * have one instance of this class */

public class GeneratorOptions  {
	private String outputPath; 
	private String templateName;
	private String templateDir;
	private String outputFileName;
	private Boolean overwrite;
	private String filePackage;
	
	/**
	 * @param outputPath The directory the generated code will go in
	 * @param templateName Name of the ftl template
	 * @param templateDir Name of the directory inside "resources" in which the ftl template is located in
	 * @param outputFileName Base name of the output files
	 * @param overwrite Overwrite any conflicting files
	 * @param filepackage Name of the output files package/directory
	 */
	public GeneratorOptions(String outputPath, String templateName,
			String templateDir, String outputFileName, Boolean overwrite,
			String filePackage) {
		super();
		this.outputPath = outputPath;
		this.templateName = templateName;
		this.templateDir = templateDir;
		this.outputFileName = outputFileName;
		this.overwrite = overwrite;
		this.filePackage = filePackage;
	}

	public String getOutputPath() {
		return outputPath;
	}

	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTemplateDir() {
		return templateDir;
	}

	public void setTemplateDir(String templateDir) {
		this.templateDir = templateDir;
	}

	public String getOutputFileName() {
		return outputFileName;
	}

	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}

	public Boolean getOverwrite() {
		return overwrite;
	}

	public void setOverwrite(Boolean overwrite) {
		this.overwrite = overwrite;
	}

	public String getFilePackage() {
		return filePackage;
	}

	public void setFilePackage(String filePackage) {
		this.filePackage = filePackage;
	}
	
	
}
