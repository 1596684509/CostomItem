package xiao_student.costomitem.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import xiao_student.costomitem.Item.ItemEnum;
import xiao_student.costomitem.Util.CheckSet;

public class OnInventoryCloseEvent implements Listener {

    @EventHandler
    public void onClick(InventoryInteractEvent event) {

        CheckSet checkSet = new CheckSet((Player) event.getWhoClicked(), ItemEnum.lieyan.getItemInterface(), ItemEnum.liehuocunhuT.getItemInterface());

    }

}
