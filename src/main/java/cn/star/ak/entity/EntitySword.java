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
    }
    public static EntitySword createInstance(PlayMessages.SpawnEntity packet, Level worldIn) {
        return new EntitySword(AKEntiteRegristrys.EntitySwordS, worldIn);
    }
    @Override
    public void tick()
    {

    }

    @Override
    public void rideTick()
    {
    }

}
