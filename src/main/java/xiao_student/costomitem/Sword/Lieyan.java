package xiao_student.costomitem.Sword;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Lieyan extends ItemSuperClass{

    public Lieyan() {

        itemStack = new ItemStack(Material.GOLDEN_SWORD);
        setItemMeta();
        itemStack.setItemMeta(itemMeta);

    }

    public void setItemMeta() {

        critDamage = 50;
        crit = 40;
        attackHeal = 10;
        suckBlood = 5;

        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GOLD + "绝剑-" + ChatColor.RED + "[烈焰]");
        itemMeta.setLore(setLore());
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, setModifier());
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.setUnbreakable(true);

    }

    private AttributeModifier setModifier() {

        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "test", 99, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        return modifier;

    }

    private List<String> setLore() {

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.YELLOW + "===============-[属性]-===============");
        lore.add(ChatColor.GRAY + "品质: " + ChatColor.RED + "绝世");
        lore.add(ChatColor.GRAY + "类型: 主手武器");
        lore.add(ChatColor.GRAY + "攻击: 100");
        lore.add(ChatColor.GRAY + "暴击率: "+ crit +"%");
        lore.add(ChatColor.GRAY + "暴击伤害: "+ critDamage +"%");
        lore.add(ChatColor.GRAY + "攻击回复: "+ attackHeal);
        lore.add(ChatColor.GRAY + "吸血: "+ suckBlood +"%");
        lore.add(ChatColor.YELLOW + "===============-[介绍]-===============");
        lore.add(ChatColor.GRAY + "一把不知从何而来的剑");
        lore.add(ChatColor.GRAY + "无数铁匠尝试复刻它的力量");
        lore.add(ChatColor.GRAY + "却无人得以成功");
        lore.add(ChatColor.GRAY + "因而得名[绝剑]");
        lore.add(ChatColor.YELLOW + "===============-[技能]-===============");
        lore.add(ChatColor.GRAY + "对附近5格范围内的敌人造成 100 点伤害    CD：20s");
        lore.add(ChatColor.MAGIC + "=====================================");

        return lore;

    }

}
