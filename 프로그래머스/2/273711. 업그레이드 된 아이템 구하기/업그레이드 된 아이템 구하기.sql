select i.item_id, i.item_name, i.rarity
from item_info item, item_tree tree, item_info i
where item.item_id = tree.parent_item_id and item.rarity = "RARE"
and i.item_id = tree.item_id
order by 1 desc;