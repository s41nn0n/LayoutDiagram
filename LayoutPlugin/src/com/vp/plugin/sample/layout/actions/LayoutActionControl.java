package com.vp.plugin.sample.layout.actions;

import com.vp.plugin.ApplicationManager;
import com.vp.plugin.DiagramManager;
import com.vp.plugin.action.VPAction;
import com.vp.plugin.action.VPActionController;
import com.vp.plugin.diagram.IDiagramUIModel;
import com.vp.plugin.diagram.LayoutOption$DirectedTree;
import com.vp.plugin.diagram.LayoutOption$Hierarchical;
import com.vp.plugin.diagram.LayoutOption$Orthogonal;
import com.vp.plugin.diagram.LayoutOption$Orientation;

public class LayoutActionControl implements VPActionController {

	@Override
	public void performAction(VPAction arg0) {
		// Obtain DiagramManager from ApplicationManager 
// 		DiagramManager diagramManager = ApplicationManager.instance().getDiagramManager(); 
// 		IDiagramUIModel diagram = diagramManager.getActiveDiagram();
		
		IProject project = ApplicationManager.instance().getProjectManager().getProject();
		IDiagramUIModel[] diagrams = project.toDiagramArray();
		for (int diagram : diagrams){
			// Initialize different LayoutOptions
// 			LayoutOption$Orthogonal orthogonalLayoutOption = diagramManager.createOrthogonalLayoutOption();
// 			orthogonalLayoutOption.setLayoutGridSize(100);

			LayoutOption$Hierarchical hierarchicalLayoutOption = diagramManager.createHierarchicalLayoutOption();
			hierarchicalLayoutOption.setMinimumConnectorDistance(10);
			hierarchicalLayoutOption.setMinimumLayerDistance(20);
			hierarchicalLayoutOption.setMinimumShapeDistance(30);

// 			LayoutOption$DirectedTree directedTreeLayoutOption = diagramManager.createDirectedTreeLayoutOption();
// 			directedTreeLayoutOption.setMinimumLaterDistance(50);
// 			directedTreeLayoutOption.setMinimumShapeDistance(50);
// 			directedTreeLayoutOption.setOrientation(LayoutOption$Orientation.TopToBottom);

			diagramManager.openAndLayoutDiagram(diagram, hierarchicalLayoutOption);
// 			// Generate random number to perform different layout 
// 			int min = 0;
// 			int max = 2;
// 			int range = max - min + 1;

// 			int rand = (int) (Math.random() * range) + min;
// 			System.out.println("rand: " + rand);
// 			switch (rand) {
// 				//passing different option to perform layout
// 				case 0: diagramManager.openAndLayoutDiagram(diagram, orthogonalLayoutOption);
// 						break;

// 				case 1: diagramManager.openAndLayoutDiagram(diagram, hierarchicalLayoutOption);
// 						break;

// 				case 2: diagramManager.openAndLayoutDiagram(diagram, directedTreeLayoutOption);
// 						break;
// 			}	
		}
	}		

	@Override
	public void update(VPAction arg0) {
		// TODO Auto-generated method stub
		
	}

}
