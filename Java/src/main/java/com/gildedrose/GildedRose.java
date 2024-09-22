package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
           doTheJob(item);
    }}
    // la methode doTheJob fais le update de chaque Item
    void doTheJob(Item item){
       updateFirstBloc(item);
       updateSecondBloc(item);
       if(sellIn(item)){
      updateThirdBloc(item);}
    }
    private void updateFirstBloc(Item item) {
        if (item.name.equals("Aged Brie")){

            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
            else if( item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {

            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.sellIn < 11) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }

                if (item.sellIn < 6) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
            else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        } else if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
    private void updateSecondBloc(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        item.sellIn --;
    }
    private void updateThirdBloc(Item item) {
        if (item.name.equals("Aged Brie")) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
        else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = 0;
        } else if (item.quality > 0) {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                return;
            }
            item.quality = item.quality - 1;
        }

    }
private Boolean sellIn(Item item){
        return item.sellIn<0;
}
}
