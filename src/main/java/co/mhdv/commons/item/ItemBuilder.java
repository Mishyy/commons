package co.mhdv.commons.item;

import co.mhdv.commons.text.Color;
import com.google.common.base.Preconditions;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ItemBuilder {

    private final ItemStack itemStack;
    private final ItemMeta itemMeta;

    private ItemBuilder(Material material) {
        this(new ItemStack(material, 1));
    }

    private ItemBuilder(ItemStack itemStack) {
        this.itemStack = itemStack;
        this.itemMeta = itemStack.getItemMeta();
    }

    public ItemBuilder of(ItemStack itemStack) {
        return new ItemBuilder(itemStack);
    }

    public ItemBuilder of(Material material) {
        return new ItemBuilder(material);
    }

    public ItemBuilder name(String name) {
        this.itemMeta.setDisplayName(Color.toColor(name));
        return this;
    }

    public ItemBuilder lore(String... lines) {
        final List<String> lore = Arrays.stream(lines).map(Color::toColor).collect(Collectors.toList());
        this.itemMeta.getLore().addAll(lore);
        return this;
    }

    public ItemBuilder amount(int amount) {
        this.itemStack.setAmount(amount);
        return this;
    }

    public ItemBuilder durability(int durability) {
        this.itemStack.setDurability((short) durability);
        return this;
    }

    public ItemBuilder type(Material material) {
        this.itemStack.setType(material);
        return this;
    }

    public ItemBuilder enchants(Map<Enchantment, Integer> enchantments) {
        enchantments.forEach(itemStack::addUnsafeEnchantment);
        return this;
    }

    public ItemBuilder enchant(Enchantment enchantment, int level) {
        this.itemStack.addUnsafeEnchantment(enchantment, level);
        return this;
    }

    public ItemBuilder flags(ItemFlag... flags) {
        this.itemMeta.addItemFlags(flags);
        return this;
    }

    public ItemBuilder unbreakable(boolean unbreakable) {
        this.itemMeta.setUnbreakable(unbreakable);
        return this;
    }

    public ItemStack build() {
        Preconditions.checkNotNull(this.itemStack, getClass().getName().concat("#of must be called before other methods in this class."));
        this.itemStack.setItemMeta(this.itemMeta);
        return this.itemStack;
    }

}
