package bb.handlers;

import org.eclipse.core.internal.resources.File;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;

public class SampleHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		ISelection s = HandlerUtil.getCurrentSelection(event);
		if (s != null && s instanceof TreeSelection) {
			String b = ((TreeSelection)s).getFirstElement().getClass().getName();
			File f;
		//	if (((TreeSelection)s).getFirstElement().getClass().getSimpleName().contains("File")) 
				f = (File)((TreeSelection)s).getFirstElement();
			MessageDialog.openInformation(
					window.getShell(),
					"Bb",
					"Hello, Eclipse world"+f.getLocation()+"   "+f.getProject().getFullPath()+f.getFullPath()+f.getProjectRelativePath());
			
		
		}
		else
		MessageDialog.openInformation(
				window.getShell(),
				"Bb",
				"Hello, Eclipse world"+s);
		return null;
	}
}
