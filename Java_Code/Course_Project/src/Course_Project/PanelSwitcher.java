package Course_Project;

public class PanelSwitcher {

	public void EnterNetMode() {
		// TODO Auto-generated method stub
		Vars.connectionpanel.SetEditable();
		Vars.gameframe.BeginNetMode();
	}

	public void BackToMain() {
		// TODO Auto-generated method stub
		Vars.gameframe.BackToMainPanel();
	}

	public void ToGameWindow() {
		// TODO Auto-generated method stub
		Vars.gameframe.BeginNetGame();
	}
	
	public void ToWatchWindow(){
		Vars.gameframe.BeginWatching();
	}
	
	public void ToHistoryWindow(){
		Vars.gameframe.BeginHistory();
	}
	
}
