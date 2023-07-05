package xiao_student.costomitem.Util;

import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import xiao_student.costomitem.Item.ItemEnum;
import xiao_student.costomitem.Item.ItemInterface;

import java.util.ArrayList;
import java.util.List;

public class CheckSet {

    private Player player;
    private ItemInterface itemInOffHand;
    private ItemInterface itemInMainHand;
    private ItemInterface itemInHead;

    private ItemInterface itemInBody;
    private ItemInterface itemInRetreat;
    private ItemInterface itemInFoot;

    private boolean isSet = false;

    public CheckSet(Player player, ItemEnum itemInHand, ItemEnum itemInHead) {

        ItemStack mainHand = player.getInventory().getItemInMainHand();
        ItemStack head = player.getInventory().getItem(EquipmentSlot.HEAD);

        if(mainHand == null || head == null) {

            return;

        }

        ItemMeta itemMeta = head.getItemMeta();
        player.sendMessage("你点击了背包");

        if(ItemEnum.getTag(itemInHead.getItemInterface().getItemStack()).equals(ItemEnum.getTag(head))) {

            player.sendMessage("这是个套装");

            List lore = itemMeta.getLore();
            lore.set(9, ChatColor.GOLD + "===> 绝剑-[烈焰]");
            lore.set(10, ChatColor.GOLD + "===> 烈火村护-头盔");
            itemMeta.setLore(lore);
            head.setItemMeta(itemMeta);

        }

    }
}
