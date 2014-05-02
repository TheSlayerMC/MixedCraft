package com.MixedCraft.items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.MixedCraft.helper.ManaHelper;

public class WandOfGrowth extends ItemBaseWand {

	public static int cooldown = 10;
	
	public static int defaultCharges = 100;
	
	public WandOfGrowth() {
        this.setMaxDamage(defaultCharges + 1);
	}

	@Override 
	public int getUseCost() {
		return 1;
	}

	@Override 
	public int getBaseRepairCost() {
		return 7;
	}
	
	@Override public boolean onItemUse(ItemStack srcItemStack, EntityPlayer playerEntity, World world, int targetX, int targetY, int targetZ, int par7, float par8, float par9, float par10){
		if (!playerEntity.capabilities.isCreativeMode)
        {
        	if(isOutOfCharge(srcItemStack)){

        		playSound(noChargeAttackSound,world,playerEntity);
        		return true;
        	}
        }
		boolean success = growBlock(playerEntity,world,targetX,targetY,targetZ);
		if(success){
			if (!playerEntity.capabilities.isCreativeMode)
	        {
	        	srcItemStack.damageItem(getUseCost(), playerEntity);
	        }
		}
		return success;
		
	}
	
	protected boolean growBlock(EntityPlayer playerEntity, World world, int targetX, int targetY, int targetZ){

		Block target = world.getBlock(targetX, targetY, targetZ);
		ItemStack fauxItemStack = new ItemStack(Items.dye);
		
		if(target == Blocks.cactus && ManaHelper.useBar(10)){

			int y = targetY + 1;
			while(world.getBlock(targetX, y, targetZ) == Blocks.cactus){
				y++;
			}
			if(world.getBlock(targetX, y, targetZ) != null){
				world.setBlock(targetX, y, targetZ, Blocks.cactus);
			}
			return true;
		} else if(target == Blocks.reeds && ManaHelper.useBar(10)){

			int y = targetY+1;
			while(world.getBlock(targetX, y, targetZ) == Blocks.reeds){
				y++;
			}
			if(world.getBlock(targetX, y, targetZ) != null){

				world.setBlock(targetX, y, targetZ, Blocks.reeds);
			}
			return true;
		} else if(target == Blocks.cobblestone && ManaHelper.useBar(10)){

			world.setBlock(targetX, targetY, targetZ, Blocks.mossy_cobblestone);
			return true;
		} else if(target == Blocks.stonebrick && ManaHelper.useBar(10)){
			if( world.getBlockMetadata(targetX, targetY, targetZ) == 0){

				world.setBlockMetadataWithNotify(targetX, targetY, targetZ, 1, 3);
				return true;
			}
		}
		return ItemDye.applyBonemeal(fauxItemStack, world, targetX, targetY, targetZ, playerEntity);
	}
}