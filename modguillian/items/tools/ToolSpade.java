package com.guillian.modguillian.items.tools;

import com.guillian.modguillian.Main;
import com.guillian.modguillian.init.ModItems;
import com.guillian.modguillian.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSpade;

public class ToolSpade extends ItemSpade implements IHasModel{
	
	public ToolSpade(String name, ToolMaterial material) {
		
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.TOOLS);
		
		ModItems.ITEMS.add(this);
	}
	
	
	@Override
	public void registerModels() {
		
		Main.proxy.registerItemRenderer(this,0,"inventory");
		
	}

}
