package xiao_student.costomitem.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import xiao_student.costomitem.Item.ItemEnum;
import xiao_student.costomitem.Util.CheckSet;

public class OnInventoryClickEvent implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        CheckSet checkSet = new CheckSet((Player) event.getWhoClicked(), ItemEnum.lieyan, ItemEnum.liehuocunhuT);

    }

}
