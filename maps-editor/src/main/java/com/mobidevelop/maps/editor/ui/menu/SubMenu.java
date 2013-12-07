package com.mobidevelop.maps.editor.ui.menu;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.parallel;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.scaleTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;

public class SubMenu extends WidgetGroup {

	Skin skin;

	Table table;

	MenuItem menuItem;

	int direction = 0;

	public SubMenu(Skin skin) {
		this.skin = skin;
		super.addActor(table = new Table(skin));
		table.top().left();
		table.defaults().left().pad(5);
		addListener(new InputListener() {
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				if (event.getTarget().isDescendantOf(SubMenu.this)) {
					if (event.getTarget() != SubMenu.this) {
						MenuItem item = (MenuItem)event.getTarget().getParent();
						final SubMenu menu = (SubMenu)item.getSubMenu();
						if (menu != null) {
							if (menu.getParent() != null) return true;
							menu.show(getStage());
							return true;
						}	
					}
				}
				hide();
				return false;
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
		table.row();
		return item;
	}

	public SubMenu addSubMenu(CharSequence title) {
		MenuItem item = new MenuItem(title, skin);
		table.add(item).fill();
		table.row();
		SubMenu menu = new SubMenu(skin);
		menu.setMenuItem(item);
		item.setSubMenu(menu);
		menu.direction = 1;
		return menu;
	}

	@Override
	public Actor hit (float x, float y, boolean touchable) {
		Actor actor = super.hit(x, y, touchable);
		return actor != null ? actor : this;
	}

	public void show(Stage stage) {
		Vector2 v = new Vector2();
		menuItem.localToStageCoordinates(v);
		if (direction == 0) {
			this.setPosition(v.x, v.y - this.getHeight());
			this.setOriginY(this.getHeight());
			this.setColor(1, 1, 1, 0);
			this.setScale(1,0);
			this.addAction(parallel(fadeIn(0.15f), scaleTo(1, 1, 0.15f)));			
		} else {
			this.setPosition(v.x + menuItem.getWidth() + 5, v.y + menuItem.getHeight() - this.getHeight());
			this.setColor(1, 1, 1, 0);
			this.setScale(0,1);
			this.addAction(parallel(fadeIn(0.15f), scaleTo(1, 1, 0.15f)));
		}
		stage.addActor(this);
	}

	public void hide() {
		if (direction == 0) {
			addAction(sequence(parallel(fadeOut(0.15f), scaleTo(1, 0, 0.15f)), Actions.removeActor()));			
		} else {
			addAction(sequence(parallel(fadeOut(0.15f), scaleTo(0, 1, 0.15f)), Actions.removeActor()));
		}
	}

	public void setMenuItem (MenuItem menuItem) {
		this.menuItem = menuItem;
	}

}
