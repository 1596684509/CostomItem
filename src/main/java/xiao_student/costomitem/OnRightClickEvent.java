package xiao_student.costomitem;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
import top.zoyn.particlelib.pobject.Arc;
import xiao_student.costomitem.Particle.ParticlePlayalble;
import xiao_student.costomitem.Particle.Ring;
import xiao_student.costomitem.Sword.ItemEnum;
import xiao_student.costomitem.Sword.ItemInterface;
import xiao_student.costomitem.Util.SkillCD;

import java.util.List;


public class OnRightClickEvent implements Listener {

    @EventHandler
    public void onRightClickSkill(PlayerInteractEvent event) {

        Player player = event.getPlayer();

        ItemEnum itemEnum = ItemEnum.getItemType(player.getInventory().getItemInMainHand());

        if((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) && itemEnum != null) {

            event.setCancelled(true);
            switch (itemEnum) {

                case lieyan:
                    lieyanOnRightClickSkill(player, itemEnum);
                    break;

            }

        }

    }

    private void lieyanOnRightClickSkill(Player player, ItemEnum itemEnum) {

        Entity playerEntity = player;
        List<Entity> entities = playerEntity.getNearbyEntities(5, 5, 5);
        SkillCD skillCD = itemEnum.getItemInterface().getSkillCD();

        if(!skillCD.isCDOver()) {

            player.sendMessage(ChatColor.RED + "技能还有 " + skillCD.getCD() + " 秒冷却时间");
            return;
        }

        for (Entity entity : entities) {

            if(entity != player) {

                if(entity instanceof LivingEntity) {


                    Location location = entity.getLocation();
                    Ring ring = new Ring(location, 1.5, 0, 0);
                    double entityHeight = entity.getHeight();

                    new BukkitRunnable() {

                        double i = entityHeight;


                        @Override
                        public void run() {

                            ring.setY(i);
                            ParticlePlayalble particleInterface = ring.getParticle();
                            particleInterface.particlePlay();
                            i -= 0.4;

                            if(i <= 0) {

                                ((LivingEntity) entity).damage(100, player);
                                this.cancel();

                            }


                        }
                    }.runTaskTimer(CostomItem.getCostomItem(), 0l, 2);

                    player.sendMessage(ChatColor.YELLOW + "发动技能对附近的" + entity.getName() + "造成伤害");
                    skillCD.setCD(20);
                    skillCD.cdStart();



                }

            }

        }


//            if(oldLocation.getX() - targetLocation.getX() <= fanwei && oldLocation.getY() - targetLocation.getY() <= fanwei && oldLocation.getZ() - targetLocation.getZ() <= fanwei && entity != player) {
//
//                Damageable damageable = (Damageable) entity;
//                damageable.damage(100, player);
//                player.sendMessage(ChatColor.YELLOW + "发动技能对附近的" + entity.getName() + "造成10点伤害");
//
//            }

    }

}
