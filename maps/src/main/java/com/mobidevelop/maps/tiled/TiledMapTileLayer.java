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

package com.mobidevelop.maps.tiled;

import com.mobidevelop.maps.MapLayer;

public interface TiledMapTileLayer extends MapLayer {
	
	public float getTileWidth();
	
	public void setTileWidth(float tileWidth);
	
	public float getTileHeight();
	
	public void setTileHeight(float tileHeight);
	
	public int getWidthInTiles();
	
	public void setWidthInTiles(int widthInTiles);
	
	public int getHeightInTiles();
	
	public void setHeightInTiles(int heightInTiles);
	
	public TiledMapTile getTile(int x, int y);
	
	public void setTile(int x, int y, TiledMapTile tile);
	
	public boolean isFlipX(int x, int y);
	
	public void setFlipX(int x, int y, boolean flipX);
	
	public boolean isFlipY(int x, int y);
	
	public void setFlipY(int x, int y, boolean flipY);
	
	public int getRotation(int x, int y);
	
	public void setRotation(int x, int y, int rotation);
	
}
