package com.gildedrose;

class GildedRose {
    Item[] items;
private static final String agedBrie = "Aged Brie";
private static final String tAFKAL80ETC = "Backstage passes to a TAFKAL80ETC concert";
private static final String sulfuras = "Sulfuras, Hand of Ragnaros";
private static final String conjured = "Conjured Mana Cake";
    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            doTheJob(item);
        }}
    // la methode doTheJob fais le update de chaque Item
    void doTheJob(Item item) {
        updateQuality(item);   // Met à jour la qualité en fonction du type d'item
        decreaseSellIn(item);  // Décrémente le sellIn (sauf pour Sulfuras)
        if (isExpired(item)) {
            handleExpiredItem(item);  // Gère les items expirés
        }
    }

    private void updateQuality(Item item) {

        if (item.name.equals(agedBrie)) {
            increaseQuality(item);
        }
        else if (item.name.equals(tAFKAL80ETC)) {
            increaseQuality(item);
            if (item.sellIn < 11) {
                increaseQuality(item);  // Augmentation supplémentaire si moins de 10 jours
            }
            if (item.sellIn < 6) {
                increaseQuality(item);  // Augmentation supplémentaire si moins de 5 jours
            }
        } else if (item.name.equals(sulfuras)) {
            // Sulfuras ne change pas de qualité
        } else {
            decreaseQuality(item);  // Pour les autres items
        }
    }

    private void decreaseSellIn(Item item) {
        if (!item.name.equals(sulfuras)) {
            item.sellIn--;
        }
    }

    private void handleExpiredItem(Item item) {
        if (item.name.equals(agedBrie)) {
            increaseQuality(item);  // Aged Brie augmente en qualité après expiration
        }
        else if (item.name.equals(tAFKAL80ETC)) {
            item.quality = 0;  // Les billets de concert tombent à 0 après expiration
        }
        else if (item.name.equals(sulfuras)) {
            // Sulfuras ne change pas après expiration
        }
        else {
            decreaseQuality(item);  // Les autres items perdent de la qualité après expiration
        }
    }
// prend en considération le cas Conjured
    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            if((item.name.equals(conjured))){
                item.quality=item.quality-2;
            }
         else{
            item.quality--;}
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private boolean isExpired(Item item) {
        return item.sellIn < 0;
    }

}
