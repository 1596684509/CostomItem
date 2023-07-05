package xiao_student.costomitem.Item;

import org.bukkit.inventory.ItemStack;
import xiao_student.costomitem.Util.SkillCD;

public interface ItemInterface {

    public ItemStack getItemStack();
    public int getCrit();
    public double getCritDamage();
    public int getAttackHeal();
    public double getSuckBlood();
    public SkillCD getSkillCD();

}
