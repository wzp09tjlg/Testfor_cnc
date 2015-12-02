package com.zhongxin.home.testfor_cnc.event;

import java.util.List;

/**
 * Created by Walter on 2015/9/29.
 */
public class Event {
    /** 列表加载事件 */
    public static class ItemListEvent
    {
        private List<Item> items;

        public ItemListEvent(List<Item> items)
        {
            this.items = items;
        }

        public List<Item> getItems()
        {
            return items;
        }
    }
}
