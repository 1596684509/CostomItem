package xiao_student.costomitem;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import xiao_student.costomitem.Item.ItemEnum;

public class Commander implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label,  String[] args) {

        if(!(sender instanceof Player)) {

            sender.sendMessage(ChatColor.RED + "此命令仅玩家可用");
            return true;
        }

        if(args.length == 0) {

            return true;

        }

        switch (args[0]) {

            case "gethelp":
                sendHelp(sender);
                break;

            case "get":
                if(args[1] == null) {

                    sender.sendMessage(ChatColor.RED + "命令参数错误: /costomitem getItem <item name>");

                }
                getItem(args[1], sender);
                break;

            case "damage":
                ((Player) sender).damage(19);

        }

        return true;
    }

    private void getItem(String itemName, CommandSender sender) {

        Player player = (Player) sender;
        ItemStack itemStack = ItemEnum.nameToItem(ItemEnum.valueOf(itemName));
        if(itemStack == null) {

            sender.sendMessage(ChatColor.RED + ("未知物品，请检查名字是否错误"));
            return;

        }
        player.getInventory().addItem(itemStack);
        sender.sendMessage(ChatColor.YELLOW + itemStack.getItemMeta().getDisplayName() + "已经添加到背包");

    }

    private void sendHelp(CommandSender sender) {


        sender.sendMessage(ChatColor.YELLOW + "/costomitem get <item name>: 获取物品");


    }

}
