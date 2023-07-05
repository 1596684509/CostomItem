package xiao_student.costomitem.Event;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import xiao_student.costomitem.Item.ItemEnum;

import java.util.Random;

import static org.bukkit.Bukkit.getPlayer;

public class OnAttackAttributesEvent implements Listener {

    @EventHandler
    public void onAttackEvent(EntityDamageByEntityEvent event) {

        if(event.getDamager() instanceof Player) {

            Player player = ((Player) event.getDamager()).getPlayer();


            event.setDamage(getCritDamage(event, player));
            attackHeal(player);
            suckBlood(event, player);

        }

    }



    private double getCritDamage(EntityDamageEvent event, Player player) {

        ItemStack itemStack = player.getInventory().getItemInMainHand();
        int crit = 0;
        double critDamage = 1.0;
        crit += ItemEnum.getItemCrit(itemStack);
        double damage = event.getDamage();
        if(isCrit(crit)) {

            critDamage += ItemEnum.getItemCritDamage(itemStack) / 100;
            damage *= critDamage;
            player.sendMessage("你造成了: " + damage + "点暴击伤害");

        }else {

            player.sendMessage("你造成了: " + damage + "点伤害");

        }

        return damage;

    }

    private boolean isCrit(int crit) {

        Random random = new Random();
        int critNum = random.nextInt(100);
        if(critNum <= crit) {

            return true;

        }

        return false;

    }

    private void attackHeal(Player player) {

        ItemStack itemStack = player.getInventory().getItemInMainHand();
        int heal = ItemEnum.getItemAttackHeal(itemStack);

        if(player.getHealth() + heal <= player.getMaxHealth()) {

            player.setHealth(player.getHealth() + heal);

        }else {

            player.setHealth(player.getMaxHealth());

        }

        if(heal > 0) {

            player.sendMessage(ChatColor.YELLOW + "攻击回复： " + heal + "血");

        }

    }

    private void suckBlood(EntityDamageByEntityEvent event, Player player) {

        double damamge = event.getDamage();
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        double suckBlood = ItemEnum.getItemSuckBlood(itemStack) / 100;
        double heal = damamge * suckBlood;

        if(player.getHealth() + heal <= player.getMaxHealth()) {

            player.setHealth(player.getHealth() + heal);

        }else {

            player.setHealth(player.getMaxHealth());

        }

        player.sendMessage(ChatColor.YELLOW + "吸血： " + heal + "血");

    }

}
