package com.guillian.modguillian.items.arrows;

import com.guillian.modguillian.Main;
import com.guillian.modguillian.init.ModItems;
import com.guillian.modguillian.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArrow;

public class ArrowBase extends ItemArrow implements IHasModel {

	public ArrowBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.COMBAT);
		this.maxStackSize = 64;
		
		
		ModItems.ITEMS.add(this);
		
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this,0,"inventory");
		
	}
	
	
}
