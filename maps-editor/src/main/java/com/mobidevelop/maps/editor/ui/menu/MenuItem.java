package com.mobidevelop.maps.editor.ui.menu;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;

public class MenuItem extends WidgetGroup {

	private Skin skin;

	private Label label;

	private SubMenu subMenu;

	public MenuItem(Skin skin) {
		super();
		this.skin = skin;
	}

	public MenuItem(CharSequence title, Skin skin) {
		super();
		this.skin = skin;
		super.addActor(label = new Label(title, skin));
	}

	@Override
	public float getPrefWidth () {
		return label.getPrefWidth();
	}

	@Override
	public float getPrefHeight () {
		return label.getPrefHeight();
	}

	public SubMenu getSubMenu() {
		return subMenu;
	}

	void setSubMenu(SubMenu subMenu) {
		this.subMenu = subMenu;
	}

}
