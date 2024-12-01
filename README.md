FAMILY FIX-UP

a game by
Cora Bangert,
Meagan Callahan,
Adam Kuhn,
and Gage LeFevre

...

File Structure:


This game was coded in Java and uses JavaFX. 

The game's code is split up throughout several .java files, and utilizes visuals packaged in a separate folder of images included in the project.

...

Compilation Instructions:


This game requires the installation of both Java and JavaFX. 

If you do not have either of these installed, please follow the instructions at https://openjfx.io/openjfx-docs/


First, open Command Prompt.


You can either search for it in your taskbar or open the run prompt with the Windows key + R, then type "cmd" or "cmd.exe" and hit enter.


In Command Prompt, change your directory to the src folder within the FinalGame folder. 

	Example: cd C:\"replace with path to folder on your system"\FinalGame\src


Next, compile the program using the javac command. This will create a new .class file which will allow you to run the game.

	Example: javac --module-path "replace with path to your JavaFX lib folder" --add-modules javafx.controls,javafx.fxml WebsiteTemplate.java


Finally, use the java command to run the game.

	Example: java --module-path "replace with path to your JavaFX lib folder" --add-modules javafx.controls,javafx.fxml WebsiteTemplate


If the game files are all in their correct directories and the instructions have been followed as written, the game will open.
