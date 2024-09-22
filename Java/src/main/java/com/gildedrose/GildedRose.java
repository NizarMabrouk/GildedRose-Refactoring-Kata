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

            increaseQuality(item);
        }
            else if( item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {

            increaseQuality(item);
                if (item.sellIn < 11) {
                    increaseQuality(item);
                }

                if (item.sellIn < 6) {
                    increaseQuality(item);
                }

        }
            else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        } else decreaseQuality(item);
    }
    private void updateSecondBloc(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        item.sellIn --;
    }
    private void updateThirdBloc(Item item) {
        if (item.name.equals("Aged Brie")) {
            increaseQuality(item);
        }
        else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = 0;
        } else {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                return;
            }
            decreaseQuality(item);
        }

    }

    private void decreaseQuality(Item item) {
        if (item.quality>0) {
            item.quality = item.quality - 1;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private Boolean sellIn(Item item){
        return item.sellIn<0;
}
}
