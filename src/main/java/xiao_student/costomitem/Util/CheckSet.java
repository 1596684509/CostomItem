package xiao_student.costomitem.Util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import xiao_student.costomitem.Item.ItemEnum;

import java.util.List;

public class CheckSet {

    private Player player;
    private ItemStack mainHand;
    private ItemStack offHand;
    private ItemStack head;
    private ItemStack chest;
    private ItemStack leg;
    private ItemStack foot;

    public CheckSet(Player player) {

        this.player = player;

    }


    public boolean itemEquals(ItemStack item1, ItemStack item2) {

        ItemMeta item1Meta;
        ItemMeta item2Meta;
        String item1tag = null;
        String item2tag = null;

        if(item1 != null && item2 != null) {

            item1tag = ItemEnum.getTag(item1);
            item2tag = ItemEnum.getTag(item2);

            if(item1tag.equals(item2tag)) {

                return true;

            }

        }

        return false;

    }

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
