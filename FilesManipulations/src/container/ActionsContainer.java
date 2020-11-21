package container;

import java.util.HashMap;
import java.util.Map;

import handles.ActionHandler;
import handles.ActionReverseImp;
import handles.ActionShuffleImp;
import handles.ActionSortImpl;

public class ActionsContainer {

	Map<String, ActionHandler> actionsList;

	// Each new action should be added to the actionsList
	public ActionsContainer() {
		super();
		actionsList = new HashMap<String, ActionHandler>();
		actionsList.put(new ActionSortImpl().getName(), new ActionSortImpl());
		actionsList.put(new ActionShuffleImp().getName(), new ActionShuffleImp());
		actionsList.put(new ActionReverseImp().getName(), new ActionReverseImp());

	}

	public ActionHandler checkIfExists(String action) throws Exception {

		if (actionsList.get(action) instanceof ActionSortImpl) {
			System.out.println("The action is sort");
			return new ActionSortImpl();
		}
		if (actionsList.get(action) instanceof ActionShuffleImp) {
			System.out.println("The action is shuffle");
			return new ActionShuffleImp();
		}
		if (actionsList.get(action) instanceof ActionReverseImp) {
			System.out.println("The action is reverse");
			return new ActionReverseImp();
		} else
			throw new Exception("There is no such action: " + action + ". Please enter correct action");

	}

}
