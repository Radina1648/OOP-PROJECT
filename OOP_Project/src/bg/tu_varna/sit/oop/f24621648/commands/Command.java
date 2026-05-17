package bg.tu_varna.sit.oop.f24621648.commands;

/**
 * Интерфейс за всички команди в приложението.
 */

public interface Command {
	/**
	 * Изпълнява команда.
	 *
	 * @param input входна команда
	 */

	void execute(String input);
}