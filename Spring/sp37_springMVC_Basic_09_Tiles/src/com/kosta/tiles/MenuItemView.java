package com.kosta.tiles;

import java.util.ArrayList;
import java.util.List;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.context.TilesRequestContext;   // tiles 2.1.2 버전임
import org.apache.tiles.preparer.ViewPreparer;

//Tiles 에서 정의에서 > preparer 로
public class MenuItemView implements ViewPreparer {

	@Override
	public void execute(TilesRequestContext tilescontext, AttributeContext attrcontext) {
		List<MenuItem> userMenus = new ArrayList<MenuItem>();
		userMenus.add(new MenuItem("menu_1", "link_1"));
		userMenus.add(new MenuItem("menu_2", "link_2"));
		userMenus.add(new MenuItem("menu_3", "link_3"));
		tilescontext.getRequestScope().put("userMenus",userMenus);
	}

}
