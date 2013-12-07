package com.mobidevelop.maps.editor.ui.menu;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Menu extends WidgetGroup {

	Skin skin;

	Table table;

	public Menu(Skin skin) {
		this.skin = skin;
		super.addActor(table = new Table(skin));
		table.center().left();
		table.defaults().padLeft(5).padRight(20);
		addListener(new ClickListener() {
			@Override
			public void clicked (InputEvent event, float x, float y) {
				if (event.getTarget().getParent() instanceof MenuItem) {
					MenuItem item = (MenuItem)event.getTarget().getParent();
					final SubMenu menu = (SubMenu)item.getSubMenu();
					if (menu.getParent() != null) return;
					menu.show(getStage());
				}
			}
		});
	}

	@Override
	public float getPrefWidth () {
		return table.getPrefWidth();
	}

	@Override
	public float getPrefHeight () {
		return table.getPrefHeight();
	}

	@Override
	public void layout () {
		table.setWidth(getWidth());
		table.setHeight(getHeight());
		table.invalidate();
		table.validate();
	}

	public MenuItem addItem(CharSequence title) {
		MenuItem item = new MenuItem(title, skin);
		table.add(item).fill();
		return item;
	}

	public SubMenu addSubMenu(CharSequence title) {
		MenuItem item = new MenuItem(title, skin);
		table.add(item).fill();
		SubMenu menu = new SubMenu(skin);
		menu.setName(title.toString());
		menu.setMenuItem(item);
		item.setSubMenu(menu);		
		return menu;
	}

}
