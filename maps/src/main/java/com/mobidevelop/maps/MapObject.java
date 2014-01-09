/*******************************************************************************
 * Copyright 2013 See AUTHORS File
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.mobidevelop.maps;

/**
 * The {@code MapObject} interface represents an object in a {@link Map}. In its
 * simplest form, a MapObject only represents a "thing" that has a position and
 * size in the Map. It is up to the implementation to define the specifics.
 * <p>
 * A MapObject can be positioned and sized in a MapLayer according to the
 * MapLayer's coordinate system.
 *
 * @author Justin Shapcott
 */
public interface MapObject {

	public MapLayer getLayer();

	public void setLayer(MapLayer layer);

	public String getName();

	public void setName(String name);
	
	public float getX();

	public void setX(float x);

	public float getY();

	public void setY(float y);

	public float getWidth();

	public void setWidth(float width);

	public float getHeight();

	public void setHeight(float height);

	public float getOriginX();

	public void setOriginX(float originX);

	public float getOriginY();

	public void setOriginY(float originY);

	public float getRotation();

	public void setRotation(float rotation);

	public boolean isVisible();

	public void setVisible(boolean visible);

	public MapProperties getProperties();

}
