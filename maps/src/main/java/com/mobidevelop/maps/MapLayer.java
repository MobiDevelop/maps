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

public interface MapLayer {

	public Map getMap();

	public void setMap(Map map);

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

	public boolean getVisible();

	public void setVisible(boolean visible);

	public MapObjects getObjects();

	public MapProperties getProperties();

}
