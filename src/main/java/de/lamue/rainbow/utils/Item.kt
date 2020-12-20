package de.lamue.rainbow.utils

import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.LeatherArmorMeta
import org.bukkit.potion.Potion
import org.bukkit.potion.PotionType
import java.util.*


object Item {

    fun addLore(i: ItemStack, s: String) {
        if (i.itemMeta!!.lore == null) {
            var lore: ArrayList<String> = ArrayList()
            lore.add(s)
            val imeta = i.itemMeta
            imeta!!.setLore(lore)
            i.itemMeta = imeta
        } else {
            var lore: ArrayList<String> = i.itemMeta!!.lore as ArrayList<String>
            lore!!.add(s)
            val imeta = i.itemMeta
            imeta!!.setLore(lore)
            i.itemMeta = imeta
        }
    }

    fun createItem(mat: Material?, amount: Int, shortid: Int, DisplayName: String?): ItemStack? {
        val i = ItemStack(mat!!, amount, shortid.toShort())
        val meta = i.itemMeta
        meta!!.setDisplayName(DisplayName)
        i.itemMeta = meta
        return i
    }

    fun createItemLore(
        material: Material?, anzahl: Int, metadata: Int, displayname: String?,
        lore: String
    ): ItemStack {
        val item = ItemStack(material!!, anzahl, metadata.toShort())
        val meta = item.itemMeta
        meta!!.setDisplayName(displayname)
        meta.lore = Arrays.asList(*arrayOf(lore))
        item.itemMeta = meta
        return item
    }

    fun createItemLore2Enchant(
        material: Material?, anzahl: Int, metadata: Int, displayname: String?,
        lore: String, lore2: String, enchant: Enchantment?, stärke: Int
    ): ItemStack? {
        val item = ItemStack(material!!, anzahl, metadata.toShort())
        val meta = item.itemMeta
        meta!!.setDisplayName(displayname)
        meta.lore = Arrays.asList(*arrayOf(lore, lore2))
        meta.addEnchant(enchant!!, stärke, true)
        item.itemMeta = meta
        return item
    }

    fun createItemLore2Enchant2(
        material: Material?, anzahl: Int, metadata: Int, displayname: String?,
        lore: String, lore2: String, enchant: Enchantment?, stärke: Int, enchant2: Enchantment?, stärke2: Int
    ): ItemStack? {
        val item = ItemStack(material!!, anzahl, metadata.toShort())
        val meta = item.itemMeta
        meta!!.setDisplayName(displayname)
        meta.lore = Arrays.asList(*arrayOf(lore, lore2))
        meta.addEnchant(enchant!!, stärke, true)
        meta.addEnchant(enchant2!!, stärke2, true)
        item.itemMeta = meta
        return item
    }

    fun createItemEnchant2(
        material: Material?, anzahl: Int, metadata: Int, displayname: String?,
        enchant: Enchantment?, stärke: Int, enchant2: Enchantment?, stärke2: Int
    ): ItemStack? {
        val item = ItemStack(material!!, anzahl, metadata.toShort())
        val meta = item.itemMeta
        meta!!.setDisplayName(displayname)
        meta.addEnchant(enchant!!, stärke, true)
        meta.addEnchant(enchant2!!, stärke2, true)
        item.itemMeta = meta
        return item
    }

    @Throws(NullPointerException::class)
    fun getCardinalDirection(player: Player): Int {
        var rotation = ((player.location.yaw - 90) % 360).toDouble()
        if (rotation < 0) rotation += 360.0
        return if (0 <= rotation && rotation < 67.5) 10 // NorthWest
        else if (67.5 <= rotation && rotation < 112.5) 2 // North
        else if (112.5 <= rotation && rotation < 157.5) 10 // NorthEeast
        else if (157.5 <= rotation && rotation < 202.5) 3 // East
        else if (202.5 <= rotation && rotation < 247.5) 10 // SouthEast
        else if (247.5 <= rotation && rotation < 292.5) 0 // South
        else if (292.5 <= rotation && rotation < 337.5) 10 // SouthWest
        else if (337.5 <= rotation && rotation < 360.0) 1 // West
        else 10
    }

    fun createItemEnchant(
        material: Material?, anzahl: Int, metadata: Int, displayname: String?,
        enchant: Enchantment?, stärke: Int
    ): ItemStack? {
        val item = ItemStack(material!!, anzahl, metadata.toShort())
        val meta = item.itemMeta
        meta!!.setDisplayName(displayname)
        meta.addEnchant(enchant!!, stärke, true)
        item.itemMeta = meta
        return item
    }

    fun createItemEnchantNotVisible(
        material: Material?,
        anzahl: Int,
        metadata: Int,
        displayname: String?,
        enchant: Enchantment?,
        stärke: Int
    ): ItemStack? {
        val item = ItemStack(material!!, anzahl, metadata.toShort())
        val meta = item.itemMeta
        meta!!.setDisplayName(displayname)
        meta.addEnchant(enchant!!, stärke, false)
        item.itemMeta = meta
        return item
    }

    fun createItemLore2(
        material: Material?, anzahl: Int, metadata: Int, displayname: String?,
        lore: String, lore2: String
    ): ItemStack? {
        val item = ItemStack(material!!, anzahl, metadata.toShort())
        val meta = item.itemMeta
        meta!!.setDisplayName(displayname)
        meta.lore = Arrays.asList(*arrayOf(lore, lore2))
        item.itemMeta = meta
        return item
    }

    fun createItemLore3(
        material: Material?, anzahl: Int, metadata: Int, displayname: String?,
        lore: String, lore2: String, lore3: String
    ): ItemStack? {
        val item = ItemStack(material!!, anzahl, metadata.toShort())
        val meta = item.itemMeta
        meta!!.setDisplayName(displayname)
        meta.lore = Arrays.asList(*arrayOf(lore, lore2, lore3))
        item.itemMeta = meta
        return item
    }

    fun createItemLore4(
        material: Material?, anzahl: Int, metadata: Int, displayname: String?,
        lore: String, lore2: String, lore3: String, lore4: String
    ): ItemStack? {
        val item = ItemStack(material!!, anzahl, metadata.toShort())
        val meta = item.itemMeta
        meta!!.setDisplayName(displayname)
        meta.lore = Arrays.asList(*arrayOf(lore, lore2, lore3, lore4))
        item.itemMeta = meta
        return item
    }

    fun createLeather(
        mat: Material?, amount: Int, shortid: Int, color: Color?, DisplayName: String?,
        lore: String, lore2: String
    ): ItemStack? {
        val i = ItemStack(mat!!, amount, shortid.toShort())
        val meta = i.itemMeta as LeatherArmorMeta?
        meta!!.setDisplayName(DisplayName)
        meta.setColor(color)
        meta.lore = Arrays.asList(*arrayOf(lore, lore2))
        i.itemMeta = meta
        return i
    }

    fun createItemBlock(mat: Material?, amount: Int, shortid: Int, DisplayName: String?): ItemStack? {
        return ItemStack(mat!!, amount, shortid.toShort())
    }

    fun createPotionLore2(
        pt: PotionType?,
        amount: Int,
        werfbar: Boolean,
        DisplayName: String?,
        lore1: String,
        lore2: String
    ): ItemStack? {
        val stack = ItemStack(Material.POTION, amount)
        val meta = stack.itemMeta
        meta!!.setDisplayName(DisplayName)
        meta.lore = Arrays.asList(*arrayOf(lore1, lore2))
        stack.itemMeta = meta
        val pot0 = Potion(pt!!, 2)
        pot0.isSplash = werfbar
        pot0.apply(stack)
        return stack
    }

    fun createPotionLore1(
        pt: PotionType?,
        amount: Int,
        werfbar: Boolean,
        DisplayName: String?,
        lore1: String
    ): ItemStack? {
        val stack = ItemStack(Material.POTION, amount)
        val meta = stack.itemMeta
        meta!!.setDisplayName(DisplayName)
        meta.lore = Arrays.asList(*arrayOf(lore1))
        stack.itemMeta = meta
        val pot0 = Potion(pt!!, 2)
        pot0.isSplash = werfbar
        pot0.apply(stack)
        return stack
    }

    fun clearInv(p: Player) {
        p.inventory.clear()
        p.inventory.setArmorContents(null)
        for (pe in p.activePotionEffects) p.removePotionEffect(pe.type)
    }

    fun createLeather2(mat: Material?, amount: Int, shortid: Int, color: Color?, DisplayName: String?): ItemStack? {
        val i = ItemStack(mat!!, amount, shortid.toShort())
        val meta = i.itemMeta as LeatherArmorMeta?
        meta!!.setDisplayName(DisplayName)
        meta.setColor(color)
        i.itemMeta = meta
        return i
    }

    fun fillInventory(inv: Inventory, filling: ItemStack?) {
        for (i in 0 until inv.size) inv.setItem(i, filling)
    }

    fun fillinvwithid(inv: Inventory, item: ItemStack?, startzahl: Int, endzahl: Int) {
        var startzahl = startzahl
        val start = startzahl
        while (start < endzahl) {
            inv.setItem(start, item)
            startzahl++
        }
    }

    fun giveDefaultItems(p: Player) {
        val buyer = createItemLore(Material.ENDER_CHEST, 1, 0, "§6§lKapazität", "§7Erweitere deine Kapazität")
        val effects = createItemLore(Material.BLAZE_ROD, 1, 0, "§e§lEffekte", "§7Hebe dich von anderen ab")
        p.inventory.setItem(3, buyer)
        p.inventory.setItem(5, effects)
    }

}