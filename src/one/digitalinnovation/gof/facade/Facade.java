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


// A interface do produto declara as operações que todos os
// produtos concretos devem implementar.
interface Button is
		method render()
		method onClick(f)

// Produtos concretos fornecem várias implementações da
// interface do produto.
class WindowsButton implements Button is
		method render(a, b) is
		// Renderiza um botão no estilo Windows.
		method onClick(f) is
// Vincula um evento de clique do SO nativo.

class HTMLButton implements Button is
		method render(a, b) is
		// Retorna uma representação HTML de um botão.
		method onClick(f) is
// Vincula um evento de clique no navegador web.


class Application is
		field dialog: Dialog

		// A aplicação seleciona um tipo de criador dependendo da
		// configuração atual ou definições de ambiente.
		method initialize() is
		config = readApplicationConfigFile()

		if (config.OS == "Windows") then
		dialog = new WindowsDialog()
		else if (config.OS == "Web") then
		dialog = new WebDialog()
		else
		throw new Exception("Error! Unknown operating system.")

		// O código cliente trabalha com uma instância de um criador
		// concreto, ainda que com sua interface base. Desde que o
		// cliente continue trabalhando com a criadora através da
		// interface base, você pode passar qualquer subclasse da
		// criadora.
		method main() is
		this.initialize()
		dialog.render()