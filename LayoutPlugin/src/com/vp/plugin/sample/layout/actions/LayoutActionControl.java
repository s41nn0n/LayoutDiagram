package com.vp.plugin.sample.layout.actions;

 

import com.vp.plugin.ApplicationManager;

import com.vp.plugin.DiagramManager;

import com.vp.plugin.action.VPAction;

import com.vp.plugin.action.VPActionController;

import com.vp.plugin.diagram.IDiagramUIModel;

import com.vp.plugin.diagram.LayoutOption$DirectedTree;

import com.vp.plugin.diagram.LayoutOption$Hierarchical;

import com.vp.plugin.diagram.LayoutOption$Orthogonal;

import com.vp.plugin.model.IProject;

import com.vp.plugin.diagram.LayoutOption$Orientation;

 

public class LayoutActionControl implements VPActionController {

 

       @Override

       public void performAction(VPAction arg0) {

		DiagramManager diagramManager = ApplicationManager.instance().getDiagramManager();

		LayoutOption$Hierarchical hierarchicalLayoutOption = diagramManager.createHierarchicalLayoutOption();

		hierarchicalLayoutOption.setMinimumConnectorDistance(10);

		hierarchicalLayoutOption.setMinimumLayerDistance(20);

		hierarchicalLayoutOption.setMinimumShapeDistance(30);
	       
		IProject project = ApplicationManager.instance().getProjectManager().getProject();

		IDiagramUIModel[] diagrams = project.toDiagramArray();

		for (IDiagramUIModel diagram : diagrams){

			diagramManager.openAndLayoutDiagram(diagram, hierarchicalLayoutOption);

		}

       }           

 

       @Override

       public void update(VPAction arg0) {

             // TODO Auto-generated method stub

            

       }

 

}

