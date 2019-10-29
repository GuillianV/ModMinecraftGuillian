package com.guillian.modguillian.items.bow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.guillian.modguillian.Main;
import com.guillian.modguillian.entity.rubyArrow.EntityRubyArrow;
import com.guillian.modguillian.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RubyBow extends BowBase {

	public RubyBow(String name) {
		super(name);

	}

	public int ARROWINSTANCIATE = 1;

	@Override
	protected boolean isArrow(ItemStack stack) {

		if (stack.getItem() == ModItems.RUBY_ARROW) {
			return true;
		} else if (stack.getItem() == Items.ARROW) {
			return true;
		}
		return false;

	}

	private ItemStack findAmmo(EntityPlayer player) {
		if (this.isArrow(player.getHeldItem(EnumHand.OFF_HAND))) {
			return player.getHeldItem(EnumHand.OFF_HAND);
		} else if (this.isArrow(player.getHeldItem(EnumHand.MAIN_HAND))) {
			return player.getHeldItem(EnumHand.MAIN_HAND);
		} else {
			for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
				ItemStack itemstack = player.inventory.getStackInSlot(i);

				if (this.isArrow(itemstack)) {
					return itemstack;
				}
			}

			return ItemStack.EMPTY;
		}
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
		EntityArrow[] ArrowList = new EntityArrow[ARROWINSTANCIATE];
		ItemArrow[] ItemarrowList = new ItemArrow[ARROWINSTANCIATE];
		ItemStack[] ItemStack = new ItemStack[ARROWINSTANCIATE];
		if (entityLiving instanceof EntityPlayer) {
			for (int a = 0; a < ARROWINSTANCIATE; a++) {
				EntityPlayer entityplayer = (EntityPlayer) entityLiving;
				boolean flag = entityplayer.capabilities.isCreativeMode
						|| EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;

				ItemStack[a] = this.findAmmo(entityplayer);

				int i = this.getMaxItemUseDuration(stack) - timeLeft;
				i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, entityplayer, i,
						!ItemStack[a].isEmpty() || flag);
				if (i < 0)
					return;

				if (!ItemStack[a].isEmpty() || flag) {
					if (ItemStack[a].isEmpty()) {
						ItemStack[a] = new ItemStack(Items.ARROW);
					}

					float f = getArrowVelocity(i);

					if ((double) f >= 0.1D) {

						boolean flag1 = entityplayer.capabilities.isCreativeMode
								|| (ItemStack[a].getItem() instanceof ItemArrow && ((ItemArrow) ItemStack[a].getItem())
										.isInfinite(ItemStack[a], stack, entityplayer));

						if (!worldIn.isRemote) {
							ItemarrowList[a] = (ItemArrow) (ItemStack[a].getItem() instanceof ItemArrow
									? ItemStack[a].getItem()
									: Items.ARROW);
							ArrowList[a] = (EntityRubyArrow) ItemarrowList[a].createArrow(worldIn, ItemStack[a],
									entityplayer);
							// entityplayer.rotationPitch
							// entityplayer.rotationYaw

							ArrowList[a].shoot(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F,
									f * 3.0F, 1.0F);

							if (f == 1.0F) {
								ArrowList[a].setIsCritical(true);

							}

							int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);

							if (j > 0) {
								ArrowList[a].setDamage(ArrowList[a].getDamage() + (double) j * 0.5D + 0.5D);
							}

							int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);

							if (k > 0) {
								ArrowList[a].setKnockbackStrength(k);
							}

							if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0) {
								ArrowList[a].setFire(100);
							}

							stack.damageItem(1, entityplayer);

							if (flag1 || entityplayer.capabilities.isCreativeMode
									&& (ItemStack[a].getItem() == Items.SPECTRAL_ARROW
											|| ItemStack[a].getItem() == Items.TIPPED_ARROW)) {
								ArrowList[a].pickupStatus = EntityArrow.PickupStatus.CREATIVE_ONLY;
							}
							System.out.println(ArrowList[a]);

							ArrowList[a].setNoGravity(flag1);
							worldIn.spawnEntity(ArrowList[a]);

							// ArrowList[a].world.createExplosion(ArrowList[a],
							// ArrowList[a].posX,ArrowList[a].posY + (double)(ArrowList[a].height / 16.0F),
							// ArrowList[a].posZ,4.0F, true);

						}

						worldIn.playSound((EntityPlayer) null, entityplayer.posX, entityplayer.posY, entityplayer.posZ,
								SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F,
								1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

						if (!flag1 && !entityplayer.capabilities.isCreativeMode) {
							ItemStack[a].shrink(1);

							if (ItemStack[a].isEmpty()) {
								entityplayer.inventory.deleteStack(ItemStack[a]);
							}
						}

						entityplayer.addStat(StatList.getObjectUseStats(this));
					}

				}
			}
		}
	}

}
