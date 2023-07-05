package xiao_student.costomitem.Util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
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

    public CheckSet(Player player, ItemInterface itemInOffHand, ItemInterface itemInMainHand, ItemInterface itemInHead, ItemInterface itemInBody, ItemInterface itemInRetreat, ItemInterface itemInFoot) {
        this.player = player;
        this.itemInOffHand = itemInOffHand;
        this.itemInMainHand = itemInMainHand;
        this.itemInHead = itemInHead;
        this.itemInBody = itemInBody;
        this.itemInRetreat = itemInRetreat;
        this.itemInFoot = itemInFoot;
    }

    public CheckSet(Player player, ItemInterface itemInMainHand, ItemInterface itemInHead) {

        ItemStack mainHand = player.getInventory().getItemInMainHand();
        ItemStack head = player.getInventory().getItem(EquipmentSlot.HEAD);
        player.sendMessage("你关闭了背包");

        if(mainHand == itemInMainHand.getItemStack()) {

            ItemMeta itemMeta = mainHand.getItemMeta();
            List lore = itemMeta.getLore();
            lore.set(9, ChatColor.GOLD + "===> 绝剑-[烈焰]");
            lore.set(10, ChatColor.GOLD + "===> 烈火村护-头盔");
            itemMeta.setLore(lore);
            mainHand.setItemMeta(itemMeta);

        }

    }
}
