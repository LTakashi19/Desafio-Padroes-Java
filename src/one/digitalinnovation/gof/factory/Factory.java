class Dialog is
		abstract method createButton():Button


		method render() is
		Button okButton = createButton()

		okButton.onClick(closeDialog)
		okButton.render()


class WindowsDialog extends Dialog is
		method createButton():Button is
		return new WindowsButton()

class WebDialog extends Dialog is
		method createButton():Button is
		return new HTMLButton()

class LinuxDialog extends Dialog is
		method createButton():Button is
		return new LinuxButton()

class IosDialog extends Dialog is
		method createButton():Button is
		return new IosButton()

class AndroidDialog extends Dialog is
		method createButton():Button is
		return new AndroidButton()


interface Button is
		method render()
		method onClick(f)

class WindowsButton implements Button is
		method render(a, b) is
		method onClick(f) is

class HTMLButton implements Button is
		method render(a, b) is
		method onClick(f) is

class LinuxButton implements Button is
		method render(a, b) is
		method onClick(f) is

class IosButton implements Button is
		method render(a, b) is
		method onClick(f) is

class AndroidButton implements Button is
		method render(a, b) is
		method onClick(f) is




class Application is
		field dialog: Dialog


		method initialize() is
		config = readApplicationConfigFile()

		if (config.OS == "Windows") then
		dialog = new WindowsDialog()
		else if (config.OS == "Web") then
		dialog = new WebDialog()
		else if (config.OS == "Linux") then
		dialog = new LinuxDialog()
		else if (config.OS == "Ios") then
		dialog = new IosDialog()
		else if (config.OS == "Android") then
		dialog = new AndroidDialog()
		else
		throw new Exception("Erro!, sistema desconhecido")
		method main() is
		this.initialize()
		dialog.render()