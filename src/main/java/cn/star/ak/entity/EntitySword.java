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
    private int delay;
    @Override
    public void tick()
    {
        super.tick();
        if (this.delay > 0) {
            this.delay--;
        } else {
            this.kill();
        }
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    @Override
    public void rideTick()
    {
    }

}
