package com.zhongxin.home.testfor_cnc.event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Walter on 2015/9/29.
 */
public class Item {
    public String id;
    public String content;

    public static List<Item> ITEMS = new ArrayList<Item>();

    public static List<Item> ITEMS2 = new ArrayList<Item>();
    static
    {
        // Add 6 sample items.
        addItem(new Item("1", "Item 1"));
        addItem(new Item("2", "Item 2"));
        addItem(new Item("3", "Item 3"));
        addItem(new Item("4", "Item 4"));
        addItem(new Item("5", "Item 5"));
        addItem(new Item("6", "Item 6"));

        addItem2(new Item("111","Item111"));
        addItem2(new Item("222","Item222"));
        addItem2(new Item("333","Item333"));
        addItem2(new Item("444","Item444"));
        addItem2(new Item("555","Item555"));
        addItem2(new Item("666","Item666"));
        addItem2(new Item("777","Item777"));
        addItem2(new Item("888","Item888"));
        addItem2(new Item("999","Item999"));
    }

    private static void addItem(Item item)
    {
        ITEMS.add(item);
    }

    private static void addItem2(Item item){
      ITEMS2.add(item);
    }

    public Item(String id, String content)
    {
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString()
    {
        return content;
    }
}
