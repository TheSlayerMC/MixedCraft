package com.MixedCraft.entity;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

import com.MixedCraft.BlockHelper;
import com.MixedCraft.blocks.container.ContainerCowSheep;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityCowSheep extends EntityAnimal implements IShearable
{
    private final InventoryCrafting field_90016_e = new InventoryCrafting(new ContainerCowSheep(this), 2, 1);

    private int CowSheepTimer;

    private EntityAIEatGrass aiEatGrass = new EntityAIEatGrass(this);

    public EntityCowSheep(World par1World)
    {
        super(par1World);
        this.setSize(0.9F, 1.3F);
        float f = 0.23F;
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 0.38F));
        this.tasks.addTask(2, new EntityAIMate(this, f));
        this.tasks.addTask(3, new EntityAITempt(this, 0.25F, Items.wheat, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 0.25F));
        this.tasks.addTask(5, this.aiEatGrass);
        this.tasks.addTask(6, new EntityAIWander(this, f));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
    }
    protected boolean isAIEnabled()
    {
        return true;
    }

    protected void updateAITasks()
    {
        this.CowSheepTimer = this.aiEatGrass.func_151499_f();
        super.updateAITasks();
    }
    
    public void onLivingUpdate()
    {
        if (this.worldObj.isRemote)
        {
            this.CowSheepTimer = Math.max(0, this.CowSheepTimer - 1);
        }

        super.onLivingUpdate();
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D);
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
    }

    protected void dropFewItems(boolean par1, int par2)
    {
        if (!this.getSheared())
        {
            this.entityDropItem(new ItemStack(BlockHelper.cowSheepWool, 1, this.getFleeceColor()), 0.0F);
        }
    }

    protected Item getDropItem()
    {
        return Item.getItemFromBlock(BlockHelper.cowSheepWool);
    }

    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte par1)
    {
        if (par1 == 10)
        {
            this.CowSheepTimer = 40;
        }
        else
        {
            super.handleHealthUpdate(par1);
        }
    }

    @SideOnly(Side.CLIENT)
    public float func_70894_j(float par1)
    {
        return this.CowSheepTimer <= 0 ? 0.0F : (this.CowSheepTimer >= 4 && this.CowSheepTimer <= 36 ? 1.0F : (this.CowSheepTimer < 4 ? ((float)this.CowSheepTimer - par1) / 4.0F : -((float)(this.CowSheepTimer - 40) - par1) / 4.0F));
    }

    @SideOnly(Side.CLIENT)
    public float func_70890_k(float par1)
    {
        if (this.CowSheepTimer > 4 && this.CowSheepTimer <= 36)
        {
            float f1 = ((float)(this.CowSheepTimer - 4) - par1) / 32.0F;
            return ((float)Math.PI / 5F) + ((float)Math.PI * 7F / 100F) * MathHelper.sin(f1 * 28.7F);
        }
        else
        {
            return this.CowSheepTimer > 0 ? ((float)Math.PI / 5F) : this.rotationPitch / (180F / (float)Math.PI);
        }
    }

    public boolean interact(EntityPlayer par1EntityPlayer)
    {
        return super.interact(par1EntityPlayer);
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setBoolean("Sheared", this.getSheared());
        par1NBTTagCompound.setByte("Color", (byte)this.getFleeceColor());
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setSheared(par1NBTTagCompound.getBoolean("Sheared"));
        this.setFleeceColor(par1NBTTagCompound.getByte("Color"));
    }

    protected String getLivingSound()
    {
        return "mob.cow.say";
    }

    protected String getHurtSound()
    {
        return "mob.cow.hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.cow.hurt";
    }

    /**
     * Plays step sound at given x, y, z for the entity
     */
    protected void playStepSound(int par1, int par2, int par3, int par4)
    {
        this.playSound("mob.sheep.step", 0.15F, 1.0F);
    }

    public int getFleeceColor()
    {
        return this.dataWatcher.getWatchableObjectByte(16) & 15;
    }

    public void setFleeceColor(int par1)
    {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);
        this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & 240 | par1 & 15)));
    }

    /**
     * returns true if a CowSheeps wool has been sheared
     */
    public boolean getSheared()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 16) != 0;
    }

    /**
     * make a CowSheep sheared if set to true
     */
    public void setSheared(boolean par1)
    {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);

        if (par1)
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 16)));
        }
        else
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & -17)));
        }
    }

    /**
     * This method is called when a CowSheep spawns in the world to select the color of CowSheep fleece.
     */
    public static int getRandomFleeceColor(Random par0Random)
    {
        int i = par0Random.nextInt(100);
        return i < 5 ? 15 : (i < 10 ? 7 : (i < 15 ? 8 : (i < 18 ? 12 : (par0Random.nextInt(500) == 0 ? 6 : 0))));
    }

    public EntityCowSheep func_90015_b(EntityAgeable par1EntityAgeable)
    {
        EntityCowSheep entityCowSheep = (EntityCowSheep)par1EntityAgeable;
        EntityCowSheep entityCowSheep1 = new EntityCowSheep(this.worldObj);
        return entityCowSheep1;
    }

    /**
     * This function applies the benefits of growing back wool and faster growing up to the acting entity. (This
     * function is used in the AIEatGrass)
     */
    public void eatGrassBonus()
    {
        this.setSheared(false);

        if (this.isChild())
        {
            int i = this.getGrowingAge() + 1200;

            if (i > 0)
            {
                i = 0;
            }

            this.setGrowingAge(i);
        }
    }



    

    public EntityCowSheep spawnBabyAnimal(EntityAgeable par1EntityAgeable)
    {
        return new EntityCowSheep(this.worldObj);
    }

    public EntityAgeable createChild(EntityAgeable par1EntityAgeable)
    {
        return this.spawnBabyAnimal(par1EntityAgeable);
    }
    
    protected boolean canDespawn() {
        return false;
    }
    
	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
		return !getSheared() && !isChild();
	}
	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        setSheared(true);
        int i = 1 + rand.nextInt(3);
        for (int j = 0; j < i; j++) {
            ret.add(new ItemStack(BlockHelper.cowSheepWool, 1, getFleeceColor()));
        }
        this.worldObj.playSoundAtEntity(this, "mob.sheep.shear", 1.0F, 1.0F);
        return ret;
	}
}
