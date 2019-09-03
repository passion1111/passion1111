package com.bit.tiles;

import java.util.ArrayList;
import java.util.List;

// Tiles 에서 정의해서 --> prepare로 
import org.apache.tiles.AttributeContext;
import org.apache.tiles.context.TilesRequestContext;
import org.apache.tiles.preparer.ViewPreparer;

public class MenuItemView implements ViewPreparer {

	@Override
	public void execute(TilesRequestContext tilesContext, 
			AttributeContext attributeContext) {
		
		List<MenuItem> userMenus = new ArrayList<MenuItem>();
		
		userMenus.add(new MenuItem("menu_1", "link_1"));
		userMenus.add(new MenuItem("menu_2", "link_2"));
		userMenus.add(new MenuItem("menu_3", "link_3"));
		
		tilesContext.getRequestScope().put("userMenus", userMenus);
	}

}







