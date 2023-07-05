package xiao_student.costomitem.Item;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import xiao_student.costomitem.CostomItem;
import xiao_student.costomitem.Item.Helmet.LieHuoCunHuT;
import xiao_student.costomitem.Item.Sword.Lieyan;

public enum ItemEnum {

    lieyan(new Lieyan(), "lieyan", 0, new NamespacedKey(CostomItem.getCostomItem(), "coustomItem")),
    liehuocunhuT(new LieHuoCunHuT(), "liehuocunhuT", 1, new NamespacedKey(CostomItem.getCostomItem(), "coustomItem"))

    ;
     private final ItemInterface itemStack;
     private final int id;
     private final NamespacedKey namespacedKey;

     private final String tag;

    ItemEnum(ItemInterface itemStack, String tag, int id, NamespacedKey namespacedKey) {
        this.itemStack = itemStack;
        this.tag = tag;
        this.id = id;
        this.namespacedKey = namespacedKey;
    }

    public static ItemStack nameToItem(ItemEnum targetItem) {

        System.out.print("查找物品中....");
        ItemStack targetItemStack = targetItem.itemStack.getItemStack();
        ItemMeta itemMeta = targetItemStack.getItemMeta();
        PersistentDataContainer pd = itemMeta.getPersistentDataContainer();
        pd.set(targetItem.namespacedKey, PersistentDataType.STRING, targetItem.tag);
        targetItemStack.setItemMeta(itemMeta);

        return targetItemStack;

    }

    public ItemInterface getItemInterface() {

        return this.itemStack;

    }

    public static ItemEnum getItemType(ItemStack itemStack) {

        ItemMeta itemMeta = itemStack.getItemMeta();

        if(itemMeta == null) {

            return null;

        }

        PersistentDataContainer pd = itemMeta.getPersistentDataContainer();

        for (ItemEnum value : values()) {

            if(value.tag.equals(pd.get(value.namespacedKey, PersistentDataType.STRING))) {

                return value;

            }

        }

        return null;

    }

    public static int getItemCrit(ItemStack itemStack) {

        ItemMeta itemMeta = itemStack.getItemMeta();

        if(itemMeta == null) {

            return 0;

        }

        PersistentDataContainer pd = itemMeta.getPersistentDataContainer();

        for (ItemEnum value : values()) {

            if(value.tag.equals(pd.get(value.namespacedKey, PersistentDataType.STRING))) {

                return value.itemStack.getCrit();

            }

        }

        return 0;

    }

    public static double getItemCritDamage(ItemStack itemStack) {

        ItemMeta itemMeta = itemStack.getItemMeta();

        if(itemMeta == null) {

            return 0;

        }

        PersistentDataContainer pd = itemMeta.getPersistentDataContainer();

        for (ItemEnum value : values()) {

            if(value.tag.equals(pd.get(value.namespacedKey, PersistentDataType.STRING))) {

                return value.itemStack.getCritDamage();

            }

        }

        return 0;

    }

    public static int getItemAttackHeal(ItemStack itemStack) {

        ItemMeta itemMeta = itemStack.getItemMeta();

        if(itemMeta == null) {

            return 0;

        }

        PersistentDataContainer pd = itemMeta.getPersistentDataContainer();

        for (ItemEnum value : values()) {

            if(value.tag.equals(pd.get(value.namespacedKey, PersistentDataType.STRING))) {

                return value.itemStack.getAttackHeal();

            }

        }

        return 0;

    }

    public static double getItemSuckBlood(ItemStack itemStack) {

        ItemMeta itemMeta = itemStack.getItemMeta();

        if(itemMeta == null) {

            return 0;

        }

        PersistentDataContainer pd = itemMeta.getPersistentDataContainer();

        for (ItemEnum value : values()) {

            if(value.tag.equals(pd.get(value.namespacedKey, PersistentDataType.STRING))) {

                return value.itemStack.getSuckBlood();

            }

        }

        return 0;

    }

    public static String getTag(ItemStack itemStack) {

        if(itemStack == null) {

            return null;

        }

        ItemMeta itemMeta = itemStack.getItemMeta();
        PersistentDataContainer pd = itemMeta.getPersistentDataContainer();
        for (ItemEnum value : values()) {

            if(value.tag.equals(pd.get(value.namespacedKey, PersistentDataType.STRING))) {

                return value.tag;

            }

        }

        return null;

    }
}
