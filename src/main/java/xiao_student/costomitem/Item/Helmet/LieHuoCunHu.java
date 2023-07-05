package xiao_student.costomitem.Item.Helmet;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import xiao_student.costomitem.Item.ItemSuperClass;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LieHuoCunHu extends ItemSuperClass {

    public LieHuoCunHu() {

        itemStack = new ItemStack(Material.GOLDEN_HELMET);
        itemMeta = itemStack.getItemMeta();
        setItemMeta();

    }

    @Override
    public void setItemMeta() {

        crit = 5;
        critDamage = 25;

        itemMeta.setDisplayName(ChatColor.RED + "烈火村护-头盔");
        itemMeta.setLore(setLore());
        itemMeta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH ,setModifier(149, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD));
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, setModifier(9, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD));
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.setUnbreakable(true);

        itemStack.setItemMeta(itemMeta);

    }

    private AttributeModifier setModifier(int amount, AttributeModifier.Operation attributeModifier, EquipmentSlot equipmentSlot) {

        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "test", amount, attributeModifier, equipmentSlot);
        return modifier;

    }

    private List<String> setLore() {

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.YELLOW + "===============-[属性]-===============");
        lore.add(ChatColor.GRAY + "品质: " + ChatColor.RED + "绝世");
        lore.add(ChatColor.GRAY + "类型: 头盔");
        lore.add(ChatColor.GRAY + "攻击: 10");
        lore.add(ChatColor.GRAY + "生命值: 150");
        lore.add(ChatColor.GRAY + "暴击率: "+ crit +"%");
        lore.add(ChatColor.GRAY + "暴击伤害: "+ critDamage +"%");
        lore.add(ChatColor.YELLOW + "===============-[介绍]-===============");
        lore.add(ChatColor.YELLOW + "===============-[套装]-===============");
        lore.add(ChatColor.GRAY + "===> 烈火村护-头盔");
        lore.add(ChatColor.GRAY + "===> 烈火村护-护甲");
        lore.add(ChatColor.GRAY + "===> 烈火村护-护腿");
        lore.add(ChatColor.GRAY + "===> 烈火村护-战靴");
        lore.add(ChatColor.MAGIC + "=====================================");

        return lore;

    }



}
