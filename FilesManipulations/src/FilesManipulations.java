import connectors.ConnectorJDBC;
import container.ActionsContainer;
import handles.ActionHandler;


public class FilesManipulations {

	public static void main(String[] args) {
		System.out.println("Name of the source file: "+args[0]);
		System.out.println("Name of the result file: "+args[1]);
		System.out.println("An action name to perform: "+args[2]);
		
		String source=args[0];
		String dest=args[1];
		String action=args[2];


		ActionsContainer actionsContainer = new ActionsContainer();

		// Upcast. Will be executed the overrided methods
		try {
			ActionHandler actionHandler = actionsContainer.checkIfExists(action);
			actionHandler.execute(source, dest);
			ConnectorJDBC connector = new ConnectorJDBC();
			connector.insert(action, source, dest);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.exit(0);
	}

}
