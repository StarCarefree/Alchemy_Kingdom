package cn.star.ak.entity;

import cn.star.ak.regsitry.AKEntiteRegristrys;
import mods.flammpfeil.slashblade.entity.EntityAbstractSummonedSword;
import mods.flammpfeil.slashblade.entity.Projectile;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.PlayMessages;

public class EntitySword extends EntityAbstractSummonedSword {
    public EntitySword(EntityType<? extends Projectile> entityTypeIn, Level worldIn) {
        super(entityTypeIn, worldIn);
        this.noCulling = true;
    }
    public static EntitySword createInstance(PlayMessages.SpawnEntity packet, Level worldIn) {
        return new EntitySword(AKEntiteRegristrys.EntitySwordS, worldIn);

    }


    @Override
    public void baseTick() {

        super.baseTick();
    }

    @Override
    public void tick()
    {
        if (getPersistentData().getInt("lifeTick") >1){
            getPersistentData().putInt("lifeTick",getPersistentData().getInt("lifeTick")-1);

        }else if (getPersistentData().getInt("lifeTick") ==1){
            this.remove(RemovalReason.DISCARDED);
        }
        super.tick();

    }

    public void setDelay(int delay) {

    }

    @Override
    public void rideTick()
    {
        super.rideTick();
    }

}
