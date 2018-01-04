package com.sn.entity.system;

public class State {
	private Boolean opened;
	private Boolean selected;
	 
	public State(){
		opened=true; 
		selected=false;
	}

	public Boolean getOpened() {
		return opened;
	}

	public void setOpened(Boolean opened) {
		this.opened = opened;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
}
