package xiao_student.costomitem.Sword;


import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xiao_student.costomitem.Util.SkillCD;

public abstract class ItemSuperClass implements ItemInterface{

    protected ItemMeta itemMeta;
    protected ItemStack itemStack;
    protected int crit;
    protected double critDamage;
    protected int attackHeal;
    protected int suckBlood;
    protected SkillCD skillCD;

    public abstract void setItemMeta();

    @Override
    public ItemStack getItemStack() {
        return itemStack;
    }

    @Override
    public int getCrit() {
        return crit;
    }

    @Override
    public double getCritDamage() {
        return critDamage;
    }

    @Override
    public int getAttackHeal() {
        return attackHeal;
    }

    @Override
    public double getSuckBlood() {
        return suckBlood;
    }

    public SkillCD getSkillCD() {

        if(skillCD == null) {

            skillCD = new SkillCD();

        }

        return skillCD;
    }

}
