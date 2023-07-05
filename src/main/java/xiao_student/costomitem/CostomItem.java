package xiao_student.costomitem;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import xiao_student.costomitem.Event.OnAttackAttributesEvent;
import xiao_student.costomitem.Event.OnInventoryClickEvent;
import xiao_student.costomitem.Event.OnRightClickEvent;

import java.util.Objects;

public final class CostomItem extends JavaPlugin {

    private static CostomItem costomItem;
    @Override
    public void onEnable() {

        costomItem = this;
        System.out.print("CostomItem: -------------插件已经加载---------");
        Objects.requireNonNull(Bukkit.getPluginCommand("costomitem")).setExecutor(new Commander());
        getServer().getPluginManager().registerEvents(new OnAttackAttributesEvent(), this);
        getServer().getPluginManager().registerEvents(new OnRightClickEvent(), this);
        getServer().getPluginManager().registerEvents(new OnInventoryClickEvent(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        getServer().savePlayers();
        System.out.print("CostomItem: -------------插件已经卸载---------");


    }

    public static CostomItem getCostomItem() {
        return costomItem;
    }
}
